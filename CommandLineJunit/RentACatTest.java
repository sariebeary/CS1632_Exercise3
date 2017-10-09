import org.junit.*;
import static org.junit.Assert.*;

import org.mockito.*;

public class RentACatTest {
	
	RentACat rc;
	
	@Before
    public void setup() {
		rc = new RentACat();
    }
	
    // TESTS FOR RENTACAT.JAVA
    // At least 1 test for each method
    // ** 2 tests for each modified method **
	
	//public ArrayList<Cat> cats = new ArrayList<Cat>();

    // ** tests for "returnCat(Cat c)" **
	
	// When returning a rented cat, the .returnCat() method should be called on the cat object. 
	@Test
    public void testNormalReturn() {
		Cat c = Mockito.mock(Cat.class);
		Mockito.when(c.getRented()).thenReturn(true);
		rc.returnCat(c);
		Mockito.verify(c, Mockito.times(1)).returnCat();
	}

    // ** tests for "rentCat(Cat c)" **

    // ** tests for "listCats(ArrayList<Cat> catList)" **

    // ** tests for "catExists(int id, ArrayList<Cat> catList)" **

    // tests for "catAvailable(int id, ArrayList<Cat> catList)"

    // tests for "getCat(int id, ArrayList<Cat> catList)"


}
