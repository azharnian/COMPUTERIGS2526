public class Main{

    public static void main(String[] args)
    {
        // Fish f = new Fish();
        // System.out.println(f);
        // Fish.say();
        // Math m = new Math();
        // System.out.println(m.sqrt(4));

        // Human m1 = new Human();
        // Human m2 = new Human();
        // Human m3 = new Human();

        // System.out.println(Human.getPopulation());
        // System.out.println(m3.getPopulation());

        doSomething();
    }

    public static void doSomething()
    {
        int n = 10;
        if (n < 100){
            System.out.println("ok");
            return;
        }
        System.out.println("not ok");
        return;
    }
}

class Fish{

    private Fish(){}

    // public void say(){
    //     System.out.println("Hi!");
    // }
    public static void say(){
        System.out.println("Hi!");
    }
}

class Human {
    private static Integer population = 0;

    Human()
    {
        population++;
    }

    public static Integer getPopulation()
    {
        return population;
    }
}