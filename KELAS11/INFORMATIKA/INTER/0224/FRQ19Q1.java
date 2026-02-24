public class FRQ19Q1{
    public static void main(String[] args){
        System.out.println(APCalendar.numberOfLeapYears(2000, 2026));

        System.out.println(APCalendar.dayOfWeek(2, 24, 2026));
    }
}

class APCalendar{
    /** Returns true if year is a leap year and false otherwise. */
    private static boolean isLeapYear(int year) {
        // 1. Tahun harus habis dibagi 4
        // 2. Jika habis dibagi 100, ia JUGA harus habis dibagi 400
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                return year % 400 == 0;
            }
            return true;
        }
        return false;
    }


    /** Returns the number of leap years between year1 and year2, inclusive.
    * Precondition: 0 <= year1 <= year2
    */
    public static int numberOfLeapYears(int year1, int year2)
    { 
        int counter = 0;
        for (int i = year1; i <= year2; i++){
            if (isLeapYear(i)){
                counter++;
            }
        }

        return counter;
    }


    /** Returns the value representing the day of the week for 
     * January 1 of the given year,
     * where 0 = Sunday, 1 = Monday, ..., 6 = Saturday.
     */
    private static int firstDayOfYear(int year) {

        // Zeller’s Congruence for January 1
        int m = 13;          // January treated as month 13
        int Y = year - 1;    // previous year
        int q = 1;           // day of month

        int K = Y % 100;
        int J = Y / 100;

        int h = (q + (13 * (m + 1)) / 5 + K + K/4 + J/4 + 5*J) % 7;

        // Zeller: 0 = Saturday
        // Convert to: 0 = Sunday
        return (h + 6) % 7;
    }


    /** Returns n, where month, day, and year specify the nth day of the year.
     * Returns 1 for January 1.
     */
    private static int dayOfYear(int month, int day, int year) {

        int[] daysInMonth = {
            31, // Jan
            isLeapYear(year) ? 29 : 28, // Feb
            31, // Mar
            30, // Apr
            31, // May
            30, // Jun
            31, // Jul
            31, // Aug
            30, // Sep
            31, // Oct
            30, // Nov
            31  // Dec
        };

        int total = 0;

        for (int i = 0; i < month - 1; i++) {
            total += daysInMonth[i];
        }

        total += day;

        return total;
    }

    /** Returns the value representing the day of the week for the given date
    * (month, day, year), where 0 denotes Sunday, 1 denotes Monday, ...,
    * and 6 denotes Saturday.
    * Precondition: The date represented by month, day, year is a valid date.
    */
    public static int dayOfWeek(int month, int day, int year)
    { 
        int dY = dayOfYear(month, day, year); // 55
        int fDY = firstDayOfYear(year); // 4

        return  (dY + fDY) % 7 - 1; // 2
    }
    // There may be instance variables, constructors, and other methods not shown.
}