package AtCoder;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;

public class Main {
    static InputStream is;
    static PrintWriter out;
    static String INPUT = "";
    static List<List<int[]>> poss = new ArrayList<>();

    static boolean debug = !INPUT.isEmpty();

    static int[][][] mats;

    static void solve()
    {
        long S = System.currentTimeMillis();

        int n = ni(), m = ni();
        int sr = ni(), sc = ni();
        char[][] map = nm(n, n);
        for(int i = 0;i < 27;i++)poss.add(new ArrayList<>());
        for(int i = 0;i < n;i++){
            for(int j = 0;j < n;j++){
                poss.get(map[i][j]-'A').add(new int[]{i, j});
            }
        }
        poss.get(26).add(new int[]{sr, sc});

        char[][] ts = nm(m, 5);

        int[][][][] dmats = new int[27][27][][];
        for(int i = 0;i < 27;i++){
            for(int j = 0;j < 27;j++){
                int[][] lmat = new int[poss.get(j).size()][poss.get(i).size()];
                for(int k = 0;k < poss.get(j).size();k++){
                    int[] p = poss.get(j).get(k);
                    for(int l = 0;l < poss.get(i).size();l++){
                        int[] q = poss.get(i).get(l);
                        lmat[k][l] = Math.abs(p[0]-q[0]) + Math.abs(p[1]-q[1]);
                    }
                }
                dmats[i][j] = lmat;
            }
        }

        mats = new int[m][][];
        for(int i = 0;i < m;i++){
            int[][] mat = null;
            for(int j = 0;j < 4;j++){
                int lc = ts[i][j]-'A';
                int rc = ts[i][j+1]-'A';
                int[][] lmat = dmats[lc][rc];
                if(mat == null){
                    mat = lmat;
                }else{
                    mat = mul(lmat, mat);
                }
            }
            mats[i] = mat;
        }

        int[] best = beamSearch(m, ts);


//		int[] a = richGreedy(m, ts);
//		int[] best = Arrays.copyOf(a, m);
//		int bestscore = score(a, map, ts);
//
//		int rep = 0, xrep = 0;
//		while(System.currentTimeMillis() - S < 1750){
//			int l = gen.nextInt(m);
//			int r = gen.nextInt(m);
//			if(l == r)continue;
//			if(l > r){
//				int d = l; l = r; r = d;
//			}
//			for(int i = l, j = r;i < j;i++,j--){
//				int d = a[i]; a[i] = a[j]; a[j] = d;
//			}
//
//			int score = score(a, map, ts);
////			int scoreo = scoreo(a, map, ts);
////			assert score == scoreo;
//			if(score < bestscore){
//				bestscore = score;
//				best = Arrays.copyOf(a, m);
//				xrep++;
//			}else if(score == bestscore) {
//			}else{
//				for(int i = l, j = r;i < j;i++,j--){
//					int d = a[i]; a[i] = a[j]; a[j] = d;
//				}
//			}
//			rep++;
//		}

        if(debug){
            int bestscore = score(best, map, ts);

//			tr("reps: " + rep);
//			tr("xreps: " + xrep);
        }else {
            int[][] route = route(best, map, ts);
            for(int i = 0;i < m;i++){
                if(i == 0){
                    for(int k = 0;k < 5;k++){
                        int[] p = route[i*5+k];
                        out.println(p[0] + " " + p[1]);
                    }
                }else{
                    inner:
                    for(int j = 5;j >= 0;j--){
                        for(int k = 0, l = 5-j;k < j;k++,l++){
                            if(!Arrays.equals(route[i*5-5+l], route[i*5+k])){
                                continue inner;
                            }
                        }
                        for(int k = j;k < 5;k++){
                            int[] p = route[i*5+k];
                            out.println(p[0] + " " + p[1]);
                        }
                        break;
                    }
                }
            }
        }
    }

    static class Datum
    {
        int[] a;
        int score;
        boolean[] done;

        public Datum(int[] a, int score, boolean[] done) {
            this.a = a;
            this.score = score;
            this.done = done;
        }
    }

    static int[] beamSearch(int m, char[][] ts)
    {
        final int W = 4;
        PriorityQueue<Datum> pq = new PriorityQueue<>((x, y) -> -(x.score - y.score));
        pq.add(new Datum(new int[m], 0, new boolean[m]));
        for(int i = 0;i < m;i++){
            PriorityQueue<Datum> npq = new PriorityQueue<>((x, y) -> -(x.score - y.score));
            for(Datum dat : pq){
                for(int j = 0;j < m;j++){
                    if(dat.done[j])continue;
                    int[] na = Arrays.copyOf(dat.a, m);
                    na[i] = j;
                    int score = score(na, i+1, ts);
                    boolean[] ndone = Arrays.copyOf(dat.done, m);
                    ndone[j] = true;
                    npq.add(new Datum(na, score, ndone));
                    if(npq.size() > W)npq.poll();
                }
            }
            pq = npq;
        }
        while(pq.size() > 1)pq.poll();
        assert pq.size() == 1;
        return pq.poll().a;
    }

