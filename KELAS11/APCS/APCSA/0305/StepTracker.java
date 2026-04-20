import java.util.*;

public class StepTracker{
    private int target;
    private int counterAchieveTarget = 0;
    private ArrayList<Integer> history = new ArrayList<Integer>();

    StepTracker(int t){
        target = t;
    }

    public void addDailySteps(int step){
        if (step >= target) counterAchieveTarget++;
        history.add(step);
    }

    public int activeDays(){ return counterAchieveTarget; };

    public double averageSteps(){
        if (history.size() == 0) return 0.0;

        int sum = 0;
        for (int step : history){
            sum += step;
        }
        return (double) sum / history.size();
    }
    
    public static void main(String[] args){
        StepTracker tr = new StepTracker(10000);

        System.out.println(tr.activeDays());
        System.out.println(tr.averageSteps());
        tr.addDailySteps(9000);
        tr.addDailySteps(5000);
        System.out.println(tr.activeDays());
        System.out.println(tr.averageSteps());
    }

}