public class FRQ2303{

}

class WeatherData{
    public void cleanData(double lower, double upper)
    {
        for (int i = temperatures.size() - 1; i >= 0; i--)
        {
            double temp = temperatures.get(i);

            if (temp < lower || temp > upper)
            {
                temperatures.remove(i);
            }
        }
    }

    public int longestHeatWave(double threshold)
    {
        int maxStreak = 0;
        int currentStreak = 0;

        for (int i = 0; i < temperatures.size(); i++)
        {
            if (temperatures.get(i) > threshold)
            {
                currentStreak++;
                if (currentStreak > maxStreak)
                {
                    maxStreak = currentStreak;
                }
            }
            else
            {
                currentStreak = 0;
            }
        }

        return maxStreak;
    }
}