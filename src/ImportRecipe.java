import java.io.*;
import java.util.*;

public class ImportRecipe {
    public static ArrayList<Recipe> main() {
        String fileLoc = "Recipes.csv";

        ArrayList<Recipe> recipes = new ArrayList<>();
        try {
            try (BufferedReader br = new BufferedReader(new FileReader(fileLoc))) {
                String line;
                // Read the next line of csv file
                while ((line = br.readLine()) != null) {
                    if (line.isEmpty()) {
                        continue;
                    }
                    // Split the line into an array of strings divided by "|"
                    String[] currentRecipe = line.split(",");
                    // Counter for recipe object fields
                    int j = 0;
                    // iterate array of CSV file lines
                    for (int i = 0; i < currentRecipe.length; i++) {
                        // "|" signifies a new recipe field, so increment j to move to next field
                        if (currentRecipe[i].equals("|")) {
                            j++;
                            i++;
                        }
                        switch (j) {
                            // Recipe name
                            case 0:
                                recipes.add(new Recipe(currentRecipe[i]));
                                break;
                            // Description
                            case 1:
                            recipes.get(recipes.size() - 1).setDescription(currentRecipe[i]);
                                break;
                            // Ingredients
                            case 2:
                                recipes.get(recipes.size() - 1).addIngredient(currentRecipe[i]);
                                break;
                            // Instructions
                            case 3:
                                recipes.get(recipes.size() - 1).addInstruction(currentRecipe[i]);
                                break;
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return recipes;
    }
}
