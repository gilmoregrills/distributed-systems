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

	public static void main(String[] args) {
		String cipherPath = "/home/gilmoregrills/distributed-systems/security_cwk/ciphertext1.txt";
		String keyPath = "/home/gilmoregrills/distributed-systems/security_cwk/key.txt";
		String outputPath = "/home/gilmoregrills/distributed-systems/security_cwk/output.txt";
		ArrayList<Character> cipherText = hexFileToChars(cipherPath);
		ArrayList<Character> key = hexFileToChars(keyPath);
		ArrayList<Character> result = xorWithArray(cipherText, key);
		writeToFile(result, outputPath);

	}// function main

	public static ArrayList<Character> hexFileToChars(String path) {
		String hex = "";
		char character;
		ArrayList<Character> output = new ArrayList<Character>();
		try {
			File text1 = new File(path);
			BufferedReader reader = new BufferedReader(new FileReader(text1));
			hex = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < hex.length(); i += 3) {
			String x = hex.substring(i, i+2);
			character = (char)Integer.parseInt(x, 16);
			output.add(character);
			System.out.println(x+" -> "+character);
		}
		return output;
	}//function hexFileToChars

	public static ArrayList<Character> xorWithArray(ArrayList<Character> text, ArrayList<Character> key) {
		ArrayList<Character> output = new ArrayList<Character>();
		for (int i = 0; i < text.size(); i++) {
			char xor = (char) ((text.get(i)) ^ (key.get(i)));
			System.out.println(text.get(i)+" -> "+xor);
			output.add(xor);
		}
		return output;
	}//function xorWithArray

	public static void writeToFile(ArrayList<Character> output, String path) {
		StringBuilder toFile = new StringBuilder();
		for (char c : output) {
			toFile.append(c);
		}
		String s = toFile.toString();
		BufferedWriter buff = null;
		try {
			System.out.println("writing: "+s);
			System.out.println("to: "+path);
			File outputFile = new File(path);
			Writer writer = new FileWriter(outputFile);
			buff = new BufferedWriter(writer);
			buff.write(s);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				buff.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}	
	}//function writeToFile
}//class DecoderRing
