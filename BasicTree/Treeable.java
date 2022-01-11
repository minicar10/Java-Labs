//Name - Erick Torres, Zachariah Joseph
//Date - January the 11th, 2022
//Class - Beck - 4th Period
//Lab  - Basic Tree

package BasicTree;

public interface Treeable {
	public Object getValue();

	public Treeable getLeft();

	public Treeable getRight();

	public void setValue(Comparable value);

	public void setLeft(Treeable left);

	public void setRight(Treeable right);
}