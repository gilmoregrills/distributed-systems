/**
 * @Author Robin Yonge
 * Deciphering Hex Dumps!
 */
import java.io.*;
import java.util.*;

/**
 * So I think the idea with this is to convert any hex
 * into an array of chars so it's easy to work with and
 * is human readable, XOR it against another array
 * of chars, then output as hex to a file and as a string
 * to the console so that I can see the results easily 
 * and quickly feed the results back into the script. 
 */
public class DecoderRing {

	public static void main(String[] args) {
		String cipherPath = "/home/gilmoregrills/distributed-systems/security_cwk/"+args[0];
		String keyPath = "/home/gilmoregrills/distributed-systems/security_cwk/"+args[1];
		String outputPath = "/home/gilmoregrills/distributed-systems/security_cwk/output.txt";
		char[] cipherText = hexFileToChars(cipherPath);
		char[] key = hexFileToChars(keyPath);
		char[] result = xor(cipherText, key);
		writeToFile(result, outputPath);

	}// function main

	public static char[] hexFileToChars(String path) {
		String hex = "";
		char[] out;
		int count = 0;
		try {
			File text1 = new File(path);
			BufferedReader reader = new BufferedReader(new FileReader(text1));
			hex = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		out = new char[(hex.length()+1)/3t s];
		for (int i = 0; i < hex.length(); i += 3) {
			String x = hex.substring(i, i+2);
			out[count] = (char)Integer.parseInt(x, 16);
			count++;
		}
		System.out.println(Arrays.toString(out));
		return out;
	}//function hexFileToChars

	public static char[] xor(char[] text, char[] key) {
		int len = (text.length < key.length) ? text.length : key.length;
		char[] out = new char[len];
		for (int i = 0; i < len; i++) {
			out[i] = (char) ((text[i]) ^ (key[i]));
		}
		return out;
	}//function xor

	public static void writeToFile(char[] out, String path) {
		StringBuilder results = new StringBuilder();//print one to the console
		StringBuilder toFile = new StringBuilder();//one to a file as hex
		for (char c : out) {
			results.append(c);
			toFile.append(Integer.toHexString((int) c));
			toFile.append(" ");
		}
		String res = results.toString();
		String hexOut = toFile.toString();
		System.out.println("results: "+res);
		BufferedWriter buff = null;
		try {
			System.out.println("writing to: "+path);
			File outputFile = new File(path);
			Writer writer = new FileWriter(outputFile);
			buff = new BufferedWriter(writer);
			buff.write(hexOut);
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
