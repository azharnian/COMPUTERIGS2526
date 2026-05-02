public class FRQ2204{

}

class Data{
    public static final int MAX = 100;
    private int[][] grid;

    public Data(int r, int c){
        grid = new[r][c];
    }

    public void repopulate(){
        int val;
        for (int i = 0; i < grid.length; i++){
            for (int j= 0; j < grid[0].length; j++){

                do {
                    val = (int)(Math.random() * MAX) + 1;
                } while(!(val %= 10 == 0 && val %= 100 != 0))

                grid[i][j] = val;
            }
        }
    }

    public int countIncreasingCols(){
        int count = 0;
        boolean isIncreasing;
        for (int i = 0; i < grid[0].length; i++){
            isIncreasing = true;
            
            for (j = 1; j < grid.length; j++){
                if (grid[i][j] < grid[i-1][j]){
                    isIncreasing = false;
                    break;
                }
            }
            if (isIncreasing) count++;

        }

        return count;
    }
}