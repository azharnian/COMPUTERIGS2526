public class FRQ2201{

}

class Level{

}

class Game{
    public int getScore()
    {
        int score = 0;

        if (levelOne.goalReached())
        {
            score += levelOne.getPoints();

            if (levelTwo.goalReached())
            {
                score += levelTwo.getPoints();

                if (levelThree.goalReached())
                {
                    score += levelThree.getPoints();
                }
            }
        }

        if (isBonus())
        {
            score *= 3;
        }

        return score;
    }

    public int playManyTimes(int num)
    {
        int maxScore = 0;

        for (int i = 0; i < num; i++)
        {
            play();
            int currentScore = getScore();

            if (currentScore > maxScore)
            {
                maxScore = currentScore;
            }
        }

        return maxScore;
    }
}