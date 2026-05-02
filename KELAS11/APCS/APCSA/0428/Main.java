public class Main{
    public static void main(String[] args){
        Computer.sayHello();
    }
}

class Computer{

    private Computer(){};

    public static void sayHello(){
        System.out.println("Hello..");
    }
}