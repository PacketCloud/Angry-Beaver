package fileUtility;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * 	Class OpenFile is used to open and read text files 
 * 		
 * 	Usage: 
 * 			OpenFile opened = new OpenFile( [File Path] );
 * 			while(opened.hasNextLine()) {
 * 				[Switch statement with opened.getNextLine();]
 * 			}
 * 			opened.close();
 */

public class OpenFile {
	private Scanner fileScan;
	
	public OpenFile(String path){
		File absFile = new File("");
		String absPath = absFile.getAbsolutePath();
		
		try{
			System.out.println(absPath + path);
			File file = new File(absPath + path);
			setFileScan(new Scanner (file));
		}
		catch(IOException e){
			System.out.println(e.getMessage());
			System.out.println("file does not exist");
		}
	}
	
	/** 
	 * Method hasNextLine checks if the file has a next line and returns
	 * True if there is a next line.
	 * 
	 * @return		True if there exists a next line
	 * 				False otherwise
	 */
	public Boolean hasNextLine() {
		if (getFileScan().hasNextLine()) {
			return true;
		}
		return false;
	}
	
	/**
	 * Method getNextLine returns the next line in the file
	 * 
	 * @return		String of the next line in the file
	 */
	public String getNextLine(){
	    	String line = getFileScan().nextLine();
		    System.out.println (line);
		    return line;
	}
	
	public void close(){
		getFileScan().close();
	}
	
	private Scanner getFileScan() {
		return fileScan;
	}

	private void setFileScan(Scanner fileScan) {
		this.fileScan = fileScan;
	}

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

	/*
	// * main function for testing    
	public static void main(String[] args) throws IOException {
		Open("CHANGELOG.txt");	//enter filename here
		
		//for using from other class file that has main function
		//OpenFile OF = new OpenFile();
		//OF.Open("FileName");
	}
	*/
}
