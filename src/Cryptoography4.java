import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Cryptoography4 {

	public static void main(String[] filename) throws IOException
	{
		Scanner person = new Scanner(System.in);
		System.out.println("Would you like to encrypt, decrypt, or crack a file?");
		String answer = person.nextLine();
		System.out.println("Enter the file name:");
		Scanner File1 = new Scanner(System.in);
		String fileName = File1.nextLine();
		File file = new File("/Users/austin/eclipse-workspace/CryptographyAssignment/src" + fileName);
		Scanner fileReader = new Scanner(System.in);
		Scanner scan = new Scanner(System.in);
		if(answer.equals("encrypt")) {
			System.out.println("What method do you want to use?");
			String answer1 = scan.nextLine();
			if(answer1.equals("p"))
			{
				char[][] lEncrypt = lowerRandom();
				char[][] uEncrypt = UpperRandom();
				
				while(fileReader.hasNextLine()) {
					String line = fileReader.nextLine();
					System.out.println(line);
					for (int j=0; j < line.length(); j++)
					{
						int k = (int) line.charAt(j);
						int encrypted;
						if(k >= 65 && k<= 90)
						{
							
						 encrypted = uEncrypt[k - 65];
						}
						else
						{
							encrypted = lEncrypt[k - 97];
							
						}
						System.out.println((char)encrypted);
					}
				}
				else if(answer1.equals("c"))
				{
					System.out.println("How much shoudl the alphabet be shifted?");
					int ashift = person.nextInt();
					
					while(fileReader.hasNextline()) {
						String line = fileReader.nextLine();
						System.out.println(line);
						for (int i=0; i < line.length(); i++) {
							int a = (int) line.charAt(i);
							int encrypted = a- ashift;
									if(encrypted < 65 && (a <=65 && a<= 90)) {
										a += 26;
									}else if(encrypted < 97 && (a >= 90 && a <=12)) {
										a+=26;
									}
									
							  char encrypt1 = (char) ((char) a - encrypted);
							  System.out.print(encrypt1);
						}
					}
				}
				else if(answer.equals("decrypt")) {
				System.out.println("Which method would you like to use? c for caesar or p for permuted");
				String answer2 = scan.nextLine();
				if(answer2.equals("p"))
				{
					System.out.print("Enter an alphabet (permuted); to use for the decryption");
					String decrypted = scan.nextLine();
					char arralpha[] = new char[26];
					for(int j=0; j < 26; j++)
					{
						arralpha[j] = decrypted.charAt(j);
					}
					while(fileReader.hasNextLine()) {
					String line = fileReader.nextLine();
					System.out.println(line);
					char[]arrline = new char[line.length()];
					for (int i=0; i < line.length(); i++)
					{
						int b = (int) line.charAt(i);
						int decrypted2 = b + encrypted;
						if (decrypted2 > 90 && (i >= 65 && i <=90)) {
							i -=26;
						}
						else if(decrypted2 > 122 && (i >= 97 && i <=122)) {
							i -=26;
						}
						char encrypt1 = (char) ((char) + i + encrypted);
						System.out.println(encrypt1);
						
					}
					}
				}
				else if(answer.equals("crack")) {
				for(int i = 1; i <= 25; i++) {
					Scanner filereadCrack = new Scanner(file);
					while (filereadCrack.hasNextline()) {
					String line = filereadCrack.nextLine();
					System.out.println(line);
					for (int j = 0; j < line.length(); j++) {
						int a = (int) line.charAt(j);
						int cracked = a + j;
						if(cracked < 65 && (a >= 65 && a  <= 90)) {
							a+=26;
						} else if(cracked < 97 && (a >=97 && a <= 122)) {
							a+=26;
						}
						char encrypt1 = (char) ((char) a + j);
						System.out.println(encrypt1);
					}
					while(fileReader.hasNextLine()) {
						String Line = fileReader.nextLine();
						System.out.println(Line);
						char[] arrline = new char[Line.length()];
					for (int i=0; i < Line.length(); i++)
					{
						int linechar = line.charAt(i);
						for(int z=0; z < arralpha.length z++) {
							if(linechar == arralpha[z])
							{
								int foundAt = z;
								char decode = (char) (foundAt+97);
								System.out.print(""+decodedChar);
							}
						}
					}
					}
					}
				}
				}
				}
			}
		}
       
	}

}
