import java.io.*;
import java.util.*;

class RecipeBook {

    public static void main(String[] args) throws IOException {

        String welcomeMessage = """

                 ____                         _
                |  _ \\  ___ _ __   __ _ _   _(_)_ __
                | | | |/ _ \\ '_ \\ / _` | | | | | '_ \\
                | |_| |  __/ | | | (_| | |_| | | | | |
                |____/ \\___|_| |_|\\__, |\\__,_|_|_| |_|
                                  |___/
                        """;
        welcomeMessage += "\n\nWelcome to the Recipe Book!\nEnter a command to get started.\ntype 'help' for commands or 'exit' to quit\n";

        System.out.println(welcomeMessage);

        File csvFile = new File("Recipes.csv");
        ArrayList<Recipe> recipeBook = ImportRecipe.main();

        try (FileWriter csvWriter = new FileWriter(csvFile, true)) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                System.out.print("~~~~~~Main Menu~~~~~~");
                System.out.println("\nenter a command: ");
                String input = reader.readLine();
                if (input.toLowerCase().equals("exit")) {
                    break;
                }

                // System.out.println("Input start:" + input);
                switch (input.toLowerCase()) {
                    case "help":
                        System.out.println("""
                                help - display this message
                                add - add a recipe
                                list - list all recipes
                                search - search for a recipe
                                view  - view a recipe (whole or line by line)
                                exit - exit the program
                                """);
                        break;
                    case "add":
                        while (true) {
                            System.out.println("Enter the name of the recipe: ");
                            String name = reader.readLine();
                            if (name.isEmpty()) {
                                System.out.println("Name cannot be empty");
                                continue;
                            }
                            System.out.println("Enter the description of the recipe: ");
                            String description = reader.readLine();
                            
                            Recipe recipe = new Recipe(name);
                            recipe.setDescription(description);

                            while (true) {
                                System.out.println("Enter an ingredient (or press enter to finish): ");
                                String ingredient = reader.readLine();
                                if (ingredient.isEmpty()) {
                                    break;
                                }
                                recipe.addIngredient(ingredient);
                            }
                            while (true) {
                                System.out.println("Enter an instruction (or press enter to finish): ");
                                String instruction = reader.readLine();
                                if (instruction.isEmpty()) {
                                    break;
                                }
                                recipe.addInstruction(instruction);
                            }
                            recipeBook.add(recipe);
                            csvWriter.append(recipe.toCSV());
                            System.out.println("Recipe added: " + recipe);
                            break;
                        }
                        break;
                    case "search":
                        SearchRecipe.main(recipeBook);
                        break;
                    case "list":
                        recipeBook.forEach(recipe -> {
                            System.out.println(recipe.toString());
                        });
                        break;
                    case "view":
                        ViewRecipe.main(recipeBook);
                        break;
                    default:
                        System.out.println("invalid command");
                        break;
                }
                System.out.println("\n------------------------------");
            }
        }

    }

}
