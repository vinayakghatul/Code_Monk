import java.lang.Math;
class Pow_X_N {
    public double myPow(double x, int n) {
        long N = n;

        if (N < 0) {
            x = 1/x;
            N = -N;
        }

        double ans = 1.0;
        while(N > 0) {
            if (N%2 == 1) {
                ans = ans*x;
            }
            x*=x;
            N=N/2;
        }
        return ans;
    }

    public static void main(String args[]) {
        int x = 3;
        int n = 5;

        Pow_X_N powXN = new Pow_X_N();
        System.out.println(powXN.myPow(x,n));
    }
}