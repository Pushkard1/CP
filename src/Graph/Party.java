//115A

package Graph;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Party {

    static ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    public static void main(String[] args) {
        try {
            FastReader in=new FastReader();
            FastWriter out = new FastWriter();
            int n=in.nextInt();
            int parent = -1;
            int [] dp = new int [n+1];
            for (int i=0; i<=n; i++){
                res.add(new ArrayList<Integer>());
            }
            for (int i=1; i<=n; i++){
                int node = in.nextInt();
                if (node == -1) addEdge(res, 0, i);
                else addEdge(res, node, i);
            }
            dfs(0,0,dp);
            out.println(dp[0] - 1);

            out.close();
        } catch (Exception e) {
            return;
        }
    }
    static void addEdge(ArrayList<ArrayList<Integer>> res, int u, int v){
        res.get(u).add(v);
    }
    static void dfs(int u,int par, int [] dp){
        dp[u] = 1;
        int x = 0;
        for (int child : res.get(u)){
            if (child == par) continue;
            else {
                dfs(child, u, dp);
                x = Math.max(x, dp[child]);
            }
        }
        dp[u] += x;
    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){
            br=new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while(st==null || !st.hasMoreTokens()){
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt(){
            return Integer.parseInt(next());
        }
        long nextLong(){
            return Long.parseLong(next());
        }
        double nextDouble(){
            return Double.parseDouble(next());
        }
        String nextLine(){
            String str="";
            try {
                str=br.readLine().trim();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    static class FastWriter {
        private final BufferedWriter bw;

        public FastWriter() {
            this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        public void print(Object object) throws IOException {
            bw.append("" + object);
        }

        public void println(Object object) throws IOException {
            print(object);
            bw.append("\n");
        }

        public void close() throws IOException {
            bw.close();
        }
    }

}
