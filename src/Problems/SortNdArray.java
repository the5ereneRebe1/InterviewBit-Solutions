package Problems;

import java.util.Arrays;
import java.util.Comparator;

class SortNdArray {
    public static void main(String[] args) {
        int[][] arr={   {1,2,3},
                        {1,5,6},
                        {2,4,5},
                        {1,3,5},
                        {2,2,3},              
    };   
    Arrays.sort(arr, new Comparator<int[]>(){

        @Override
        public int compare(int[] o1, int[] o2) {
            int result = 0;
            for(int i=0;i<o1.length;i++){
                result = Integer.compare(o1[i],o2[i]);
                System.out.println(o1[i]+":"+o2[i]+result);
                if(result!=0)
                    break;
            }
            return result;
        }

    });
    System.out.println(Arrays.deepToString(arr));
    }

}