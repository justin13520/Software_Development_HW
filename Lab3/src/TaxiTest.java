import static org.junit.Assert.*;

import org.junit.*;


public class TaxiTest {
	
	Taxi t;
	
	@Before
	public void setup() {
		t = new Taxi(12.00, 5);
	}

    //Sample Unit Test
    @Test(timeout=100)
    public void testPickUpSuccess() {
        assertTrue(t.pickUp(3));
        assertFalse(t.pickUp(3));
    }
    
    //calculateFare() test
    @Test(timeout=100)
    public void testCalculateFare() {
        assertTrue(t.calculateFare(5, 30)==420);
    }
    
    //pickUp() test #1
    @Test(timeout=100)
    public void testPickUpEnoughRoom() {
        assertTrue(t.pickUp(3));
    }
    
    //pickUp() test #2
    @Test(timeout=200)
    public void testPickUpEnoughRoom2() {
    	assertFalse(t.pickUp(7));
    }
}