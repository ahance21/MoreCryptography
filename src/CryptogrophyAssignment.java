/*
 * Austin Hance
 */
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CryptogrophyAssignment {
	

	public static void main(String[] args) throws IOException{
	{
		
		
	   Scanner scan = new Scanner(System.in);
	   
	   
	 
	   
	   char[]alpha = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p','q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
	   char[]alphaup = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
	   String result = "";
	   System.out.print("Enter a file name please");
	   String filename = scan.nextLine();
	   String newName = "";
	   Scanner file = new Scanner(new File(filename));
	   for (int k=0; k < filename.length(); k++)
	   {
		   if(!isLower(filename.charAt(k)) && !isUpper(filename.charAt(k)))
			   newName = filename.substring(0,  k);
	   }
	   PrintWriter outputfile = new PrintWriter(filename + "_ENC.txt");
	   while(file.hasNext())
	   {
		   String line = file.nextLine();
		   String encrypt = line;
	   for(int i = 0; i < encrypt.length(); i++)
		  {
		if(!isLower(encrypt.charAt(i)) && !isUpper(encrypt.charAt(i))   )
		{
			outputfile.append(encrypt.charAt(i));
			continue;
		}
		   
		for(int j = 0; j < 26; j++)
		{
			if(encrypt.charAt(i) == alpha[j])
			{
				int b = (alpha[j] - 100) % 26;
				if (b < 0)
					outputfile.append(alpha[alpha.length + b]);
				else
					outputfile.append(alpha[b]);
				
			}
			else if(encrypt.charAt(i) == alphaup[j])
			{
				int b = (alphaup[j] - 68) % 26;
				if (b < 0)
					outputfile.append(alphaup[alphaup.length + b]);
				else
					outputfile.append(alphaup[b]);
			}
		}
		}
		   System.out.print("Result written to " + newName + "_ENC.txt");
		   outputfile.close();
	   
		   
	}
	}
	
	}
	
	
	    
	
	





	
	





	
	
	    
	
	private static boolean isLower(char c)
	{
		return(c >= 'a' && c <= 'z');
	}





















	private static boolean isUpper(char c)
	{
		return (c >= 'A' && c  <= 'Z');
	}





















	{
		
	}
	

	  
		  
	
		  
	   
	   
	   {
		   
	   }
		{
	  
	  {
	   
	  
			 
		     
	   
	  }
	   
	   
	  }
	   
	   
	   
	}


