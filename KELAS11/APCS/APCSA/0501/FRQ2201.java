public FRQ2201{
    
}

class Level{

}

class Game{
    Level levelOne;
    Level levelTwo;
    Level levelThree;

    public Game(){
        // levelOne = new Level();
    }

    public int getScore(){
        int score = 0;

        if (levelOne.goalReached()){
            score += levelOne.getPoints();

            if (levelTwo.goalReached()){
                score += levelTwo.getPoints();

                if (levelThree.goalReached()){
                    score += levelThree.getPoints();
                }
            }
        }

        if (isBonus()){
            score *= 3;
        }

        return score;
    }

    public int playManyTimes(int num){
        int max, current;

        for (int i = 0 ; i < num; i++){
            this.play();
            current = this.getScore();

            if (current > max) max = current;
        }

        return max;

    }
}