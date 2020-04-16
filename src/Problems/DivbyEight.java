package Problems;

import java.util.Arrays;

/**
 * DivbyEight
 */
public class DivbyEight {

    public static void main(String[] args) {
        new DivbyEight().solve("4");
    }

    public int solve(String A) {
        int l[] = new int[3];
        for(int i=A.length()-1,j=0;i>=0 && j<3;i--,j++)
        {
            l[j]=Character.getNumericValue(A.charAt(i));
        }
        int no = l[2]*100+l[1]*10+l[0];
        System.out.println(no);
        return 0;
    }
}