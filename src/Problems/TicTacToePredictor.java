package Problems;

import java.util.Arrays;

class TicTacToePredictor
{
    final int[][] winningStates = {
    {0,1,2},
    {3,4,5},
    {6,7,8},
    {0,3,6},
    {1,4,7},
    {2,5,8},
    {0,4,8},
    {2,4,6}
    };
    static int positionWins[] = {0,0,0,0,0,0,0,0,0};
    
    public static void main(String[] args) {
        int currentState[] = {1,0,0,0,2,0,0,0,1};
        System.out.println(new TicTacToePredictor().backtrack(currentState,2,true));
        System.out.println(Arrays.toString(positionWins));
    }
    public int backtrack(int currentState[],int turn,boolean flag){
        int totalWins = 0;
        //base case
        if(checkIfPlayerWon(currentState,2))
                return 1;
        else if(checkIfPlayerWon(currentState,1)) 
                return 0;
        boolean isEmpty = false;
        for(int i=0;i<currentState.length;i++)
            if(currentState[i]==0)
                isEmpty = true;
        if(!isEmpty)
            return 0;


        //Pruning logic , if there is a win condition play that win condition
        for(int i=0;i<currentState.length;i++){
            
            if(currentState[i]==0){
                if(turn==1){
                    currentState[i] = 1;
                    totalWins += backtrack(currentState, 2,false);
                    currentState[i] = 0;
                }else{
                    currentState[i] = 2;
                    int wins =  backtrack(currentState, 1,false);
                    if(flag) positionWins[i] = wins;
                    totalWins += wins;
                    currentState[i] = 0;
                }
                //recur
                //totalWins +=backtrack(currentState, turn);

            }

        }
        return totalWins;
    }

    private boolean checkIfPlayerWon(int[] currentState,int player) {
        for(int i=0;i<winningStates.length;i++){
            if(currentState[winningStates[i][0]]==currentState[winningStates[i][1]] &&
                currentState[winningStates[i][1]]==currentState[winningStates[i][2]])
                {
                    if(currentState[winningStates[i][0]]==player)
                        return true;
                }
        }
        return false;
    }

}
