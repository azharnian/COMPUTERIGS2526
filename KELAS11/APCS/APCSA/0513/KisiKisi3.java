public class KisiKisi3{

}

class ItemInfo{
    public String getName(){

    }
    public double getCost(){

    }
    public boolean isAvailable(){

    }
}

class ItemInventory{
    private ArrayList<ItemInfo> inventory;

    public double averageWithinRange(double lower, double upper){
        double totalCost = 0.0;
        int n = 0;

        for (int i = 0; i < inventory.size(); i++){
            if (inventory.get(i).isAvailable()){
                if (inventory.get(i).getCost() >= lower && inventory.get(i).getCost() <= upper){
                    total += inventory.get(i).getCost();
                    n++;
                }
            }
        }
        if (n > 0) return totalCost / n;
        return totalCost;
    }
}