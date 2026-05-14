public class SOAL3{

}
import java.util.ArrayList;

class Cookbook
{
    private ArrayList<Recipe> recipeList;

    public void standardize(int numPeople)
    {
        for (Recipe r : recipeList)
        {
            r.scaleRecipe(numPeople);
        }
    }
}

class Recipe
{
    private String name;

    private ArrayList<Ingredient> ingredientList;

    private String description;

    private int numberServed;

    public Recipe(String n, int numServed)
    {
        name = n;

        numberServed = numServed;

        ingredientList =
            new ArrayList<Ingredient>();

        description = "";
    }

    // add an ingredient to recipe
    public void addIngredient(Ingredient ing)
    {
        ingredientList.add(ing);
    }

    // set preparation description
    public void setDescription(String desc)
    {
        description = desc;
    }

    // return recipe name
    public String getName()
    {
        return name;
    }

    // return ingredient list
    public ArrayList<Ingredient>
        getIngredientList()
    {
        return ingredientList;
    }

    // return number served
    public int getNumberServed()
    {
        return numberServed;
    }

    // scale recipe to new number
    public void scaleRecipe(int newNumber)
    {
        double factor =
            (double) newNumber / numberServed;

        for (Ingredient ing : ingredientList)
        {
            double newAmount =
                ing.getAmount() * factor;

            ing.setAmount(newAmount);
        }

        numberServed = newNumber;
    }
}

class Ingredient
{
    private String name;

    private double amount;

    public Ingredient(String n, double amt)
    {
        name = n;

        amount = amt;
    }

    // returns amount
    public double getAmount()
    {
        return amount;
    }

    public void setAmount(double amt)
    {
        amount = amt;
    }
}