    static int[] richGreedy(int m, char[][] ts)
    {
        int[] a = new int[m];
        boolean[] done = new boolean[m];
        for(int i = 0;i < m;i++){
            int bestscore = Integer.MAX_VALUE;
            int best = -1;
            for(int j = 0;j < m;j++){
                if(!done[j]){
                    a[i] = j;
                    done[j] = true;
                    int score = score(a, i+1, ts);
                    if(score < bestscore){
                        bestscore = score;
                        best = j;
                    }
                    done[j] = false;
                    a[i] = j;
                }
            }
            done[best] = true;
            a[i] = best;
        }
        return a;
    }


    static int scoreo(int[] a, char[][] map, char[][] ts)
    {
        int n = map.length;
        int m = ts.length;

        int last = 26;
        int[] dp = {0};
        for(int i = 0;i < m;i++){
            for(char c : ts[a[i]]){
                int[] ndp = new int[poss.get(c-'A').size()];
                for(int k = 0;k < poss.get(c-'A').size();k++){
                    int[] p = poss.get(c-'A').get(k);
                    int min = Integer.MAX_VALUE;
                    for(int j = 0;j < poss.get(last).size();j++){
                        int[] q = poss.get(last).get(j);
                        min = Math.min(min, dp[j] + Math.abs(p[0]-q[0]) + Math.abs(p[1]-q[1]));
                    }
                    ndp[k] = min;
                }
                dp = ndp;
                last = c-'A';
            }
        }
        return min(dp) + 5*m;
    }

    public static int[][] mul(int[][] A, int[][] B)
    {
        if(A == null)return B;
        if(B == null)return A;
        assert A[0].length == B.length;
        int m = A.length;
        int n = A[0].length;
        int o = B[0].length;
        int[][] C = new int[m][o];
        for(int i = 0;i < m;i++){
            Arrays.fill(C[i], Integer.MAX_VALUE);
            for(int k = 0;k < n;k++){
                for(int j = 0;j < o;j++){
                    int x = A[i][k] + B[k][j];
                    if(x < C[i][j])C[i][j] = x;
                }
            }
        }
        return C;
    }


    public static int[] mul(int[][] A, int[] v)
    {
        int m = A.length;
        int n = v.length;
        int[] w = new int[m];
        for(int i = 0;i < m;i++){
            int sum = Integer.MAX_VALUE;
            for(int k = 0;k < n;k++){
                int x = A[i][k] + v[k];
                if(x < sum)sum = x;
            }
            w[i] = sum;
        }
        return w;
    }

    static int score(int[] a, int r, char[][] ts)
    {
        int last = 26;
        int[] dp = {0};
        for(int i = 0;i < r;i++){
            {
                char c = ts[a[i]][0];
                int[] ndp = new int[poss.get(c-'A').size()];
                for(int k = 0;k < poss.get(c-'A').size();k++){
                    int[] p = poss.get(c-'A').get(k);
                    int min = Integer.MAX_VALUE;
                    for(int j = 0;j < poss.get(last).size();j++){
                        int[] q = poss.get(last).get(j);
                        min = Math.min(min, dp[j] + Math.abs(p[0]-q[0]) + Math.abs(p[1]-q[1]));
                    }
                    ndp[k] = min;
                }
                dp = ndp;
            }

            dp = mul(mats[a[i]], dp);
            last = ts[a[i]][4]-'A';
        }
        return min(dp);
    }



    static int score(int[] a, char[][] map, char[][] ts)
    {
        int n = map.length;
        int m = ts.length;

        int last = 26;
        int[] dp = {0};
        for(int i = 0;i < m;i++){
            {
                char c = ts[a[i]][0];
                int[] ndp = new int[poss.get(c-'A').size()];
                for(int k = 0;k < poss.get(c-'A').size();k++){
                    int[] p = poss.get(c-'A').get(k);
                    int min = Integer.MAX_VALUE;
                    for(int j = 0;j < poss.get(last).size();j++){
                        int[] q = poss.get(last).get(j);
                        min = Math.min(min, dp[j] + Math.abs(p[0]-q[0]) + Math.abs(p[1]-q[1]));
                    }
                    ndp[k] = min;
                }
                dp = ndp;
            }

            dp = mul(mats[a[i]], dp);
            last = ts[a[i]][4]-'A';
        }
        return min(dp) + 5*m;
    }

