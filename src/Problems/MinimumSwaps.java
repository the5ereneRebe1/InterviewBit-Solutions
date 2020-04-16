package Problems;
class MinimumSwaps{
    public static void main(String[] args) {
        System.out.println(new MinimumSwaps().solve(new int[]{1,3,4,0,2}));
    }
    public int solve(int[] A) {
        int countSwaps = 0;
        //  1   3   4   0   2   
        //  3   1   4   0   2
        //  0   1   4   3   2
        for(int i=0;i<A.length;i++){
            if(A[i] == i)
                continue;
            
            int cycles = 0;
            int temp = i;
            while(A[temp] != temp  && A[A[temp]]!=A[temp]){
                //System.out.println((A[temp] != temp  && A[A[temp]]!=A[temp])+":"+temp);
                int temp2 = A[temp];
                A[temp] = A[A[temp]];
                A[temp2] = temp2;
                
                
                cycles++;
            }
            countSwaps+=cycles;
        }
        return countSwaps;
    }
}