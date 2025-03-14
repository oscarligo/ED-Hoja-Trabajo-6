import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import java.util.ArrayList;
import java.util.Arrays;



public class UnitTests {

    private HashMapImpl<String, ArrayList<String>> pokemonMap;
    private ArrayList<String> pokemon1;
    private ArrayList<String> pokemon2;

    @Before
    public void setUp() {
        pokemon1 = new ArrayList<>(Arrays.asList("Pikachu", "Electric", "Yellow"));
        pokemon2 = new ArrayList<>(Arrays.asList("Charmander", "Fire", "Orange"));
        pokemonMap = new HashMapImpl<>();
        pokemonMap.put(pokemon1.get(0), pokemon1);       
        pokemonMap.put(pokemon2.get(0), pokemon2);


    }

    @Test
    public void shouldBeAbleToPutElements() {
        assertEquals(pokemon1, pokemonMap.get("Pikachu"));
    }

    @Test
    public void shouldBeAbleToGetElements() {
        assertEquals(pokemon2, pokemonMap.get("Charmander"));
    }

    @Test
    public void shouldBeAbleToGetKeys() {
        assertEquals(new ArrayList<>(Arrays.asList("Pikachu", "Charmander")), pokemonMap.keys());
    }

}
