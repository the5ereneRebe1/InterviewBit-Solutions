package Problems;

import java.util.HashMap;

/**
 * PointsonSameLine
 */
public class PointsonSameLine {
    
    public static void main(String[] args) {
        new PointsonSameLine().solve(new int[]{48, 45, -3, 7, -25, 38, 2, 13, 13, 18, -44, 34, -27, -46, 48, -39, -41, -32, -16, 17, -6, 44, -28, -44, -6, -43, -16, 30, -3, -27, 32, 38, -26, 20, 4, -44, -37 }, 
            new int[]{47, -42, 41, 22, -4, -35, -45, -22, 5, -20, 21, -13, 47, 32, -48, 47, 17, -23, 30, -30, 37, 42, 44, 23, 1, -40, -9, 34, -34, 49, 16, -35, 2, -19, 31, 23, -37});
    }
    class SlopeInc{
        int num;
        int den;
        double inc;
        @Override
        public String toString() {
            // TODO Auto-generated method stub
            return num+" "+den;
        }
    }
    int gcd(int A,int B){
        if(B==0) return A;
        return gcd(B,A%B);
    }
    public int solve(int[] A, int[] B) {
        HashMap<String,Integer> Shm = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for(int i=0;i<A.length;i++){
            Shm.clear();
            for(int j=i+1;j<B.length;j++){
                SlopeInc si = new SlopeInc();
                si.num = B[j]-  B[i];
                si.den = A[j] - A[i];
                int gcd = gcd(si.num,si.den);
                if(gcd!=0){
                    si.num /=gcd;
                    si.den /=gcd;
                }
                String key = si.toString();
                System.out.println("("+A[i]+","+B[i]+")"+"_"+"("+A[j]+","+B[j]+")"+"=>"+key);
                Shm.compute(key,(k,v)->v==null?1:++v);
                max = Math.max(max,Shm.get(key)+1);
            }
            
        }
        System.out.println(max);
        return max;
    }
}