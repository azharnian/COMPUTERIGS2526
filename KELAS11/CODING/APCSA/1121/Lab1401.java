public class Lab1401{
   public static void main(String[] args){
        MyComplex n = new MyComplex(3, -5);
        System.out.println(n);
   }
}

class MyComplex {

    private double real;
    private double img;

    public MyComplex(){
        real = 0;
        img = 0;
    }

    public MyComplex(double a, double b){
        real = a;
        img = b;
    }

    public void setReal(double r){ real = r; }
    public void setImg(double i){ img = i; }

    public double getReal(){ return real; }
    public double getImg(){ return img; }

    public String toString(){
        if (img >= 0){return real + "+" + img + "i";}
        return real + "" + img + "i";
    }

}