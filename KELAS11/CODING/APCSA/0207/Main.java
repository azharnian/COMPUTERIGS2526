public class Main{
   public static void main(String[] args){
      Parent a = new Parent();
      Child b = new Child();
      Parent c = new Child();
      a.method1();  // Parent's method1
      b.method1();  // Child's method1
      c.method1();  // Child's method1
      ((Child)c).method2();  // error!
   }}


class Parent{
    public void method1(){
    	System.out.println("Parent");
    }
}
class Child extends Parent{
    public void method1(){
    	System.out.println("Child");
    }
    public void method2(){ 
        System.out.println("I'm Child");
     }
}

