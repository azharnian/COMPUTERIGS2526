public class L1601 {
    public static void main(String[] args){
        int[] numbers = {1, 2, 3, 4, 5};
        System.out.println(getAve(numbers));

    }

    // 1
    public static double getAve(int[] arr){
        double sum = 0;
        for (int i=0; i < arr.length; i++){
            sum += arr[i];
        }
        return sum / arr.length;
    }

    // 2
    public static int countAboutAve(int[] arr){
        int cnt = 0;
        for (int i=0; i < arr.length; i++){
            if (arr[i] > getAve(arr)){
                cnt++;
            }
        }
        return cnt;
    }
}