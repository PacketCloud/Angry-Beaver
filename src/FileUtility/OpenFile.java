package FileUtility;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import engine.MainRuntime;

public class OpenFile /*extends whatever main class */ {

	  
	/*  
	 * main function for testing    
	public static void main(String[] args) throws IOException {
		Open();	
		
		//for using from other class file that has main function
		OpenFile OF = new OpenFile();
		OF.Open();
	}
	*/
	
	
	public void Open()throws IOException{
		//for open actual text file
		Runtime rt= Runtime.getRuntime();
		//scanning user input
		Scanner Scanscan = new Scanner(System.in);
		//include path of your file
		//input example:  E:\Eclipse\workspace\test\src\test\test.txt
		System.out.print("Input filename:");
		String filename = Scanscan.nextLine();
		//execute text file
		Process p = rt.exec("notepad "+filename);
		
		//open up file and print line
		try{
			String path = "";
			File file = new File(filename);
			
			//get path and print path
			path =file.getAbsolutePath();
			System.out.print("Absolute Pathname "+ path);
			//newline for spreading out the path and the content in the file
			System.out.print("\n");
			System.out.print("\n");
			
			//scan stuff inside the file
			Scanner sc = new Scanner (file);
			
			//print file content
		    while (sc.hasNextLine())
		    {
		      String line = sc.nextLine();
		      System.out.println (line);
		     
		    }
		    sc.close();
			
		}
		catch(IOException e){
			System.out.println(e.getMessage());
			System.out.println("file does not exist");
		}
	}
	
	
}
