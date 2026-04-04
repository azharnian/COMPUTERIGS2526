public class FRQ32025{
    public static void main(String[] args){
        String[] players = {"Alex", "Ben", "Cara"};
        Round r = new Round(players);
    }
}

class Competitor{}

class Match{}

class Round{

    private ArrayList<Competitor> competitorList;

    public Round(String[] names){
        competitorList = new ArrayList<Competitor>();

        for (int i = 1; i <= names.length; i++){
            competitorList.add(new Competitor(names[i-1], i));
        }
    }   

    public ArrayList<Match> buildMatches(){
        ArrayList<Match> mathes = new ArrayList<Match>();
        int numsCompetitors = competitorList.size();
        
        if ( numsCompetitors % 2==0){
            for (int i=0; i < numsCompetitors/2; i++){
                mathes.add(new Match(competitorList.get(i), competitorList.get(numsCompetitors-1-i)));
            }
            return mathes;
        }
        for (int i=0; i <= numsCompetitors/2; i++){
                mathes.add(new Match(competitorList.get(i+1), competitorList.get(numsCompetitors-1-i)));
            }
        return mathes;
    } 
}