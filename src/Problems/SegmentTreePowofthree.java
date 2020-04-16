package Problems;

import java.util.Arrays;

public class SegmentTreePowofthree {
    class Value{
        int value;
        int length;
    }
    class SegmentTree  
    { 
        Value st[];  // The array that stores segment tree nodes 
        //int len[]; // The array that stores the bit length
        SegmentTree(int arr[]) 
        { 
            int n = arr.length;
            int x = (int) (Math.ceil(Math.log(n) / Math.log(2))); 
            int max_size = 2 * (int) Math.pow(2, x) - 1; 
            st = new Value[max_size]; // Memory allocation 
            //len = new int[max_size];
            buildST(arr, 0, n - 1, 0); 
        }
	    int power(int x, int y, int p) 
        { 
            int res = 1;      
            x = x % p;  
           if (x == 0) return 0; // In case x is divisible by p;    
            while (y > 0) 
            { 
                if((y & 1)==1) 
                    res = (res * x) % p; 
                y = y >> 1;  
                x = (x * x) % p;  
            } 
            return res; 
        } 
        Value buildST(int arr[],int s,int e,int np){
            if(s==e){
                st[np]=new Value();
                st[np].value = arr[s];
                st[np].length = 1;
                return st[np];
            }
            int mid = s+(e-s)/2;
            Value left=buildST(arr,s,mid,2*np+1);
            Value right=buildST(arr,mid+1,e,2*np+2);
            //How are the nodes going to be populated!
            st[np] = new Value();
            st[np].length = st[2*np+1].length+st[2*np+2].length;
            st[np].value = (int)Math.pow(2,right.length)*left.value+right.value;
            //st[np] = ((power(2,countBits(st[2*np+2]),3)*st[2*np+1]%3)%3+st[2*np+2]%3)%3;
            return st[np];
        }
        Value rangeQueryUtil(int ql,int qr,int s,int e,int np){
            if(ql<=s && qr>=e)  //Total Overlap
                return st[np];
            if(e<ql || s>qr)    //No Overlap    
                return null;
            int mid = s+(e-s)/2;
            int rb = qr<mid?qr:mid;
            int lb = ql>mid+1?ql:mid+1;
            Value left    = rangeQueryUtil(ql,rb,s,mid,2*np+1);      //1
            Value right   = rangeQueryUtil(lb,qr,mid+1,e,2*np+2);  //0
            if(left==null || right==null)
                if(left==null)
                    return right;
                else
                    return left;
            else{
                Value val = new Value();
                val.value= (int)Math.pow(2,right.length)*left.value+right.value;
                val.length = right.length+left.length;
                return val;
            }
                //return ((power(2,len[2*np+2],3)*(left%3))%3+right%3)%3;  //2
        }
        void updateQueryUtil(int s, int e, int i, int np) 
        { 
        if (i < s || i > e) 
            return; 
        if(i==s && i==e){
            st[np].value = 1;
            return;
        }
        int mid = s+(e-s)/2; 
        updateQueryUtil(s, mid, i, 2 * np + 1); 
        updateQueryUtil(mid + 1, e, i, 2 * np + 2);
        st[np].value = ((power(2,st[2*np+2].length,3)*st[2*np+1].value%3)%3+st[2*np+2].value%3)%3;
    } 
        
        
        Value rangeQuery(int start,int end,int n){
            return rangeQueryUtil(start,end,0,n-1,0);
        }
        int updateQuery(int index,int n){
            updateQueryUtil(0,n-1,index,0);
            return -1;
        }
    }
        
    public int[] solve(String A, int[][] B) {
        int input[] = new int[A.length()];
        int ans[]   = new int[B.length];
        for(int i=0;i<A.length();i++)
            input[i] = Character.getNumericValue(A.charAt(i));
        SegmentTree sTree = new SegmentTree(input);
//-----------------------------------------------------------
//      Fire those Queries
//-----------------------------------------------------------
        for(int i=0;i<B.length;i++){
            if(B[i][0]==0)
                ans[i] = sTree.rangeQuery(B[i][1]-1,B[i][2]-1,input.length).value;
            else
                ans[i] = sTree.updateQuery(B[i][1]-1,input.length);
        }
        
        
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SegmentTreePowofthree().solve("0100111001", new int[][]{
             {0, 1, 2},
             {1, 6, -1},
             {0, 5, 6},
             {1, 2, -1},
            {0, 7, 9},
            {0,1,5}
        })));
    }
}