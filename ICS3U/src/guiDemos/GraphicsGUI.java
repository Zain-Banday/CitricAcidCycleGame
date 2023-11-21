package guiDemos;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

class MyDrawPanel3ex extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	
	public void paintComponent (Graphics g) {
		
		Image image = new ImageIcon("C:\\Users\\bandzai929\\OneDrive - Bluewater District School Board\\Workspace\\andrew.jpg").getImage();
		g.drawImage(image,3,4,this);
		
		Image pepe = new ImageIcon("C:\\Users\\bandzai929\\OneDrive - Bluewater District School Board\\Workspace\\Zain Workspace\\Intro\\pepe.jpg").getImage();
		g.drawImage(pepe, 100,100,this);
		
		
		File audioFile = new File("C:\\Users\\bandzai929\\OneDrive - Bluewater District School Board\\Workspace\\Zain Workspace\\Intro\\breathe-air.wav");
		 

		try {
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
		AudioFormat format = audioStream.getFormat();
		 
		DataLine.Info info = new DataLine.Info(Clip.class, format);
		Clip audioClip = (Clip) AudioSystem.getLine(info);
		audioClip.open(audioStream);
		audioClip.start();
		
		 boolean playCompleted = false;
		while (!playCompleted) {
             // wait for the playback completes
             try {
                 Thread.sleep(1000);
             } catch (InterruptedException ex) {
                 ex.printStackTrace();
             }
         }
		audioClip.close();
		audioStream.close();
		
		
		
		} catch (UnsupportedAudioFileException ex) {
            System.out.println("The specified audio file is not supported.");
            ex.printStackTrace();
        } catch (LineUnavailableException ex) {
            System.out.println("Audio line for playing back is unavailable.");
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println("Error playing the audio file.");
            ex.printStackTrace();
        }
         
    }
     
	
		
		
		
	}



public class GraphicsGUI extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GraphicsGUI gui = new GraphicsGUI();
		gui.go();

	
	
	}
	
	public void go() {
		JFrame frame = new JFrame("Draw Andrew Tate");
		frame.add(new MyDrawPanel3ex());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setSize(500,500);
		frame.setVisible(true);
	}

}
