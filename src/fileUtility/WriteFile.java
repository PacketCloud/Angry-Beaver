package fileUtility;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * WriteFile uses BufferedWriter in order to write to a file
 * 
 * Usage:
 * 			WriteFile write = new WriteFile( [File Path] );
 * 			write.writeln("String1");
 * 			write.writeln("String2");
 * 			write.writeln("String3");
 * 			write.close();
 */
public class WriteFile {
	private BufferedWriter writer;
	
	public WriteFile(String path) {
		File absFile = new File("");
		String absPath = absFile.getAbsolutePath();
		
		System.out.println(absPath + path);
		
		try {
			FileWriter file = new FileWriter(absPath + path);
			writer = new BufferedWriter(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void writeln(String string) {
		try {
			writer.write(string);
			writer.write("\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
