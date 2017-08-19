package fileUtility;

import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/*
 * OpenSoundFile opens the audio file from the given path
 * 
 * Example Usage:
 * 		String path = "/Resources/Audio/Sound.wav";
 * 		OpenSoundFile sound = new OpenSoundFile(path);
 * 		sound.playSound();
 */
public class OpenSoundFile {
	File soundFile;
		
	public OpenSoundFile(String path) {
		try {
			File absFile = new File("");
			String absPath = absFile.getAbsolutePath();
		
			System.out.println(absPath + path);
			soundFile = new File(absPath + path);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
		
	public void playSound(){
		try{
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(soundFile));
			clip.start();
		} catch(Exception e) {
			System.out.println(e);
		}
	}
}
