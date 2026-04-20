public class Emp {
    public String name = "John";

    // Emp(String n)
    // {
    //     name = n;
    // }

    public String toString(){
        return "This emp is " + name;
    }

    public void printObj(){
        System.out.println(this.toString());
    }

    public static void main(String[] args){
        Emp e = new Emp();
        Emp f = e;
        e.name = "Jane";
        // System.out.println(e);
        e.printObj();
        f.printObj();
    }
}