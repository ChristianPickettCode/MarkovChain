import java.util.ArrayList;

public class Grams {
	
	// Properties
	public String name;
	public ArrayList<Character> arr = new ArrayList<Character>();
	int length = 0;
	
	// Constructor
	public Grams (String name) {
		this.name = name;
	}
	
	// Add next character
	public void add(char contGram) {
		arr.add(contGram);
		length ++;
	}
	
	public char[] returnArr() {
		char[] array = new char[this.arr.size()];
		for (int i = 0; i < this.arr.size(); i++) {
			array[i] = this.arr.get(i);
		}
		return array;
	}
	
	
	public String printArr() {
		String txt = "";
		for (int i = 0; i < this.arr.size(); i++) {
			txt += this.arr.get(i) + " ";
		}
		return txt;
	}
	
	
	
}
