import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class AudioManagement {
        public static Clip clip;

        public static void AudioManagement(String soundFileName){
            try{
                File file = new File(soundFileName);
                AudioInputStream sound = AudioSystem.getAudioInputStream(file);
                clip = AudioSystem.getClip();
                clip.open(sound);
            }catch (Exception e){

            }
            clip.setFramePosition(0);
            clip.start();
        }
}
