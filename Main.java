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



        // Mapa para almacenar los pokemones
        IMap<String, ArrayList<String>> pokemonMap = null; 

        // Mapa para almacenar los pokemones del usuario, se uso un LinkedHashMap 
        // ya que es más eficiente para la búsqueda de elementos
        
        IMap<String, ArrayList<String>> coleccionUsuario = new LinkedHashMapImpl<>();

        // Seleccionar el tipo de mapa a utilizar
        while (!opcion.equals("4")) {
            System.out.println("\n============= Selección de Mapa a Utilizar:===========\n");
            System.out.println("1. LinkedHashMap");
            System.out.println("2. TreeMap");
            System.out.println("3. HashMap");
            System.out.println("4. Salir");
            System.out.print("\n(+) Seleccione el número de la implementación que desea realizar: ");
            opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    pokemonMap = Factory.mapFactory("1");
                    break;
                case "2":
                    pokemonMap = Factory.mapFactory("2");
                    break;
                case "3":
                    pokemonMap = Factory.mapFactory("3");
                    break;
                case "4":
                    System.out.println("Saliendo del Programa...");
                    return; 
                default:
                    System.out.println("Opción no válida.");
                    continue; 
            }

            for (ArrayList<String> pokemon : pokemones) {
                // El nombre del pokemon es el primer elemento de la lista
                String nombre = pokemon.get(0); 
                pokemonMap.put(nombre, pokemon);
            }

            // Submenú para operaciones con los Pokémon

            String opcion2 = "";
            while (!opcion2.equals("6")) {
                System.out.println("\n=========== Collección Pokemón ===========\n");

                System.out.println("1. Agregar Pokémon a la colección personal");
                System.out.println("2. Mostrar Pokémones de la Collección Personal.");
                System.out.println("3. Mostrar datos de un Pokémon\n");

                System.out.println("4. Mostrar Todos los Pokemones Registrados");
                System.out.println("5. Buscar Pokémones por habilidad");
                System.out.println("6. Volver al menú principal\n");

                System.out.print("\n(+) Seleccione el número de la opción que desea realizar: ");
                opcion2 = scanner.nextLine();

                switch (opcion2) {
                    case "1":

                        System.out.print("Nombre del Pokémon: ");
                        String nombre = scanner.nextLine();

                        //
                        ArrayList<String> pokemon = pokemonMap.get(nombre);
                        if (pokemon != null) {
                            if (coleccionUsuario.get(nombre) != null) {
                                System.out.println("El Pokémon ya está en la colección.");
                                
                            } else {
                                coleccionUsuario.put(nombre, pokemon);
                                System.out.println("Pokémon agregado a la colección personal.");
                            }
                        } else {
                            System.out.println("El Pokémon no está registrado.");
                        }

                        break;
                    case "2":
                        coleccionUsuario.showAll();

                        break;
                    case "3":
                        System.out.print("\nNombre del Pokémon: ");
                        nombre = scanner.nextLine();

                        pokemon = pokemonMap.get(nombre);
                        if (pokemon != null) {

                            System.out.println("Tipo 1: " + pokemon.get(2));
                            System.out.println("Tipo 2: " + pokemon.get(3));
                            System.out.println("Clasificación: " + pokemon.get(4));

                        } else {
                            System.out.println("El Pokémon no está registrado.");
                        }
                    
                        break;
                    case "4":

                        pokemonMap.showAll();
                        
                        break;
                    case "5":

                        System.out.print("Ingrese la habilidad a buscar: ");
                        String habilidad = scanner.nextLine().toLowerCase(); 
                        // Convertimos a minúsculas para evitar errores de mayúsculas
                        System.out.println("Pokémones con la habilidad " + habilidad + ":\n");

                        for (String key : pokemonMap.keys()) {
                            ArrayList<String> pokemonData = pokemonMap.get(key);
                            if (pokemonData.get(7).toLowerCase().contains(habilidad)) {
                                System.out.println("Nombre: " + key);
                                System.out.println();

                            } 
                            
                        }
                        
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