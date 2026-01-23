import java.util.*;
public class Main{

    public static void main(String[] args){
        ArrayList<Integer> numbers = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));

        System.out.println(sequentialSearch(numbers, 3)); // 2
        System.out.println(sequentialSearch(numbers, 10)); // -1

    }

    public static int sequentialSearch(ArrayList<Integer> arr, int target){

        for (int i = 0; i < arr.size(); i++){
            if (arr.get(i).equals(target)){
                return i;
            }
        }
        return -1;
    }

}