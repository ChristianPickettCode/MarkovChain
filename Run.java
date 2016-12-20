import java.io.IOException;

public class Run {
	public static void main (String [] args) {
		
		String path = "/text.txt";

		try {

			for (int i = 0; i < 10; i++) {
				MarkovChain mc = new MarkovChain(6, 100);
				mc.readFile(path);
				//mc.printGrams();
				System.out.println(mc.markovIt());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
