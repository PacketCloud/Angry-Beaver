package FileUtility;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class OpenFile {
/*
 *  Currently in the process of moving OpenFile out of main()
	File file;
	public OpenFile(String filename) {
			file = new File(filename);
			scan();
	}
	
	public void scan() {
		try {
			Scanner sc = new Scanner(file);
			
			while (sc.hasNextLine()) {
		      String line = sc.nextLine();
		      System.out.println (line);
		    }
		    sc.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.out.println("file does not exist");
		}
	}
*/
	public static void main(String[] args) throws IOException {
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
			
			File file = new File(filename);
			Scanner sc = new Scanner (file);
			
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
