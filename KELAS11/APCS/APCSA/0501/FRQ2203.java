public class FRQ2203{

}

class Review{

}

class ReviewAnalysi{
    private Review[] allReviews;

    public ReviesAnalysis(){
        allReviews = new Review[100];
    }

    public double getAverageRating(){
        int total = 0;
        for (Review r : allReviews){
            total += r.getRating();
        }

        return (double) total / allReviews.length;
    }

    public ArrayList<String> collectComments(){
        ArrayList<String> result = new ArrayList<String>();
        String formatted;

        for (int i = 0; i < allReviews.length; i++){
            String comment = allReviews[i].getComment();

            if (comment.indexOf("!") != -1){
                formatted = i + "-" + comment;

                char lastChar = comment.charAt(comment.length() - 1);
                // not(. or !) ==> !. and !"!"
                if (lastChar != '.' && lastChar != '!' )
                    formatted += ".";
            }

            result.add(formatted);
        }

        return result;
    }
}