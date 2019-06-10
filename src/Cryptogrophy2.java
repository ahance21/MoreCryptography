import java.io.File;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.FileNotFoundException;
public class Cryptogrophy2
{

	public static void main(String[] args) throws IOException
	{
	
		Scanner keyboard = new Scanner(System.in);
		
		char[]alpha = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p','q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
		   char[]alphaup = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
		System.out.print("Would you like to encrypt or decrypt?");
		String encrypted = keyboard.nextLine();
		System.out.print("How much should the alphabet be shifted? ");
		int shift = keyboard.nextInt();
		String fileName = "";
		boolean encrypt = false;
		
		if(encrypted.equalsIgnoreCase("encrypt"))
		{
			encrypt =  true;
			Scanner scan = new Scanner(System.in);
			System.out.print("Enter a file name to encrypt:");
			fileName = scan.nextLine();
		}
		else
		{
			Scanner scan = new Scanner(System.in);
			System.out.print("Enter a file name to decrypt ");
			fileName = scan.nextLine();
		}
		
		caesar_cipher(fileName,encrypt,shift);
	}
		
        
		public static String encrypt(String txt, int i)
		{
			String endcode = "";
			
			for (int j=0; j < txt.length(); j++)
			{
				if (Character.isUpperCase(txt.charAt(j)) && !Character.isWhitespace(txt.charAt(j)))
				{
					char ch = (char)(((int)txt.charAt(j) + i-65) % 26 + 65);
					endcode = endcode + ch;
				}
				else if (!Character.isWhitespace(txt.charAt(j)))
				{
					char ch = (char)(((int)txt.charAt(j) + i-97) % 26 + 97);
					endcode = endcode + "";
				}
			}
			return endcode;
		}
		

	
	
	
	
	public static String caesar_cipher(String filename, boolean encrypt, int shiftAmount) throws IOException
	{
		   Scanner file = new Scanner(new File (filename + ".txt"));
		   String line = "";
		   while(file.hasNext())
		   {
			   line = file.nextLine();
		   }

		if (encrypt)	
		{
			PrintWriter outputFile = new PrintWriter(filename + "_END.txt");
			outputFile.println( encrypt(line, shiftAmount));
			outputFile.close();
			System.out.print("Result written to " + filename + "_ENC.txt");
			
		}
		else
		{
			shiftAmount = 26 - shiftAmount;
			PrintWriter outputFile = new PrintWriter(filename + "_DEC.txt");
		    outputFile.println(encrypt(line, shiftAmount));
			outputFile.close();
			System.out.print("Result written to " + filename + "_DEC.txt");
		}
		file.close();
		return "";
		
	}
	private static boolean isUpper(char charAt) {
		// TODO Auto-generated method stub
		return false;
	}
	private static boolean isLower(char charAt) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
