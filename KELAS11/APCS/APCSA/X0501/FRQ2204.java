public class FRQ2204{

}

class Data{
    public void repopulate()
    {
        for (int r = 0; r < grid.length; r++)
        {
            for (int c = 0; c < grid[0].length; c++)
            {
                int val;

                do
                {
                    val = (int)(Math.random() * MAX) + 1;
                }
                while (val % 10 != 0 || val % 100 == 0);

                grid[r][c] = val;
            }
        }
    }

    public int countIncreasingCols()
    {
        int count = 0;

        for (int c = 0; c < grid[0].length; c++)
        {
            boolean increasing = true;

            for (int r = 1; r < grid.length; r++)
            {
                if (grid[r][c] < grid[r - 1][c])
                {
                    increasing = false;
                    break;
                }
            }

            if (increasing)
            {
                count++;
            }
        }

        return count;
    }
}