import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;

import org.mockito.*;

public class RentACatTest {

	RentACat rc;

	@Before
    public void setup() {
		rc = new RentACat();
    }

	// Assert that creating a new RentACat instance
    // does not return a null reference
	@Test
    public void testRentACatExists() {
	assertNotNull(rc);
    }

    /** 
	 * TESTS for "returnCat(Cat c)" 
	 **/

	// When returning a rented cat, the .returnCat() method should be called on the cat object and return true
	@Test
    public void testReturnRentedCat() {
		Cat c = Mockito.mock(Cat.class);
		Mockito.when(c.getRented()).thenReturn(true);
		assertTrue(rc.returnCat(c));
		Mockito.verify(c, Mockito.times(1)).returnCat();
	}

	// When attempting to return a cat that hasn't been rented, returnCat should return false
	@Test
    public void testReturnNotRentedCat() {
		Cat c = Mockito.mock(Cat.class);
		Mockito.when(c.getRented()).thenReturn(false);
		assertFalse(rc.returnCat(c));
	}

    /** 
	 * TESTS for "rentCat(Cat c)" 
	 **/

	// When renting an available cat, the .rentCat() method should be called on the cat object and return true
	@Test
    public void testRentNotRentedCat() {
		Cat c = Mockito.mock(Cat.class);
		Mockito.when(c.getRented()).thenReturn(false);
		assertTrue(rc.rentCat(c));
		Mockito.verify(c, Mockito.times(1)).rentCat();
	}

	// When attempting to rent a cat that has been rented, rentCat should return false
	@Test
    public void testRentRentedCat() {
		Cat c = Mockito.mock(Cat.class);
		Mockito.when(c.getRented()).thenReturn(true);
		assertFalse(rc.rentCat(c));
	}

    /** 
	 * TESTS FOR "listCats(ArrayList<Cat> catList)" 
	 **/

	// If no cats are available, an empty string should be returned list by listCats
	@Test
	public void testEmptyList() {
		Cat c1 = Mockito.mock(Cat.class);
		Cat c2 = Mockito.mock(Cat.class);
		Cat c3 = Mockito.mock(Cat.class);
		ArrayList<Cat> cats = new ArrayList<Cat>();
		cats.add(c1);
		cats.add(c2);
		cats.add(c3);
		Mockito.when(c1.getRented()).thenReturn(true);
		Mockito.when(c2.getRented()).thenReturn(true);
		Mockito.when(c3.getRented()).thenReturn(true);
		Mockito.when(c1.toString()).thenReturn("c1");
		Mockito.when(c2.toString()).thenReturn("c2");
		Mockito.when(c3.toString()).thenReturn("c3");

		assertEquals(rc.listCats(cats), "");
	}

	// With some cats rented and other not rented, a list of only NON-RENTED cats
	// should be returned separated by "\n" characters
	@Test
	public void testListBothRentedandNot() {
		Cat c1 = Mockito.mock(Cat.class);
		Cat c2 = Mockito.mock(Cat.class);
		Cat c3 = Mockito.mock(Cat.class);
		ArrayList<Cat> cats = new ArrayList<Cat>();
		cats.add(c1);
		cats.add(c2);
		cats.add(c3);
		Mockito.when(c1.getRented()).thenReturn(false);
		Mockito.when(c2.getRented()).thenReturn(true);
		Mockito.when(c3.getRented()).thenReturn(false);
		Mockito.when(c1.toString()).thenReturn("c1");
		Mockito.when(c2.toString()).thenReturn("c2");
		Mockito.when(c3.toString()).thenReturn("c3");
		assertEquals(rc.listCats(cats), "c1\nc3");
	}

    /** 
	 * TESTS FOR "catExists(int id, ArrayList<Cat> catList)" 
	 **/

	// test that given a list of cats and id, return true if a cat exists in the list
	@Test
	public void testCatExistsReturnsTrue() {
		int testId = 1;
		Cat mockCat1 = Mockito.mock(Cat.class);
		Cat mockCat2 = Mockito.mock(Cat.class);
		Cat mockCat3 = Mockito.mock(Cat.class);
		ArrayList<Cat> catList = new ArrayList<Cat>();
		catList.add(mockCat1);
		catList.add(mockCat2);
		catList.add(mockCat3);
		Mockito.when(mockCat1.getId()).thenReturn(1);
		Mockito.when(mockCat2.getId()).thenReturn(2);
		Mockito.when(mockCat3.getId()).thenReturn(3);

		assertTrue(rc.catExists(testId, catList));
	}
	
