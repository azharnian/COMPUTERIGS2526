public class FRQ2202{

}

class Book{
    private String title;
    private double price;
}

class Textbook extends Book{
    private int edition;

    public Textbook(String t, double p, int e){
        super(t, p);
        edition = e;
    }

    public int getEdition(){
        return edition;
    }

    @Override
    public String getBookInfo(){
        // return title + "-" + price + "-" + edition;
        return super.getBookInfo() + "-" + edition;
    }

    public boolean canSubstituteFor(Textbook tb){
        if (getTitle().equals(tb.getTitle())){
            if (edition >= tb.edition){
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}