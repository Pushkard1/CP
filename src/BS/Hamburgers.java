//371C
//https://codeforces.com/contest/371/problem/C
package BS;

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Math.max;

public class Hamburgers {
    static long nb, ns, nc; // number of the pieces of bread, sausage and cheese on Polycarpus' kitchen
    static long pb, ps, pc; // price of one piece of bread, sausage and cheese in the shop
    static long r; // number of rubles Polycarpus has

    static long b=0,s=0,c=0;
    public static void main(String[] args) {
        try {
            FastReader in=new FastReader();
            FastWriter out = new FastWriter();
            String recipe = in.nextLine();
            nb = in.nextLong();
            ns = in.nextLong();
            nc = in.nextLong();
            pb = in.nextLong();
            ps = in.nextLong();
            pc = in.nextLong();
            r = in.nextLong();


            for (int i=0; i<recipe.length(); i++){
                if (recipe.charAt(i) == 'B') b++;
                else if (recipe.charAt(i) == 'S') s++;
                else c++;

            }


            long low, high, mid, z, ans = 0;
            low =0 ;
            high =r+100;
            while (low<=high){

                mid = (low+high)/2;
                z = price(mid);
                if (z==r){
                    ans = mid;
                    break;
                }
                if (z > r) {
                    high = mid-1;
                }
                else{
                    low = mid + 1;
                    ans = mid;
                }
            }
            out.println(ans);

            out.close();
        } catch (Exception e) {
            return;
        }
    }
//i have nb,nc,ns bread,cheese and sausage
//i need lb,lc,ls to make a single burger, assuming i would make x
//the function returns the extra money needed
    static long price(long x){
        long fb = Math.max(x*b - nb, 0);
        long fc = Math.max(x*c - nc, 0);
        long fs = Math.max(x*s - ns, 0);
        long p = fb*pb + fc*pc + fs*ps;
        return p;
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