	// test that given a list of cats and id, return false for a cat not in the list
	@Test
	public void testCatExistsReturnsFalse() {
		int testId = 7;
		Cat mockCat1 = Mockito.mock(Cat.class);
		Cat mockCat2 = Mockito.mock(Cat.class);
		Cat mockCat3 = Mockito.mock(Cat.class);
		ArrayList<Cat> catList = new ArrayList<Cat>();
		catList.add(mockCat1);
		catList.add(mockCat2);
		catList.add(mockCat3);
		Mockito.when(mockCat1.getId()).thenReturn(1);
		Mockito.when(mockCat2.getId()).thenReturn(2);
		Mockito.when(mockCat3.getId()).thenReturn(3);

		assertFalse(rc.catExists(testId, catList));
	}

	// test that when given an empty list of cats, returns false for catExists
	@Test
	public void testCatExistsEmpty() {
		int testId = 0;
		ArrayList<Cat> catList = new ArrayList<Cat>();
		assertFalse(rc.catExists(testId, catList));
	}
	/** 
	 * TESTS FOR "catAvailable(int id, ArrayList<Cat> catList)" 
	 **/ 
	
	// when a cat is available to rent, catAvailable should return false 
	@Test
	public void testCatAvailable() {
		int testId = 1;
		Cat c1 = Mockito.mock(Cat.class);
		Cat c2 = Mockito.mock(Cat.class);
		Cat c3 = Mockito.mock(Cat.class);
		ArrayList<Cat> catList = new ArrayList<Cat>();
		catList.add(c1);
		catList.add(c2);
		catList.add(c3);
		Mockito.when(c1.getId()).thenReturn(1);
		Mockito.when(c2.getId()).thenReturn(2);
		Mockito.when(c3.getId()).thenReturn(3);
		Mockito.when(c1.getRented()).thenReturn(false);
		Mockito.when(c2.getRented()).thenReturn(false);
		Mockito.when(c3.getRented()).thenReturn(true);

		assertTrue(rc.catAvailable(testId, catList));
	}
	
	// when a cat is not available to rent, catAvailable should return false 
	@Test
	public void testCatNotAvailable() {
		int testId = 3;
		Cat c1 = Mockito.mock(Cat.class);
		Cat c2 = Mockito.mock(Cat.class);
		Cat c3 = Mockito.mock(Cat.class);
		ArrayList<Cat> catList = new ArrayList<Cat>();
		catList.add(c1);
		catList.add(c2);
		catList.add(c3);
		Mockito.when(c1.getId()).thenReturn(1);
		Mockito.when(c2.getId()).thenReturn(2);
		Mockito.when(c3.getId()).thenReturn(3);
		Mockito.when(c1.getRented()).thenReturn(false);
		Mockito.when(c2.getRented()).thenReturn(false);
		Mockito.when(c3.getRented()).thenReturn(true);

		assertFalse(rc.catAvailable(testId, catList));
	}
	
	// test that an empty list of cats returns false when calling catAvailable 
	@Test
	public void testCatAvailableEmpty() {
		ArrayList<Cat> catList = new ArrayList<Cat>();
		assertFalse(rc.catAvailable(1, catList));
	}
	
    /** 
	 * TESTS FOR "getCat(int id, ArrayList<Cat> catList)" 
	 **/

	// test that given a list of cats and an id, return a reference to
	// the specified cat if a cat with that ID exists
	@Test
	public void testReturnReferencedCat() {
		int testId = 1;
		Cat mockReturn;
		Cat mockCat1 = Mockito.mock(Cat.class);
		Cat mockCat2 = Mockito.mock(Cat.class);
		Cat mockCat3 = Mockito.mock(Cat.class);
		ArrayList<Cat> catList = new ArrayList<Cat>();
		catList.add(mockCat1);
		catList.add(mockCat2);
		catList.add(mockCat3);
		Mockito.when(mockCat1.getId()).thenReturn(1);
		Mockito.when(mockCat2.getId()).thenReturn(2);
		Mockito.when(mockCat3.getId()).thenReturn(3);

		mockReturn = rc.getCat(testId, catList);
		assertSame(mockReturn, mockCat1);
	}
	
	// test that given a list of cats and an id, return null
	// when id not in the list 
	@Test
	public void testGetCatNull() {
		int testId = 4;
		Cat c1 = Mockito.mock(Cat.class);
		Cat c2 = Mockito.mock(Cat.class);
		Cat c3 = Mockito.mock(Cat.class);
		ArrayList<Cat> catList = new ArrayList<Cat>();
		catList.add(c1);
		catList.add(c2);
		catList.add(c3);
		Mockito.when(c1.getId()).thenReturn(1);
		Mockito.when(c2.getId()).thenReturn(2);
		Mockito.when(c3.getId()).thenReturn(3);
		assertNull(rc.getCat(testId, catList));
	}


}
