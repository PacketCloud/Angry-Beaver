package FileUtility;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class OpenFile /*extends whatever main class */ {

	  
	/*
	// * main function for testing    
	public static void main(String[] args) throws IOException {
		Open("CHANGELOG.txt");	//enter filename here
		
		//for using from other class file that has main function
		//OpenFile OF = new OpenFile();
		//OF.Open("FileName");
	}
	*/
	
	//add static when main function is in this class
	public void Open(String Path)throws IOException{
		
		
		try{
			String filePath = new File(Path).getAbsolutePath();
			File file = new File(filePath);
			Scanner sc = new Scanner (file);
			System.out.println(filePath);
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
