/**
 * @Author Robin Yonge
 * Deciphering Hex Dumps!
 */
import java.io.*;

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

	String path = "DistSysSec.txt"

	public static void Main(String[] args) {

	}// function main

	public static char[] hexFileToChars(String path) {
		
	}//function hexFileToChars

	public static char[] xorWithArray(char[] text, char[] key) {

	}//function xorWithArray

	public static void writeToFile(char[] output) {

	}//function writeToFile
}//class DecoderRing
