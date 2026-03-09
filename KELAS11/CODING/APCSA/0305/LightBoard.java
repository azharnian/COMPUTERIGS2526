public class LightBoard{

    private boolean[][] lights;

    LightBoard(int numRows, int numCols){
        lights = new boolean[numRows][numCols];
        
        int threshold = (int) (0.4 * (numRows * numCols));
        int counter = 0;

        while(counter <= threshold){
            int randRow = (int) Math.floor(Math.random() * numRows);
            int randCol = (int) Math.floor(Math.random() * numCols);

            if (!lights[randRow][randCol]) {
                lights[randRow][randCol] = true;
                counter++;
            }
        }
    }

    public boolean evaluateLight(int row, int col){
        if (lights[row][col]){
            int counter = 0;
            for (int i = 0; i < lights.length; i++){
                if (lights[i][col]) counter++;
            } 
            if (counter % 2 == 0) return false;
            else return lights[row][col];
        } else {
            int counter = 0;
            for (int i = 0; i < lights.length; i++){
                if (lights[i][col]) counter++;
            }
            if (counter % 3 == 0) return true; 
            else return lights[row][col];
        }
    }

    public static void main(String[] args){
        LightBoard lb = new LightBoard(4,4);
    }



}