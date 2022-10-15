import java.io.*;
import java.util.*;

public class SearchRecipe {
    public static void main(ArrayList<Recipe> recipeBook) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Do you want to search the recipe by name(enter 1) or view all the recipe first and then choose the one you want to search(enter 2): ");
        int choice = Integer.parseInt(input.readLine());
        if(choice == 1){
            int found = 0;
            System.out.println("Enter the recipe name: ");
            String recipe_search = input.readLine();
            for (Recipe recipe : recipeBook) {
                if(recipe.getName().toLowerCase().equals(recipe_search.toLowerCase())){
                    System.out.println("Recipe found: " + recipe_search);
                    found = 1;
                    System.out.println("Ingredients: ");
                    for (String ingredient : recipe.getIngredients()) {
                        System.out.println(ingredient);
                    }
                    System.out.println("Instructions: ");
                    for (String instructions : recipe.getInstructions()) {
                        System.out.println(instructions);
                    }
                }
            }
            if(found == 0){
                System.out.println("Sorry, we cannot find the recipe");
            }
        }
        else if(choice == 2){
            int found = 0;
            for (Recipe recipe : recipeBook) {
                System.out.println("Recipe name: " + recipe.getName());
                System.out.println("Ingredients: ");
                System.out.println(recipe.getIngredients());
                System.out.println("Instructions: ");
                System.out.println(recipe.getInstructions());
            }
            System.out.println("Enter the recipe name: ");
            String recipe_search = input.readLine();
            for (Recipe recipe : recipeBook) {
                if(recipe.getName().toLowerCase().equals(recipe_search.toLowerCase())){
                    found = 1;
                    System.out.println("Recipe found: " + recipe_search);
                    System.out.println("Ingredients: ");
                    for (String ingredient : recipe.getIngredients()) {
                        System.out.println(ingredient);
                    }
                    System.out.println("Instructions: ");
                    for (String instructions : recipe.getInstructions()) {
                        System.out.println(instructions);
                    }
                }
            }
            if(found == 0){
                System.out.println("Sorry, we cannot find the recipe");
            }
        }
    }
}
