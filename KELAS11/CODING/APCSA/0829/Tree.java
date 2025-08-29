public class Tree {
    private String name;
    private double height;
    private int rateOfGrowth;

    // Constructor

    public Tree(String n, double h, int r)
    {
        name = n;
        height = h;
        rateOfGrowth = r;
    }

    public Tree(double h, int r)
    {
        height = h;
        rateOfGrowth = r;
    }

    public Tree(String n)
    {
        name = n;
    }

    public String toString()
    {
        return name + " can grow up to " + height + " feet high, at a rate of " + rateOfGrowth + " inches per year";
    }

}