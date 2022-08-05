package BS;

import java.io.*;
import java.util.StringTokenizer;

public class Pipeline {
    public static void main(String[] args) {
        try {
            FastReader in=new FastReader();
            FastWriter out = new FastWriter();
            long n=in.nextLong();
            long k=in.nextLong();
            if (n == 1) {
                out.println(0);
                out.close();
                return;
            }
            if (n == k) {
                out.println(1);
                out.close();
                return;
            }
            long l = 2, r = k, ans = -1, OutOfRange=k*(k+1)/2;
            OutOfRange-=k;
            while (l <= r){
                long mid=l+(r-l)/2;
                long temp=OutOfRange-((mid*(mid-1)/2)-mid);
                if(temp>=n){
                    ans=k-(mid-1);
                    l=mid+1;
                }
                else r=mid-1;
            }
            out.println(ans);
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
