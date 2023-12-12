package meujogo.Modelo;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Musica {
    Clip clip;
    URL soundURL[] = new URL[30];
    
    public Musica(){
        soundURL[0] = getClass().getResource("musica.wav");
    }

    public void setFile(int i){

        try{
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);

        }catch(Exception e){

        }
    }

    public void play(){
        try{
            new Thread(){
                public void run(){
                    clip.start();
                }
            }.start();
        }
        catch(Throwable e){

        }

    }

    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY); 

    }
    
    public void stop(){
        clip.stop();
    }
}