    static int[][] route(int[] a, char[][] map, char[][] ts)
    {
        int m = ts.length;

        int last = 26;
        int[][] pre = new int[m*5+1][225];
        for(int i = 0;i < m*5+1;i++){
            Arrays.fill(pre[i], -1);
        }

        int[] dp = {0};
        int o = 0;
        for(int i = 0;i < m;i++){
            for(char c : ts[a[i]]){
                int[] ndp = new int[poss.get(c-'A').size()];
                for(int k = 0;k < poss.get(c-'A').size();k++){
                    int[] p = poss.get(c-'A').get(k);
                    int min = Integer.MAX_VALUE;
                    for(int j = 0;j < poss.get(last).size();j++){
                        int[] q = poss.get(last).get(j);
                        int d = dp[j] + Math.abs(p[0]-q[0]) + Math.abs(p[1]-q[1]);
                        if(d < min){
                            min = d;
                            pre[o][k] = j;
                        }
                    }
                    ndp[k] = min;
                }
                dp = ndp;
                last = c-'A';
                o++;
            }
        }

        int[][] ret = new int[m*5][];
        int argmin = 0;
        for(int i = 0;i < dp.length;i++){
            if(dp[i] < dp[argmin]){
                argmin = i;
            }
        }
        for(int i = m*5-1;i >= 0;i--){
            char c = ts[a[i/5]][i%5];
            ret[i] = poss.get(c-'A').get(argmin);
            argmin = pre[i][argmin];
        }

        return ret;
    }

    public static int min(int... a){ int min = Integer.MAX_VALUE; for(int v : a){min = Math.min(min, v);} return min; }


    public static int[] shuffle(int n, SplittableRandom gen){ int[] a = new int[n]; for(int i = 0; i < n; i++)a[i] = i; for(int i = 0; i < n; i++){ int ind = gen.nextInt(n-i)+i; int d = a[i]; a[i] = a[ind]; a[ind] = d; } return a; }


    static SplittableRandom gen = new SplittableRandom(114514);

    public static void main(String[] args) throws Exception
    {
        long S = System.currentTimeMillis();
        is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        out = new PrintWriter(System.out);

        solve();
        out.flush();
        long G = System.currentTimeMillis();

    }

    private static boolean eof()
    {
        if(lenbuf == -1)return true;
        int lptr = ptrbuf;
        while(lptr < lenbuf)if(!isSpaceChar(inbuf[lptr++]))return false;

        try {
            is.mark(1000);
            while(true){
                int b = is.read();
                if(b == -1){
                    is.reset();
                    return true;
                }else if(!isSpaceChar(b)){
                    is.reset();
                    return false;
                }
            }
        } catch (IOException e) {
            return true;
        }
    }

    private static byte[] inbuf = new byte[1024];
    static int lenbuf = 0, ptrbuf = 0;

    private static int readByte()
    {
        if(lenbuf == -1)throw new InputMismatchException();
        if(ptrbuf >= lenbuf){
            ptrbuf = 0;
            try { lenbuf = is.read(inbuf); } catch (IOException e) { throw new InputMismatchException(); }
            if(lenbuf <= 0)return -1;
        }
        return inbuf[ptrbuf++];
    }

    private static boolean isSpaceChar(int c) { return !(c >= 33 && c <= 126); }
    //	private static boolean isSpaceChar(int c) { return !(c >= 32 && c <= 126); }
    private static int skip() { int b; while((b = readByte()) != -1 && isSpaceChar(b)); return b; }

    private static double nd() { return Double.parseDouble(ns()); }
    private static char nc() { return (char)skip(); }

    private static String ns()
    {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while(!(isSpaceChar(b))){
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }

    private static char[] ns(int n)
    {
        char[] buf = new char[n];
        int b = skip(), p = 0;
        while(p < n && !(isSpaceChar(b))){
            buf[p++] = (char)b;
            b = readByte();
        }
        return n == p ? buf : Arrays.copyOf(buf, p);
    }

    private static char[][] nm(int n, int m)
    {
        char[][] map = new char[n][];
        for(int i = 0;i < n;i++)map[i] = ns(m);
        return map;
    }

    private static int[] na(int n)
    {
        int[] a = new int[n];
        for(int i = 0;i < n;i++)a[i] = ni();
        return a;
    }

    private static int ni()
    {
        int num = 0, b;
        boolean minus = false;
        while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
        if(b == '-'){
            minus = true;
            b = readByte();
        }

        while(true){
            if(b >= '0' && b <= '9'){
                num = num * 10 + (b - '0');
            }else{
                return minus ? -num : num;
            }
            b = readByte();
        }
    }

    private static long nl()
    {
        long num = 0;
        int b;
        boolean minus = false;
        while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
        if(b == '-'){
            minus = true;
            b = readByte();
        }

        while(true){
            if(b >= '0' && b <= '9'){
                num = num * 10 + (b - '0');
            }else{
                return minus ? -num : num;
            }
            b = readByte();
        }
    }

    private static void tr(Object... o) { if(INPUT.length() != 0)System.out.println(Arrays.deepToString(o)); }
}

