import java.io.*;

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
        try (FileWriter csvWriter = new FileWriter(csvFile, true)) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while (true) {

                System.out.println("\nenter a command: ");
                String input = reader.readLine();
                if (input.toLowerCase().equals("exit")) {
                    break;
                }

                switch (input.toLowerCase()) {
                    case "help":
                        System.out.println("""
                                help - display this message
                                add - add a recipe
                                list - list all recipes
                                search - search for a recipe
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
                            Recipe recipe = new Recipe(name);
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
                            csvWriter.append("\n" + recipe.toCSV());
                            System.out.println("Recipe added: " + recipe);
                            break;
                        }
                        break;
                    case "list":
                        System.out.println("list");
                        break;
                    case "search":
                        System.out.println("search");
                        break;
                    default:
                        System.out.println("invalid command");
                        break;
                }
            }
        }
    }

}
