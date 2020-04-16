package Problems;

import java.util.ArrayList;

public class CountPathBacktrack {
	
	public static void main(String[] args) {
		int[][] A = {
		            {1, 0, 0, 0},
           		  	{0, 0, 0, 0},
		            {0, 0, 2, -1}
		};
		System.out.println(new CountPathBacktrack().solve(A));
	}
    int path=0;
    class Point{
        public int x;
        public int y;
        Point(int x1,int y1){
            x=x1;
            y=y1;
        }
    }
    public int solve(int[][] A) {
        int sx=-1,sy=-1,countRZ=0;
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A[i].length;j++){
                if(A[i][j]==1){
                    sx = i;sy=j;
                }
                if(A[i][j]==0) 
                    countRZ++;
            }
        }
        System.out.println(sx+":"+sy+":"+countRZ);
        recur(sx,sy,countRZ,A);
        return path;
    }
    void recur(int x,int y,int countRZ,int[][] A)
    {
        if(A[x][y]==2){
        	System.out.println("I came but"+countRZ);
            if(countRZ==-1){
            	System.out.println("I came");
                path++;
            }
            return;
        }
        //Finding all choices we can make
        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point(x-1,y));
        points.add(new Point(x,y-1));
        points.add(new Point(x+1,y));
        points.add(new Point(x,y+1));
        //Check if the points are walkable
        for(Point p:points){
        	//System.out.println(p.x+":"+p.y);
            if(p.x>=0 && p.x<A.length && p.y>=0 && p.y<A[0].length){
                if(A[p.x][p.y]==0 || A[p.x][p.y]==2){
                	System.out.println(p.x+":"+p.y);
                    //Here we write the do Part
                	int temp = A[p.x][p.y];
                	A[p.x][p.y]=(A[p.x][p.y]!=2)?-1:2;
                    countRZ--;
                    // Recur on the new choice 
                    recur(p.x,p.y,countRZ,A);
                    //Now we undo what we did
                    A[p.x][p.y]=temp;
                    countRZ++;
                }
            }
        }
    }
}
