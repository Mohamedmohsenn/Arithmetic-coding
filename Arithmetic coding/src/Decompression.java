import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Decompression {
	float value;
	ArrayList<Item> items = new ArrayList<Item>();
	int inputSize;

	public Decompression() {
	}

	public void getData() throws FileNotFoundException {
		System.out
				.println("Enter the name of the file you want to read from : ");
		Scanner in = new Scanner(System.in);
		String fileName = in.next();
		File f = new File(fileName);
		if (f.isFile()) {
			String input2 = new Scanner(new File(fileName)).useDelimiter("\\z")
					.next();
			String[] str = input2.split(" ");
			Item c = new Item();
			for (int i = 0; i < str.length; i++) {
				if (i == 0) {
					value = Float.parseFloat(str[0]);
				}
				else if (i == str.length-1) {
					inputSize = Integer.valueOf(str[i]);
				}
				else if (i % 2 == 1) {
					c.symbol = str[i].charAt(0);
				} else if (i % 2 == 0) {
					c.prob = Float.parseFloat(str[i]);
					items.add(c);
					c = new Item();
				}
			}
			for (int i = 0; i < items.size(); i++) {
				if (i == 0) {
					items.get(i).lower = 0;
					items.get(i).higher = items.get(i).prob;
				} else {
					items.get(i).lower = items.get(i - 1).higher;
					items.get(i).higher = items.get(i).lower
							+ items.get(i).prob;
				}
			}
		}
	}

	public String Decompress() {
		String finalWord = "";
		float code = value, range = 0, lower = 0;
		for (int i = 0; i < inputSize; i++) {
			for (int j = 0; j < items.size(); j++) {
				if (code <= items.get(j).higher && code >= items.get(j).lower) {
					finalWord += items.get(j).symbol;
					range = items.get(j).higher - items.get(j).lower;
					lower = items.get(j).lower;
					break;
				}
			}
			code = (code - lower) / range;
		}
		return finalWord;
	}
	
	public void writeData() throws IOException{
		System.out
		.println("Enter the name of the file you want to write in : ");
		Scanner in = new Scanner(System.in);
		String fileName = in.next();
		FileWriter out = new FileWriter(fileName);
		out.write(Decompress());
		out.close();
	}

}
