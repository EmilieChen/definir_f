import java.io.BufferedInputStream;
import java.io.FileInputStream;

import javazoom.jl.player.Player;


public class MP3 {
    private String aFilename;
    private Player aPlayer; 

    // constructor that takes the name of an MP3 file
   public MP3(final String pFilename) {
        this.aFilename = pFilename;
    }

   public void close() { if (aPlayer != null) aPlayer.close(); }

    // play the MP3 file to the sound card
   public void play() {
        try {
            FileInputStream vFis     = new FileInputStream(aFilename);
            BufferedInputStream bis = new BufferedInputStream(vFis);
            this.aPlayer = new Player(bis);
        }
        catch (Exception e) {
            System.out.println("Problème pour jouer le fichier " + this.aFilename);
            System.out.println(e);
        }

        // run in new thread to play in background
        new Thread() {
            public void run() {
                try { aPlayer.play(); }
                catch (Exception e) { System.out.println(e); }
            }
            
        }.start();
        
    }
    
       
}