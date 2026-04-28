public class FRQ2301{

}

class AppointmentBook{
    public int findFreeBlock(int period, int duration){
        int counter = 0, start = 0;

        for (int i = 0; i <= 59; i++){
            if (isMinuteFree(period, i)){
                if (counter == 0) start = i;
                counter++;

                if (counter == duration) return start;
            } else counter = 0;
        }

        return -1;
    }

    public boolean makeAppointment(int startPeriod, int endPeriod, int duration){
        int minute;
        for(int i = startPeriod; i <= endPeriod; i++){
            minute = findFreeBlock(i, duration);
            if(minute != -1){
                reserveBlock(i, minute, duration)
                return true;
            }
        }
        return false;
    }
}