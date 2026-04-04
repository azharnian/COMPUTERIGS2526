public class FRQ42025{

}

class SumOrSameGame{
    private int[][] puzzle;

    public SumOrSameGame(int numRows, int numCols){
        puzzle = new int[numRows][numCols];
        for (int i = 0; i < numRows; i++){
            for (int j = 0; j < numCols; j++){
                puzzle[i][j] = Math.floor(Math.random() * 9) + 1;
            }
        }
    }
}