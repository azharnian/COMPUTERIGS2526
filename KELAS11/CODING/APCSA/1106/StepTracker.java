public class StepTracker {
    private int minSteps;
    private int active = 0;
    private int daily = 0;
    private int numsDaily = 0;

    public StepTracker(int s){
        minSteps = s;
    }

    public int activeDays(){
        return active;
    }

    public double averageSteps(){
        if (numsDaily == 0) return 0;
        return daily * 1.0 / numsDaily;
    }

    public void addDailySteps(int s){
        if (s >= minSteps) active++;
        daily += s;
        numsDaily++;
    }

    public static void main(String[] args){
        StepTracker tr = new StepTracker(10000);

        System.out.println(tr.activeDays()); // 0
        System.out.println(tr.averageSteps());  // 0.0

        tr.addDailySteps(9000);
        tr.addDailySteps(5000);

        System.out.println(tr.activeDays()); // 0
        System.out.println(tr.averageSteps());  // 7000.0

        tr.addDailySteps(13000);

        System.out.println(tr.activeDays()); // 1
    }
}