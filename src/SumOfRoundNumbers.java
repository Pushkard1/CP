//1352A
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SumOfRoundNumbers {
    public static void main(String[] args) {
        try {
            FastReader in=new FastReader();
            FastWriter out = new FastWriter();
            int [] arr = new int[10000];
            int testCases=in.nextInt();
            while(testCases-- > 0){
                int n = in.nextInt();
                int d=0,rem=0;
                if (n >= 1000){
                    rem = n%1000;
                    arr[d++] = n-rem;
                    n = n%1000;
                }
                if(n >= 100){
                    rem = n%100;
                    arr[d++] = n-rem;
                    n = n%100;
                }
                if(n >= 10){
                    rem = n%10;
                    arr[d++] = n-rem;
                    n = n%10;
                }
                if(n<10 && n>0){
                    arr[d++] = n;
                }
                ArrayList<Integer> ans = new ArrayList<Integer>();
                for (int i = 0; i<d; i++){
                    ans.add(arr[i]);
                }
                out.println(ans.size());
                for (int i = 0; i< ans.size(); i++){
                    out.print(ans.get(i)+ " ");

                }
                out.print("\r\n");

            }
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
