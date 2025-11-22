public class L1201 {
    public static void main(String[] args){
        multiplicationTable(5);
    }

    public static void multiplicationTable(int n){
        for (int row = 1; row <= n; row++){
            for (int col = 1; col <= 10; col++){
                System.out.print(row * col + "\t");
            }
            System.out.println();
        }
    }
}