/** Interfaz IMap para las distintas implementaciones de Mapas */
public interface IMap<K, V> {
    // Método para añadir un elemento al mapa
    void put(K name, V PokemonInformation);
    // Método para obtener un elemento del mapa
    V get(K name);
    // Método para eliminar un elemento del mapa
    void remove(K name);
    // Método para mostrar todos los elementos del mapa
    void showAll();

}