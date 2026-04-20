import java.util.Arrays;

public class Lab1Arr{
    public static void main(String[] args){

        int[] numbers = {10, 20, 30};
        System.out.println("Average from " + Arrays.toString(numbers) + " is " + average(numbers));
        System.out.println("Value above ave is " + countAboveAve(numbers));
    }

    public static double average(int[] arr){
        double sum = 0;
        for (int i=0; i < arr.length; i++){
            sum += arr[i];
        }
        return sum / arr.length;
    }

    public static int countAboveAve(int[] arr){
        int count = 0;
        for (int i=0; i < arr.length; i++){
            if (arr[i] > average(arr)) count++;
        }
        return count;
    }

    public static int largest(int[] arr){
        // to do : find and return the largest value in array
        int max = arr[0];
        for (int i = 1; i < arr.length; i++){
            if (arr[i] > max) max = arr[i];
        }
        return max;
    }
    
    public static int indexOfSmallest(int[] arr){
        int index = 0;
        int min = arr[index];
        for (int i = 1; i < arr.length; i++){
            if (arr[i] < min){
                min = arr[i];
                index = i;
            }
        }
        return index;
    }
}