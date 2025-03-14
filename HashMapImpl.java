import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;



public class HashMapImpl<K,V> implements IMap<K, V> {

    private HashMap<K, V> map;

    public HashMapImpl() {
        this.map = new HashMap<>();
    }

    @Override
    public void put(K name, V value) {
        if (!map.containsKey(name)) {
            map.put(name, value);
        } else {
            System.out.println("El Pokémon ya está en la colección.");
            
        }
    }

    @Override
    public V get(K name) {
        return map.get(name);
    }

    @Override
    public List<K> keys() {
        return new ArrayList<>(map.keySet());
    }

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

    

    
