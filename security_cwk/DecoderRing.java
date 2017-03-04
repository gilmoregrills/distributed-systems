/**
 * @Author Robin Yonge
 * Deciphering Hex Dumps!
 */
import java.io.*;
import java.util.*;

/**
 * So I think the idea with this is to convert any hex
 * into an array of chars so it's easy to work with 
 * and then to xor it along with another arry of chars
 * this leaves me plenty of flexibility regarding which 
 * ciphertexts I want to xor together, or allows me to
 * use any custom keys if I want to as I get closer to
 * deciphering, intermediate results can output to files
 */
public class DecoderRing {

	String cipherPath = "~/ciphertext1.txt";
	String keyPath;
	ArrayList<Character> cipherText;
	ArrayList<Character> key;

	public static void Main(String[] args) {
		cipherText = hexFileToChars(cipherPath);
		key = hexFileToChars(keyPath);

	}// function main

	public static void hexFileToChars(String path) {
		char character;
		ArrayList<Character> output = new ArrayList<Character>();
		try {
			File text1 = new File(path);
			BufferedReader reader = new BufferedReader(new FileReader(text1));
			while ((character = r.read()) != null) {
				output.add(character);	
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return output;
	}//function hexFileToChars

	public static void xorWithArray(char[] text, char[] key) {

	}//function xorWithArray

	public static void writeToFile(char[] output) {

	}//function writeToFile
}//class DecoderRing
