package uet.oop.bomberman.control;

import javafx.scene.media.AudioClip;

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

    public static void enemyDying() {
        AudioClip dying = new AudioClip(Sound.class.getResource("/sounds/Effects/Enemy Dies.wav").toExternalForm());
        dying.play();
    }

    public static void startJingle() {
        AudioClip jingle = new AudioClip(Sound.class.getResource("/sounds/Effects/Match Start Jingle.wav").toExternalForm());
        jingle.setVolume(0.5);
        jingle.play();
    }
}

