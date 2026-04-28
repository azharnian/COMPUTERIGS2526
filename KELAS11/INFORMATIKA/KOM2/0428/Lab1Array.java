import java.util.Arrays;
public class Lab1Array{
    public static void main(String[] args){
        int[] nums1 = {2, 4, 6, 7, 10};
        int[] nums2 = {2, 4, 6, 8, 10};

        // System.out.println(atLeastOneOdd(nums1)); // true
        // System.out.println(atLeastOneOdd(nums2)); // false

        // shiftRight(nums1);
        // System.out.println(Arrays.toString(nums1));

        // shiftLeft(nums1);
        // System.out.println(Arrays.toString(nums1));

        int[] nums = {60, 60, 70, 70, 80};
        System.out.println(mode(nums));

    }

    public static boolean atLeastOneOdd(int[] arr){
        for (int item : arr){
            if (item % 2 != 0){
                return true;
            }
        }
        return false;
    }

    public static void shiftRight(int[] arr){
        int temp = arr[arr.length - 1];
        for (int i = arr.length - 1; i > 0; i--){
            arr[i] = arr[i - 1];
        }
        arr[0] = temp;
    }

    public static void shiftLeft(int[] arr){
        int temp = arr[0];
        for (int i = 0; i < arr.length - 1; i++){
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = temp;
    }

    public static int mode(int[] arr){
        int[] grades = new int[101];

        for (int item : arr){
            grades[item]++;
        }

        int index = 0;
        for (int i = 1; i <= 100; i++){
            if (grades[i] > grades[index] ){
                index = i;
            }
        }

        return index;
    }
}