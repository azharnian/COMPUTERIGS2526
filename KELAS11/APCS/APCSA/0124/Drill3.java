public class Drill3 {

    public static void main(String[] args){
        int[][] numbers = {
            {1, 2, 3},
            {4, 5},
            {6, 9, 10, 11}
        };
    }

    public static int count(int[][] arr){
        int counter = 0;
        for (int[] row : arr){
            for (int item : row){
                counter++;
            }
        }

        return counter;
    }

    public static int rowCount(int[][] arr, int targetRow){
        int counter = 0;
        for (int item : arr[targetRow]){
            counter++;
        }
        return counter;
    }

}