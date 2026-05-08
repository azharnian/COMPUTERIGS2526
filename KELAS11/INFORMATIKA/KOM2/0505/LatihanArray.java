import java.util.Arrays;

public class LatihanArray {
    public static void main(String[] args){

        int[] numbers = {1, 2, 3, -5};
        System.out.println(containsNegative(numbers));
        System.out.println(allPositive(numbers));
        System.out.println(countEven(numbers));

        System.out.println(Arrays.toString(numbers));
        swapFirstLast(numbers);
        System.out.println(Arrays.toString(numbers));

        reverseArray(numbers);
        System.out.println(Arrays.toString(numbers));

        rotateRightN(numbers, 2);
        System.out.println(Arrays.toString(numbers));

        System.out.println(sumWithoutMinMax(numbers)); // 3

        System.out.println(secondLargest(numbers)); // 2

    }

    public static boolean containsNegative(int[] arr){
        for (int item : arr){
            if (item < 0) return true;
        }
        return false;
    }

    public static boolean allPositive(int[] arr){
        return !containsNegative(arr);
    }

    public static int countEven(int[] arr){
        int counter = 0;
        for (int item : arr){
            if (item % 2 == 0) counter++;
        }
        return counter;
    }

    public static void swapFirstLast(int[] arr){
        int temp = arr[0];
        arr[0] = arr[arr.length - 1];
        arr[arr.length - 1] = temp;
    }

    public static void reverseArray(int[] arr){
        for (int i = 0; i < arr.length / 2; i++){
            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
    }

    public static void shiftRight(int[] arr){
        int temp = arr[arr.length - 1];
        for (int i = arr.length - 1; i > 0; i--){
            arr[i] = arr[i - 1];
        }
        arr[0] = temp;
    }

    public static void rotateRightN(int[] arr, int n){
        for (int i = 0; i < n; i++){
            shiftRight(arr);
        }
    }

    public static int sumWithoutMinMax(int[] arr){
        int min = arr[0], max = arr[0], sum = arr[0];
        for (int i = 1; i < arr.length; i++){
            if (arr[i] > max) max = arr[i];
            if (arr[i] < min) min = arr[i];
            sum += arr[i];
        }
        return sum - min - max;
    }

    public static int secondLargest(int[] arr){
        int first = arr[0], second = arr[0];
        for (int i = 1; i < arr.length; i++){
            if (arr[i] > first) first = arr[i];
            if (arr[i] > second && arr[i] < first)
                second = arr[i];
        }
        return second;
    }
}