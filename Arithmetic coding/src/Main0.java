import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main0 {
	public static void main(String args[]) throws IOException {
		Scanner in = new Scanner(System.in);
		while (true) {
			System.out.println("Do you want to Compress or Decompress");
			String answer = in.next();
			if (answer.equals("compress")) {
				System.out
						.println("Enter the name of the file you want to read from : ");
				String fileName = in.next();
				String input = "";
				File f = new File(fileName);
				if (f.isFile()) {
					Scanner inp = new Scanner(new File(fileName));
					input = inp.next();
					inp.close();
					Compression c = new Compression(input);
					c.writeData();

				}
			} else if (answer.equals("decompress")) {
				Decompression d = new Decompression();
				d.getData();
				d.writeData();
			}
		}
	}
}
