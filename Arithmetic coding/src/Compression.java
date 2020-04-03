import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Compression {
	String input;
	ArrayList<Item> items = new ArrayList<Item>();

	public Compression() {
		input = "";
	}

	public Compression(String input) {
		this.input = input;
	}

	private void setProbability() {
		ArrayList<Character> elements = new ArrayList<Character>();
		for (int i = 0; i < input.length(); i++) {
			float counter = 0;
			if (!elements.contains(input.charAt(i))) {
				for (int j = i; j < input.length(); j++) {
					if (input.charAt(i) == input.charAt(j))
						counter++;
					if (j == input.length() - 1) {
						Item c = new Item();
						c.symbol = input.charAt(i);
						c.prob = counter / (float) input.length();
						items.add(c);
					}
				}
			}
			elements.add(input.charAt(i));
		}
		int n = items.size();
		// One by one move boundary of unsorted subarray
		for (int i = 0; i < n - 1; i++) {
			// Find the minimum element in unsorted array
			int min = i;
			for (int j = i + 1; j < n; j++) {
				if (items.get(j).symbol < items.get(min).symbol) {
					min = j;
				}
			}
			char temp = items.get(min).symbol;
			items.get(min).symbol = items.get(i).symbol;
			items.get(i).symbol = temp;

			float temp2 = items.get(min).prob;
			items.get(min).prob = items.get(i).prob;
			items.get(i).prob = temp2;
		}
		for (int i = 0; i < items.size(); i++) {
			if (i == 0) {
				items.get(i).lower = 0;
				items.get(i).higher = items.get(i).prob;
			} else {
				items.get(i).lower = items.get(i - 1).higher;
				items.get(i).higher = items.get(i).lower + items.get(i).prob;
			}
		}
	}

	private String getTheNumber(float low, float high) {
		double random = ThreadLocalRandom.current().nextDouble(low, high);
		String strDouble = String.format("%.4f", random);
		return strDouble;
	}

	private Item search(char c) {
		Item m = new Item();
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).symbol == c) {
				m = items.get(i);
				break;
			}
		}
		return m;
	}

	public String makeCompression() {
		setProbability();
		float low = 0, high = 1, range = 1, low2 = 0;
		for (int i = 0; i < input.length(); i++) {
			low = low + range * search(input.charAt(i)).lower;
			high = low2 + range * search(input.charAt(i)).higher;
			low2 = low;
			range = high - low;
		}
		return (getTheNumber(low, high));
	}
	
	public void writeData() throws IOException{
		System.out
		.println("Enter the name of the file you want to write in : ");
		Scanner in = new Scanner(System.in);
		String fileName = in.next();
		FileWriter out = new FileWriter(fileName);
		out.write(makeCompression()+" ");
		for (int i = 0; i < items.size() ; i++) {
			out.write(items.get(i).symbol+" "+items.get(i).prob+" ");
		}
		out.write(input.length()+" ");
		out.close();
	}
}
