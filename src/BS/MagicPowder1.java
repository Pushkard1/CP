//670D1
//https://codeforces.com/contest/670/problem/D1
package BS;

import java.io.*;
import java.util.StringTokenizer;

public class MagicPowder1 {
    static int n,k;
    static  int [] ing,has;
    public static void main(String[] args) {
        try {
            FastReader in=new FastReader();
            FastWriter out = new FastWriter();

            n = in.nextInt(); // number of ingredients
            k = in.nextInt(); // number of magic powder
            ing = new int [n];
            has = new int [n];
            for (int i=0; i<n; i++){
                ing[i] = in.nextInt(); // number of grams of the i-th ingredient, needed to bake one cookie
            }
            for (int i=0; i<n; i++){
                has[i] = in.nextInt(); // number of grams of the i-th ingredient, which Apollinaria has
            }
            int low, high, mid, z, ans = 0;
            low =0 ;
            high =10000;
            while (low<=high){
                mid = (low+high)/2;
                if(bake(mid)){
                    ans = mid;
                    low = mid + 1;
                }
                else high = mid - 1;

            }
            out.println(ans);
            out.close();
        } catch (Exception e) {
            return;
        }
    }
    static boolean bake(int x){
        int res = 0;
        for (int i=0; i<n; i++){
            if (ing[i]*x > has[i]){
                res += ing[i]*x - has[i];
            }
        }
        if (res>k) return false;
        return true;
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
