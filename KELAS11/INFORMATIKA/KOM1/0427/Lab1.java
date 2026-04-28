import java.util.Arrays;
public class Lab1{
    public static void main(String[] args){
        int[] nums1 = {0, 2, 4, 6, 8};
        int[] nums2 = {0, 2, 3, 4, 5};

        // System.out.println(atLeastOneOdd(nums1));
        // System.out.println(atLeastOneOdd(nums2));

        shiftRight(nums1);
        // System.out.println(Arrays.toString(nums1));
        shiftLeft(nums1);
        // System.out.println(Arrays.toString(nums1));

        int[] scores = {10, 10, 10, 30, 30, 30, 40};
        System.out.println(mode(scores));
        
    }

    public static boolean atLeastOneOdd(int[] arr){
        for (int i = 0;  i < arr.length; i++){
            if (arr[i] % 2 != 0){
                return true;
            }
        }
        return false;
    }

    public static void shiftRight(int[] arr){
        int temp = arr[arr.length - 1];
        for(int i = arr.length-1; i > 0; i--){
            arr[i] = arr[i-1];
        }
        arr[0] = temp;
    }

    public static void shiftLeft(int[] arr){
        int temp = arr[0];
        for (int i = 0; i < arr.length - 1; i++){
            arr[i] = arr[i + 1];
        }
        arr[arr.length-1] = temp;
    }

    public static int mode(int[] arr){
        int[] counters = new int[101];

        for (int val : arr){
            counters[val]++;
        }

        int maxIndex = 0;
        for (int i = 1; i < counters.length; i++){
            if (counters[i] > counters[maxIndex]) maxIndex = i; 
        }

        return maxIndex;
    }

    public static boolean atLeastOneNeg(int[] arr){
        for (int i = 0; i < arr.length; i++){
            if (arr[i] < 0){
                return true;
            }
        }
        return false;
    }

    public static boolean allPositive(int[] arr){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] < 1)
            return false;
        }
        return true;
    }

    public static int countEven(int[] arr){
        int count = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] % 2 == 0){
                count++;
            }
        }
        return count;
    }

    public static void swapFirstLast(int[] array){
        int temp = array[0];
        array[0] = array[array.length - 1];
        array[array.length - 1] = temp;
    }


}