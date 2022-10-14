package uet.oop.bomberman.control;

import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;
import java.nio.file.Paths;
import java.util.Objects;

public class Sound {
    public static void backgroundMusic() {
        AudioClip buzzer = new AudioClip(Sound.class.getResource("/sounds/background.mp3").toExternalForm());
        buzzer.setCycleCount(AudioClip.INDEFINITE);
        buzzer.play();
    }

    public static void bombSound() {
        AudioClip explosion = new AudioClip(Sound.class.getResource("/sounds/bombSound.mp3").toExternalForm());
        explosion.play();
    }
}
