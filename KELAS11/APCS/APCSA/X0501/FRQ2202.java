public class FRQ2202
{

}

class Book{

}

public class Textbook extends Book
{
    private int edition;

    // Constructor
    public Textbook(String title, double price, int edition)
    {
        super(title, price); // panggil constructor Book
        this.edition = edition;
    }

    // Getter edition
    public int getEdition()
    {
        return edition;
    }

    // Override getBookInfo
    public String getBookInfo()
    {
        return super.getBookInfo() + "-" + edition;
    }

    // Method canSubstituteFor
    public boolean canSubstituteFor(Textbook other)
    {
        return this.getTitle().equals(other.getTitle()) &&
               this.edition >= other.edition;
    }
}