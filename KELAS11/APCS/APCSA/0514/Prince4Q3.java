public class Prince4Q3{

}

class Cookbook{
    private ArrayList recipeList;
    public void standardize(int numPeople){
        for (int i = 0; i < recipeList.size(); i++){
            Recipe r = recipeList.get(i);
            r.scaleRecipe(numPeople);
        }
    }
}

class Ingridient{

}

class Recipe {
    private String name;
    private ArrayList<Ingridient> ingridientList;
    private String description;
    private int numberServed;

    public Recipe(String n, int nS){
        name = n;
        numberServed = nS;

        ingridientList = new ArrayList<Ingridient>();
    }

    public void addIngridient(Ingridient i){ingridientList.add(i);}
    public void setDescription(String text){description = text;}
    public String getName(){ return name; }
    public ArrayList<Ingridient> getIngridientList(){ return ingridientList; }
    public int getNumberServed(){ return numberServed; }
    public void scaleRecipe(int newNumber){
        double scale = newNumber / (double) numberServed;

        for (int i = 0; i < ingridientList.size(); i++){
            Ingridient item = ingridientList.get(i);
            item.setAmount(item.getAmount() * scale);
        }

        numberServed = newNumber;
    }
}