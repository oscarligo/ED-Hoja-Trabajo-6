import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        // Leer el archivo CSV con los pokemones

        ArrayList<ArrayList<String>> pokemones = CSVReader("Pokemons.csv");


        // Menú principal

        String opcion = "";
        Scanner scanner = new Scanner(System.in);


        IMap<String, ArrayList<String>> pokemonMap = null; 
        IMap<String, ArrayList<String>> coleccionUsuario = new LinkedHashMapImpl<>();

        // Seleccionar el tipo de mapa a utilizar

        while (!opcion.equals("4")) {
            System.out.println("============= Selección de Mapa a Utilizar:===========");
            System.out.println("1. LinkedHashMap");
            System.out.println("2. TreeMap");
            System.out.println("3. HashMap");
            System.out.println("4. Salir");
            System.out.print("Opción: ");
            opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    pokemonMap = new LinkedHashMapImpl<>();
                    break;
                case "2":
                    pokemonMap = new TreeMapImpl<>();
                    break;
                case "3":
                    pokemonMap = new HashMapImpl<>();
                    break;
                case "4":
                    System.out.println("Saliendo del Programa...");
                    return; 
                default:
                    System.out.println("Opción no válida.");
                    continue; 
            }

            for (ArrayList<String> pokemon : pokemones) {
                String nombre = pokemon.get(0); // Suponiendo que el nombre está en la primera columna
                pokemonMap.put(nombre, pokemon);
            }

            // Submenú para operaciones con los Pokémon

            String opcion2 = "";
            while (!opcion2.equals("5")) {
                System.out.println("\n=========== Collección Pokemón ===========");

                System.out.println("1. Agregar Pokémon a la colección personal");
                System.out.println("2. Mostrar Pokémones de la Collección");
                System.out.println("3. Mostrar datos de un Pokémon");

                System.out.println("4. Mostrar Todos los Pokemones Registrados");
                System.out.println("5. Buscar Pokémones por habilidad");
                System.out.println("6. Volver al menú principal");

                System.out.print("Opción: ");
                opcion2 = scanner.nextLine();

                switch (opcion2) {
                    case "1":


                        
                        break;
                    case "2":
                        
                        break;
                    case "3":
                    
                        break;
                    case "4":
                        
                        break;
                    case "5":
                

                        break;

                    case "6":
                        System.out.println("Regresando al menú principal...");
                        return;
                    default:
                        System.out.println("Opción no válida.");
                }
            }
        }
        scanner.close();
    }


    public static ArrayList<ArrayList<String>> CSVReader(String docName) {
        ArrayList<ArrayList<String>> Pokemones = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(docName));
            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(",");
                ArrayList<String> Pokemon = new ArrayList<>();
                for (String field : fields) {
                    Pokemon.add(field);
                }
                Pokemones.add(Pokemon);
                line = br.readLine();
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo.");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");
        }
                return Pokemones;
        
    }
}