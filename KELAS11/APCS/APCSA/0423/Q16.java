public class Q16{

    public static void main(String[] args){
    Bandit anas = new Bandit(30);
    Human andi = new Human(29);

    System.out.println(anas.compareTo(andi));
    }
}

class Human{
    private int age;

    Human(int a){
        age = a;
    }

    public int compareTo(Human h){
        return age - h.age;
    }
}

class Bandit{
    private int age;

    Bandit(int a){
        age = a;
    }

    public int compareTo(Human h){
        return age - h.age;
    }
}