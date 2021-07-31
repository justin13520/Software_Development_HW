/**
 * 
 * @author CS 2110 faculty
 * Solids interface
 * any class claiming to be a Solid must define these behaviors (fulfill this contract)
 *
 */
public interface Solids {
	/** return a double representing the interior volume of this Solid */
	public double getVolume();
	public String getColor();
	public String getName();
}
