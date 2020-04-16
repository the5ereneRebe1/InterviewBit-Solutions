package Problems;

import java.util.Arrays;

public class AlternatePosNeg{
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new AlternatePosNeg().solve(new int[]{4,-3,2,-5,6,-7})));
    }
public int[] solve(int[] A) {

        for(int i=0;i<A.length-1;i++){
            if(i%2==0 && A[i]>=0){
                int pos = i+1;
                while(pos<A.length && A[pos]>=0)
                    pos++;
                
                if(pos>=A.length)
                    return A;
                rotate(A,i,pos);

            }
            else if(i%2!=0 && A[i]<0){
                int pos = i+1;
                while(pos<A.length && A[pos]<0)
                    pos++;
                    System.out.println(pos);
                if(pos>=A.length)
                    return A;
                rotate(A,i,pos);
            }
            System.out.println(Arrays.toString(A));
        }
        return A;
    }

    private void rotate(int[] a, int i, int pos) {
        System.out.println(i+":"+pos);
        int temp = a[pos];
        for(int j=pos;j>=i+1;j--){
            a[j]=a[j-1];
        }
        a[i]=temp;
    }
}