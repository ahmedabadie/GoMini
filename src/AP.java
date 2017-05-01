
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import java_cup.runtime.Symbol;

public class AP {

	public static void main(String[] args) {

		String inFile = "MS3/Go3.in";
		String outFile = "MS3/Go3.out";

		if (args.length > 1) {
			inFile = args[0];
		}

		try {
			FileReader fis = new FileReader(inFile);
			BufferedReader bis = new BufferedReader(fis);

			BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));

			@SuppressWarnings("deprecation")
			parser parser = new parser(new Lexer(bis));

			try {
				parser.parse();
				System.out.println(parser.output);
				writer.write("Done");
			} catch (Exception e) {
				e.printStackTrace();
				writer.write("ParseError");	
				
			}
			
			fis.close();
			bis.close();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
