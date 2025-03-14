import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;


/**
 * Implementación de un HashMap para almacenar los Pokemones
 * @author: Oscar Rompich 24880
 * 
 */



public class HashMapImpl<K,V> implements IMap<K, V> {

    private HashMap<K, V> map; // Mapa para almacenar los Pokemones

    public HashMapImpl() {
        this.map = new HashMap<>();
    }

    /**
     * Método para agregar un Pokémon al mapa
     * @param name: Nombre del Pokémon
     * @param value: Lista con los datos del Pokémon
     */
    
    @Override
    public void put(K name, V value) {
        if (!map.containsKey(name)) {
            map.put(name, value);
        } else {
            System.out.println("El Pokémon ya está en la colección.");
            
        }
    }


    /**
     * Método para obtener un Pokémon del mapa
     * @param name: Nombre del Pokémon
     * @return: Lista con los datos del Pokémon
     */

    @Override
    public V get(K name) {
        return map.get(name);
    }

    /**
     * Método para obtener una lista de nombres de los Pokemones
     * @return: Lista con los nombres de los Pokemones
     */

    @Override
    public List<K> keys() {
        return new ArrayList<>(map.keySet());
    }

    /**
     * Método para mostrar todos los Pokemones registrados en un mapa
     */

    public void showAll() {

    // Lista de Pokemones a partir del Mapas

    List<HashMap.Entry<K, V>> listaPokemones = new ArrayList<>(map.entrySet());

    // Ordenar la lista de Pokemones por Tipo 1
    listaPokemones.sort(Comparator.comparing(pokemon -> ((ArrayList<String>) pokemon.getValue()).get(2)));

    // Mostrar los Pokémon ordenados por Tipo 1
    for (HashMap.Entry<K, V> entry : listaPokemones) {
        System.out.println(entry.getKey() + " -> Tipo 1: " + ((ArrayList<String>) entry.getValue()).get(2));
    }

    }
        

}

    

    
