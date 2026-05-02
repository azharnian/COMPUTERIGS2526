import java.util.ArrayList;
public class FRQ2203{

}

class Review{

}

class ReviesAnalysis{
    public double getAverageRating()
    {
        int total = 0;

        for (int i = 0; i < allReviews.length; i++)
        {
            total += allReviews[i].getRating();
        }

        return (double) total / allReviews.length;
    }


    public ArrayList<String> collectComments()
    {
        ArrayList<String> result = new ArrayList<String>();

        for (int i = 0; i < allReviews.length; i++)
        {
            String comment = allReviews[i].getComment();

            if (comment.indexOf("!") != -1)
            {
                String formatted = i + "-" + comment;

                // cek apakah perlu tambah titik di akhir
                char lastChar = comment.charAt(comment.length() - 1);
                if (lastChar != '.' && lastChar != '!')
                {
                    formatted += ".";
                }

                result.add(formatted);
            }
        }

        return result;
    }   
}