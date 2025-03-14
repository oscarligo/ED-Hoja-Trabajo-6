import java.util.List;

/** Interfaz IMap para las distintas implementaciones de Mapas */
public interface IMap<K, V> {
    // Método para añadir un elemento al mapa
    void put(K name, V PokemonInformation);
    // Método para obtener un elemento del mapa
    V get(K name);
    // Método para obtener una lista de las llaves del mapa
    List<K> keys();
    // Método para mostrar todos los elementos del mapa
    void showAll();

}