public class Factory {

    public static <K,V> IMap<K,V> mapFactory(String mapType) {
        switch (mapType) {

            //LinkedHashMap, 
            case "1":
                return (IMap<K, V>) new LinkedHashMapImpl<K, V>();
            //TreeMap
            case "2":
                return (IMap<K, V>) new TreeMapImpl<K, V>();
            //HashMap
            case "3":
                return (IMap<K, V>) new HashMapImpl<K, V>();
            default:
                throw new IllegalArgumentException("No es un tipo de mapa válido");
        }
    }

}
