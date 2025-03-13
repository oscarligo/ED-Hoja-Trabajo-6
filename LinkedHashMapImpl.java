import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapImpl<K, V> implements IMap<K, V> {
    
    private Map<K, V> map;

    public LinkedHashMapImpl() {
        this.map = new LinkedHashMap<>();
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
    public void remove(K name) {
        if (map.containsKey(name)) {
            map.remove(name);
        } else {
            System.out.println("El Pokémon no está en la colección.");
        }
    }

    public void showAll() {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
