import static org.junit.Assert.*;

import org.junit.Test;
public class inClass13Test {

	@Test
	public void testPower2Positive() {
		assertTrue(8 == InClass13.power(2,3));
		assertTrue((double)1/8 == InClass13.power(2,-3));
		assertTrue((double)-1/8 == InClass13.power(-2, -3));
	}

	@Test
	public void testPower0And1Negative() {
		int a = -(int) Math.random();
		int b = (int) Math.random();
		assertTrue(InClass13.power(0, a) == Double.NaN);
	}
	@Test
	public void testClass() {
		InClass13 a = new InClass13();
		assertTrue(a instanceof InClass13);
	}
}
