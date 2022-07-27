package Constructive;//510A
import java.io.*;
import java.util.StringTokenizer;

public class FoxAndSnake {
    public static void main(String[] args) {
        try {
            FastReader in=new FastReader();
            FastWriter out = new FastWriter();
            int row = in.nextInt();
            int col = in.nextInt();
            int flag = 0;
            for (int i=0; i<row; i++){
                for (int j=0; j<col; j++){
                    if(i%2 == 0){
                        out.print("#");
                    }
                    else if (i%2 == 1 && flag == 0 ){
                        if (j<col-1) {
                            out.print(".");
                        }else {
                            flag = 1;
                            out.print("#");
                        }
                    }
                    else if (i%2 == 1 && flag == 1){
                        if (j==0) {
                            out.print("#");
                        }
                        else {
                            out.print(".");
                        }
                        if (j==col-1){
                            flag = 0;
                        }
                    }
                }
                out.println("");
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
