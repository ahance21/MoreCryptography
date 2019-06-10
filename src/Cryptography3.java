import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Cryptography3 {

	public static void main(String[] args) throws IOException
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Would you like to encrypt, decrypt, or crack a file?" );
		String encrypted = keyboard.nextLine();
		int shift = 0;
		String filename = "";
		String encrypt = "false";
		if(encrypted.equalsIgnoreCase("encrypt"))
		{
			encrypt = "true";
			Scanner scan = new Scanner(System.in);
			System.out.print("How many places should it be shifted? ");
			shift = scan.nextInt();
			System.out.print("Enter a file name for encrypting: ");
			filename = scan.nextLine();
		}
		else if(encrypted.equalsIgnoreCase("crack"))
		{
			encrypt = "crack";
			Scanner scan = new Scanner(System.in);
			System.out.print("Enter a file to crack ");
			filename = scan.nextLine();
		}
		else
		{
			Scanner scan = new Scanner(System.in);
			System.out.print("How many places should it be shifted?");
			shift = scan.nextInt();
			System.out.print("Enter a file name to decrypt: ");
			filename = scan.nextLine();
		}
			caesar_cipher(filename,encrypt,shift);
	}

	 {
		// TODO Auto-generated method stub
		
	}
public static String encrypt(String txt, int i)
{
	String endcode = "";
	
	for (int j=0; j<txt.length(); j++)
	{
		if(Character.isUpperCase(txt.charAt(j)) && !Character.isWhitespace(txt.charAt(j)))
		{
			char ch = (char) (((int)txt.charAt(j) + i - 65) % 26 + 65);
			endcode = endcode + ch;
		}
		else if (!Character.isWhitespace(txt.charAt(j)))
		{
			char ch = (char)(((int)txt.charAt(j) + i - 97) % 26 + 97);
			endcode = endcode + ch;
		}
		else {
			endcode = endcode + "";
		}
	}
	return endcode;
}



public static String caesar_cipher(String fileName, String encrypt, int ShiftAmount) throws IOException
{
	   Scanner inputfile = new Scanner(new File (fileName + ".txt"));
	   String line = "";
	   while(inputfile.hasNext())
	   {
		   line = inputfile.nextLine();
	   }
	   
	   if (encrypt.equalsIgnoreCase("true"))
	   {
		   PrintWriter outputFile = new PrintWriter(fileName + "_ENC.txt");
		   outputFile.close();
		   System.out.print("Result written to " + fileName + "_ENC.txt");
				   
	   }
	   else if(encrypt.equalsIgnoreCase("false"))
	   {
		   
		   ShiftAmount = 26 - ShiftAmount;
		   PrintWriter outputFile = new PrintWriter(fileName + "_DEC.txt");
		   outputFile.println(encrypt(line, ShiftAmount));
		   outputFile.close();
		   System.out.print("Result Written to " + fileName + "_DEC.txt");
	   }
	   else if(encrypt.equalsIgnoreCase("crack"))
	   {
		   for (int k = 1; k < 25; k++)
		   {
			   ShiftAmount = 26 - k;
			   System.out.print(encrypt(line,ShiftAmount));
			   Scanner scan = new Scanner(System.in);
			   System.out.println("Does the code look right?");
			   String answer = scan.nextLine();
			   if(answer.equalsIgnoreCase("yes"))
			   {
				   break;
			   }
			   
		   }
		   PrintWriter outputFile = new PrintWriter(fileName + "_DEC" + ".txt");
		   System.out.print("The result is written to " + fileName + "_DEC" + ".txt");
	   }
	   inputfile.close();
	   return "";
	   
	 
	 
}
}
