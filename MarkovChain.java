import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MarkovChain {
	
	// Properties
	private int order;
	private int lengthOfSentence;
	private List<Grams> nGrams = new ArrayList<Grams>();
	private String file = "";
	private List<String> list = new ArrayList<String>();
	
	// Constructor
	public MarkovChain (int order, int lengthOfSentence) {
		this.order = order;
		this.lengthOfSentence = lengthOfSentence;
	}
	
	// Read file
	public void readFile(String filename) throws IOException {
		Scanner io = new Scanner(new File(filename));
		
		while (io.hasNextLine()) {
			file += io.nextLine();
		}
		populate();
	}
	
	// Add n-grams to array
	public void populate () {
		for (int i = 0; i < file.length() - this.order; i++) {
			String gram = file.substring(i, i + this.order);
			
			// Gram not in array
			if (!list.contains(gram)) {
				// Create new gram and add to array
				Grams newGram = new Grams(gram);
				nGrams.add(newGram);
				int n = getIndex(gram);
				nGrams.get(n).length = 1;
				list.add(gram);
			}
			
			// If gram in array increase the length and add next part of gram to grams object
			int n = getIndex(gram);
			nGrams.get(n).length++;
			nGrams.get(n).arr.add(file.charAt(i + this.order));
			
		}
		
		
	}
	
	// Print gram
	public void printGrams () {
		
		for (int i = 0; i < this.nGrams.size(); i++) {
			System.out.println(nGrams.get(i).name + "," + nGrams.get(i).length);
			for (int j = 0; j < this.nGrams.get(i).arr.size(); j++) {
				System.out.print(this.nGrams.get(i).arr.get(j) + " ");
			} 
			System.out.println("");
		}
		
		System.out.println("Nothing");
	}
	
	// Get index of specific gram in arraylist
	public int getIndex(String name) {
		
		int num = 0;
		for (int i = 0; i < this.nGrams.size(); i++) {
			if(nGrams.get(i).name.equals(name)) {
				num = i;
			}
		}
		return num;
		
	}
	
	// Connect grams based on current gram
	public String markovIt() {
		
		String currentGram = this.file.substring(0, this.order);
		String result = currentGram;
		
		for (int i = 0; i < this.lengthOfSentence; i++) {
			int indexOfCurr = getIndex(currentGram);
			// Possible next characters in gram
			char[] possibilites = nGrams.get(indexOfCurr).returnArr();	
			
			if (possibilites == null){ 
				break; 
			}
			
			// Next random character based on possible characters
			char next = possibilites[(int) (Math.random() * possibilites.length)];
			
			result += next;
			int len = result.length();
			
			currentGram = result.substring(len - order, len);
		}
		
		
		
		return result;
	}
	
	
	
	
}
