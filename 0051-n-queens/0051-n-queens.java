import java.util.*;
public class Solution {
    public List<List<String>> solveNQueens(int n){
        List<List<String>> ans = new ArrayList<>();

        char[][] board = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = '.';
            }
        }

        nQueens(board,0,ans);
        return ans;
    }

    static void nQueens(char[][] board,int row,List<List<String>> ans) {
        if(row == board.length){
            List<String> solution = new ArrayList<>();
             for(int i=0;i<board.length;i++){
                solution.add(new String(board[i]));
             }

             ans.add(solution);

            return;
        }

        for(int col=0;col<board.length;col++){
            if(isSafe(board,row,col)){
                board[row][col] = 'Q';

                nQueens(board,row+1,ans);

                board[row][col] = '.';
            }
        }
    }

    static boolean isSafe(char[][] board,int row,int col){
        for(int i=row-1; i>=0;i--){
            if(board[i][col] == 'Q'){
                return false;
            }
        }

        for(int i=row-1,j=col-1; i>=0 && j>=0; i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        for(int i=row-1,j=col+1; i>=0 && j<board.length; i--,j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }
}
