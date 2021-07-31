import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class PancakeMakerTest {

	@Test
	public void testInstanceOf() {
		PancakeMaker p = new PancakeMaker();
		String[] a = {};
		assertTrue(p.determineWholeFoodsOrder(a) instanceof ArrayList);
	}
	@Test
	public void TestDetermineWholeFoodsOrder() {
		PancakeMaker p = new PancakeMaker();
		String[] a = {};
		ArrayList<String> lst = new ArrayList<String>();
		//"flour","salt","soda","powder","buttermilk","egg"
		lst.add("flour");
		lst.add("salt");
		lst.add("soda");
		lst.add("powder");
		lst.add("buttermilk");
		lst.add("egg");
		p.determineWholeFoodsOrder(a);
		assertTrue(lst.equals(p.determineWholeFoodsOrder(a)));
	}
	//bug is what if the person has nothing. The second for loop wouldn't run.
}
