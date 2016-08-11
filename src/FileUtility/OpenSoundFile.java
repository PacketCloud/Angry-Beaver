package FileUtility;

import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class OpenSoundFile {
	
	/*
	 * main function for testing
	public static void main(String[] args) throws IOException {
		
		//these two lines are for opening from other main java file
		//OpenSoundFile OSF = new OpenSoundFile();
		//OSF.PlaySoundFile(fileIn);
		//-----------------------------------------------
		
		
		
		
		//WAV File Only
		File fileIn = new File("C:/Users/Chris/Desktop/wav/Anti_Gravity.wav");
		String path = fileIn.getAbsolutePath();
		OpenSoundFile(fileIn);	
	}
	*/	
		
	//pass in sound file and play it	
	public void PlaySoundFile(File sound){
		
		try{
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(sound));
			clip.start();
			
			
			Thread.sleep(clip.getMicrosecondLength()/1000);
			}catch(Exception e){
}
	
}
}
