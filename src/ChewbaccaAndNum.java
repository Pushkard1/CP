import java.io.*;
import java.util.StringTokenizer;

public class ChewbaccaAndNum {
    public static void main(String[] args) {
        try {
            FastReader in=new FastReader();
            FastWriter out = new FastWriter();
            long num = in.nextLong();
            long m = num;
            int count = 0;
            while (m > 0) {
                count++;
                m /= 10;
            }

            int count1 = 0;
            long[] arr = new long[count];

            for (int i = count - 1; i >= 0; i--) {
                arr[i] = num % 10;
                num /= 10;
            }

            for (int i = 0; i < count; i++) {

                if (9 - arr[i] < arr[i]){
                    if(arr[i] == 9 && i== 0) {
                        arr[i] = 9;
                    }else {
                        arr[i] = 9 - arr[i];
                    }
                }
            }

            for(int i = 0; i < count; i++) {
                if(arr[i] == 0)
                    count1++;
                else
                    break;
            }

            for (int i = count1; i < count; i++) {
                out.print(arr[i]);
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
