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
        buzzer.setVolume(0.2);
        buzzer.play();
    }

    public static void bombExploding() {
        AudioClip explosion = new AudioClip(Sound.class.getResource("/sounds/Effects/Bomb Explodes.wav").toExternalForm());
        explosion.play();
    }

    public static void bombBouncing() {
        AudioClip bounce = new AudioClip(Sound.class.getResource("/sounds/Effects/Bomb Bouncing on Blocks.wav").toExternalForm());
        bounce.play();
    }

    public static void bombPlaced() {
        AudioClip explosion = new AudioClip(Sound.class.getResource("/sounds/Effects/Place Bomb.wav").toExternalForm());
        explosion.play();
    }

    public static void walking() {
        AudioClip walking = new AudioClip(Sound.class.getResource("/sounds/Effects/Walking 1.wav").toExternalForm());
        walking.setVolume(0.7);
        walking.play();
    }

    public static void dying() {
        AudioClip dying = new AudioClip(Sound.class.getResource("/sounds/Effects/Die.wav").toExternalForm());
        dying.play();
    }
}
