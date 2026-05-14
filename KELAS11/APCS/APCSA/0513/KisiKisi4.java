public class KisiKisi4{

}

class Appointment{
    public String getStatus(){};
    public int getRoomNumber(){};

}

class Schedule{
    private Appointment[][] sched;
    public int columnWithFewest(String target){
        int[] statusCounter = new int[sched[0].length];

        for (int col = 0; col < sched[0].length; col++){
            for (int row = 0; row < sched.length; row++){
                if (sched[row][col].getStatus().equals(target)){
                    statusCounter[col]++;
                }
            }
        }

        int min = statusCounter[0];
        int index = 0;
        for (int i = 1; i < statusCounter.length; i++){
            if (statusCounter[i] < min){
                min = statusCounter[i];
                index = i;
            }
        }
        return index;
    };
}