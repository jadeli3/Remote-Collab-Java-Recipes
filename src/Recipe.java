import java.util.ArrayList;

public class Recipe {

    private String name;
    private String description;
    private ArrayList<String> ingredients;
    private ArrayList<String> instructions;

    public Recipe(String name) {
        this.name = name;
        this.description = "";
        this.ingredients = new ArrayList<>();
        this.instructions = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
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
        recipe += "Description: " + this.description + "\n";
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
        String[] recipe = new String[this.ingredients.size() + this.instructions.size() + 6];
        recipe[0] = "\n" + this.name;
        recipe[1] = "|";
        recipe[2] = this.description;
        recipe[3] = "|";
        for (int i = 0; i < this.ingredients.size(); i++) {
            recipe[i + 4] = this.ingredients.get(i);
        }
        recipe[this.ingredients.size() + 4] = "|";
        for (int i = 0; i < this.instructions.size(); i++) {
            recipe[i + this.ingredients.size() + 5] = this.instructions.get(i);
        }
        recipe[this.ingredients.size() + this.instructions.size() + 5] = "|";
        return String.join(",", recipe);

    }

}
