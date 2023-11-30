package meujogo.Modelo;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;

public class Sound {
    private AudioClip clip;

    //  File f = new File("hit.wav");

    public static final Sound shoot = new Sound("//shoot.wav"); // colocar um arquivo em audio.

    public static final Sound explosion = new Sound("//explosion.wav"); // colocar som 

    public static final Sound hit = new Sound("//hit.wav");

    private Sound(String name){
        try{
            clip = Applet.newAudioClip(new File("res"+name).toURL());
        }
        catch(Throwable e ){
        }
    }
    public void play(){
        try{
            new Thread(){
                public void run(){
                    clip.play();
                }
            }.start();
        }
        catch(Throwable e){

        }
    }

    
    
}
