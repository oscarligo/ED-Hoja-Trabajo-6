/** Interfaz IMap para las distintas implementaciones */
public interface IMap<K, V> {
    void put(K name, V PokemonInformation);
    V get(K name, V PokemonInfirmation);
    void remove(K name);

}