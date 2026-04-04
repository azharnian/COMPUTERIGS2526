public class FRQ12025{
    public static void main(String[] args){

    }
}

class DogWalkCompany{

}

class DogWalker{
    private int maxDogs;
    private DogWalkCompany company;

    public int walkDogs(int hour){
        int availableDogs = company.numAvailableDogs(hour);
        if (availableDogs >= maxDogs){
            company.updateDogs(hour, maxDogs);
            return maxDogs;
        }
        company.updateDogs(hour, availableDogs);
        return availableDogs;
    }

    public int dogWalkShift(int startHour, int endHour){
        int totalAmountEarned = 0;
        for (int hour = startHour; hour <= endHour; hour++){
            totalAmountEarned += walkDogs(hour)*5;
            if ((hour >= 9 && hour <= 17) || walkDogs(hour) == maxDogs){
                totalAmountEarned += 3;
            }   
        }
        return totalAmountEarned;
    }
}