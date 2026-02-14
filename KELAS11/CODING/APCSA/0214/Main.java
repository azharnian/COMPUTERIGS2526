public class Main {
    static int dayOfWeek(int month, int day, int year) {
        // int first = firstDayOfYear(year);
        int first = 0;
        int hari = 60;
        // dayOfYear(month, day, year);

        return (first + hari - 1) % 7;
    }

    public static void main(String[] args) {
        System.out.println(dayOfWeek(0, 0, 0));
    }
}