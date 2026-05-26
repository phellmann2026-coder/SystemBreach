package systembreach;

import javax.sound.sampled.*;
import java.io.File;

public class SoundPlayer {

    public static void playSound(String fileName) {
        try {
            File file = new File(fileName);

            AudioInputStream audio =
                    AudioSystem.getAudioInputStream(file);

            Clip clip = AudioSystem.getClip();
            clip.open(audio);
            clip.start();

        } catch (Exception e) {
            System.out.println("Sound error.");
        }
    }
}
