public class KisiKisi2{

}

class CupcakeMachine{
    private int nums;
    private double cost;
    private int orderNumber;

    public CupcakeMachine(int n, double c){
        nums = n;
        cost = c;
        orderNumber = 0;
    }

    public String takeOrder(int order){
        if (order > nums)
            return "Order cannot be filled";
        nums -= order;
        orderNumber++;
        double total = cost * order;
        return "Order number "+ orderNumber + ", cost $" + total;
    }
}