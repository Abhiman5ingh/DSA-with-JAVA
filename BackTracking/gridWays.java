package BackTracking;

public class gridWays{
    public static int ways(int i, int j, int n, int m){     // O(2^(m+n))
        if(i==n-1 && j==m-1) return 1;
        else if(i==n || j==n) return 0;
        int w1 = ways(i+1, j, n, m);
        int w2 = ways(i, j+1, n, m);
        return w1 + w2;
    }
    public static void main(String args[]){
        int n=3,m=3;
        System.out.println(ways(0, 0, n, m));
    }
}


// Linear Solution   // O(n+m)

// int d=n-1;
// int r=m-1;
// int permutation=fact(d+r)/(fact(d)*fact(r));