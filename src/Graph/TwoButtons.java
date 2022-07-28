//520B

package Graph;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class TwoButtons {
    public static void main(String[] args) {
        try {
            FastReader in=new FastReader();
            FastWriter out = new FastWriter();
            int n = in.nextInt();
            int m = in.nextInt();
            boolean [] visited = new boolean[100000];
            int [] dist = new int[100000];
            Arrays.fill(dist,-1);
            Queue<Integer> q = new LinkedList<Integer>();
            dist[n]=0;
            q.offer(n);
            while (!q.isEmpty()){
                int x = q.poll();
                if (!visited[x]){
                    visited[x]=true;
                    if (x*2 <= m*2 && !visited[x*2]){
                        if (dist[x*2]==-1) {
                            q.offer(x * 2);
                            dist[x * 2] = dist[x] + 1;
                        }
                    }
                    if (x-1 > 0 && !visited[x-1]){
                        if (dist[x-1]==-1) {
                            q.offer(x - 1);
                            dist[x - 1] = dist[x] + 1;
                        }
                    }
                    if (dist[m] >= 0) break;
                }
            }
            out.println(dist[m]);
            out.close();
        } catch (Exception e) {
            return;
        }
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
