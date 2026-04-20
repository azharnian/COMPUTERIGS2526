public class Q02{
    public static void main (String[] args) {
        LibraryBook b = new LibraryBook("PULANG", true);
        b.borrowBook();
        b.returnBook();
        System.out.println(b);
    }
}

class LibraryBook{
    public String title;
    private int id;
    private boolean available;
    public static int counter = 0;

    LibraryBook(){
        this("Default", false);
    }

    LibraryBook(String title, boolean available){
        this.title = title;
        this.available = available;
        counter++;
        this.id = counter;
    }
    @Override
    public String toString(){
        return this.title + ", tersedia = " + this.available;
    }

    public void borrowBook(){
        this.available = false;
    }

    public void returnBook(){
        this.available = true;
    }
}