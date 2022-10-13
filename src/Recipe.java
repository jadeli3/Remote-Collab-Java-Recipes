import java.util.ArrayList;

public class Recipe {

    private String name;
    private ArrayList<String> ingredients;
    private ArrayList<String> instructions;

    public Recipe(String name) {
        this.name = name;
        this.ingredients = new ArrayList<>();
        this.instructions = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<String> ingredients) {
        this.ingredients = ingredients;
    }

    public ArrayList<String> getInstructions() {
        return instructions;
    }

    public void setInstructions(ArrayList<String> instructions) {
        this.instructions = instructions;
    }

    public void addIngredient(String ingredient) {
        this.ingredients.add(ingredient);
    }

    public void addInstruction(String instruction) {
        this.instructions.add(instruction);
    }

    public void removeIngredient(String ingredient) {
        this.ingredients.remove(ingredient);
    }

    public void removeInstruction(String instruction) {
        this.instructions.remove(instruction);
    }

    public String toString() {
        String recipe = "Recipe: " + this.name + "\n";
        recipe += "Ingredients: \n";
        for (String ingredient : this.ingredients) {
            recipe += " " + ingredient + "\n";
        }
        recipe += "Instructions: \n";
        for (String instruction : this.instructions) {
            recipe += " " + instruction + "\n";
        }
        return recipe;
    }

    public String toCSV() {
        String[] recipe = new String[this.ingredients.size() + this.instructions.size() + 5];
        recipe[0] = "\n" + this.name;
        recipe[1] = "|";
        for (int i = 0; i < this.ingredients.size(); i++) {
            recipe[i + 2] = this.ingredients.get(i);
        }
        recipe[this.ingredients.size() + 2] = "|";
        for (int i = 0; i < this.instructions.size(); i++) {
            recipe[i + this.ingredients.size() + 3] = this.instructions.get(i);
        }
        recipe[this.ingredients.size() + this.instructions.size() + 3] = "|";
        return String.join(",", recipe);

    }

}
