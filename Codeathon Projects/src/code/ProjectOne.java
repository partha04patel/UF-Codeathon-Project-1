package code; 
import java.util.Scanner;
import java.io.*;
public class ProjectOne {

	public static void main (String [] args) {
		@SuppressWarnings("resource")
		Scanner rawtext = new Scanner (System.in);
		String input = rawtext.nextLine();
		String output = decipher(input);
		System.out.println(output);
		try {
		FileWriter outputFile = new FileWriter ("output.txt", true);
		PrintWriter outputText = new PrintWriter(outputFile);
		outputText.println(output);
		outputText.close();
				} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
		public static String decipher (String text) {
			String lowerCaseAlphabet ="abcdefghijklmnopqrstuvwxyz";
			String lowerCaseCoded = "zyxwvutsrqponmlkjihgfedcba";
			String upperCaseAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			String upperCaseCoded = "ZYXWVUTSRQPONMLKJIHGFEDCBA";
			String numbers = "123456789";
			String codedNumbers = "987643210";
			int index = 0;
			String	decoded ="";
			
			for (int i = 0; i <text.length();i++) {
				    char letter = text.charAt(i);
					int ASCII = (int) letter;
					if ((ASCII>64 &&ASCII<91)||(ASCII>96 && ASCII< 123)||(ASCII>47 && ASCII <58)) {
				
							if (ASCII>64 && ASCII<91) {
								index = upperCaseAlphabet.indexOf(letter);
								decoded = decoded + upperCaseCoded.charAt(index);
							}
							if (ASCII>96 && ASCII<123) {
								index = lowerCaseAlphabet.indexOf(letter);
								decoded = decoded + lowerCaseCoded.charAt(index);
							}
					
							if (ASCII>47 && ASCII<58) {
								if (numbers.indexOf(letter) < 0) {
									decoded = decoded + letter;
								}
								else {
									index = numbers.indexOf(letter);
									decoded = decoded + codedNumbers.charAt(index);
								}
									
							}
					}
					else {
						decoded =decoded + letter;
					}
			}
			return decoded;
			}
}
		
		

