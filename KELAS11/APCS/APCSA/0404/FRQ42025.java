public class FRQ42025{

}

class SumOrSameGame{
    private int[][] puzzle;

    public SumOrSameGame(int numRows, int numCols){
        puzzle = new int[numRows][numCols];
        for (int i = 0; i < numRows; i++){
            for (int j = 0; j < numCols; j++){
                puzzle[i][j] = (int) Math.floor(Math.random() * 9) + 1;
            }
        }
    }

    public boolean clearPair(int row, int col){
        for(int i = row; i < numRows; i++){
            for(int j = 0; j < numCols; j++){
                if(i == row && j == col){
                    continue;
                }
                if(puzzle[i][j] + puzzle[row][col] == 10 || puzzle[i][j] == puzzle[row][col]){
                    puzzle[i][j] = 0;
                    puzzle[row][col] = 0;
                    return true;
                }
            }
        }
        return false;
    }
}