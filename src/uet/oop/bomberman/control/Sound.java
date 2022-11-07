package uet.oop.bomberman.control;

import javafx.scene.media.AudioClip;

public class Sound {

    /*
	|--------------------------------------------------------------------------
	| System Sounds
	|--------------------------------------------------------------------------
	 */

    public static void backgroundNoise() {
        AudioClip buzzer = new AudioClip(Sound.class.getResource("/sounds/BG Noise.mp3").toExternalForm());
        buzzer.setCycleCount(AudioClip.INDEFINITE);
        buzzer.play();
    }

    public static void backgroundNoise2() {
        AudioClip buzzer = new AudioClip(Sound.class.getResource("/sounds/BG Noise 2.mp3").toExternalForm());
        buzzer.setCycleCount(AudioClip.INDEFINITE);
        buzzer.setVolume(0.6);
        buzzer.play();
    }

    public static void backgroundMusic() {
        AudioClip buzzer = new AudioClip(Sound.class.getResource("/sounds/BG Music.mp3").toExternalForm());
        buzzer.setCycleCount(AudioClip.INDEFINITE);
        buzzer.setVolume(0.4);
        buzzer.play();
    }

    public static void startJingle() {
        AudioClip jingle = new AudioClip(Sound.class.getResource("/sounds/Effects/Start Jingle.wav").toExternalForm());
        jingle.setVolume(0.6);
        jingle.play();
    }

    public static void gameStart() {
        AudioClip gameStart = new AudioClip(Sound.class.getResource("/sounds/Effects/Game Start.wav").toExternalForm());
        gameStart.play();
        gameStart.setVolume(0.5);
    }

    public static void sixtySecs() {
        AudioClip countdown = new AudioClip(Sound.class.getResource("/sounds/Effects/60 Secs.wav").toExternalForm());
        countdown.play();
    }

    public static void thirtySecs() {
        AudioClip countdown = new AudioClip(Sound.class.getResource("/sounds/Effects/30 Secs.wav").toExternalForm());
        countdown.play();
    }

    public static void tenSecs() {
        AudioClip countdown = new AudioClip(Sound.class.getResource("/sounds/Effects/10 Secs.wav").toExternalForm());
        countdown.play();
    }

    public static void Five() {
        AudioClip countdown = new AudioClip(Sound.class.getResource("/sounds/Effects/Five.wav").toExternalForm());
        countdown.play();
    }
    public static void Four() {
        AudioClip countdown = new AudioClip(Sound.class.getResource("/sounds/Effects/Four.wav").toExternalForm());
        countdown.play();
    }
    public static void Three() {
        AudioClip countdown = new AudioClip(Sound.class.getResource("/sounds/Effects/Three.wav").toExternalForm());
        countdown.play();
    }
    public static void Two() {
        AudioClip countdown = new AudioClip(Sound.class.getResource("/sounds/Effects/Two.wav").toExternalForm());
        countdown.play();
    }
    public static void One() {
        AudioClip countdown = new AudioClip(Sound.class.getResource("/sounds/Effects/One.wav").toExternalForm());
        countdown.play();
    }

    /*
	|--------------------------------------------------------------------------
	| Player Sounds
	|--------------------------------------------------------------------------
	 */

    public static void walking() {
        int random = (int) (Math.random() * 2 + 1);
        String path;
        if(random == 1)
            path = "/sounds/Effects/Walking 1.wav";
        else
            path = "/sounds/Effects/Walking 2.wav";

        AudioClip walking = new AudioClip(Sound.class.getResource(path).toExternalForm());

        walking.setVolume(0.3);
        walking.play();
    }

    public static void takingDamage() {
        AudioClip dmg = new AudioClip(Sound.class.getResource("/sounds/Effects/Taking Damage.wav").toExternalForm());
        dmg.play();
    }

    public static void powerUp() {
        AudioClip power = new AudioClip(Sound.class.getResource("/sounds/Effects/Powerup.wav").toExternalForm());
        power.setVolume(0.5);
        power.play();
    }

    public static void bombExploding() {
        AudioClip explosion = new AudioClip(Sound.class.getResource("/sounds/Effects/Bomb Explodes.wav").toExternalForm());
        explosion.play();
    }

    public static void bombBouncing() {
        AudioClip bounce = new AudioClip(Sound.class.getResource("/sounds/Effects/Bomb Bouncing on Blocks.wav").toExternalForm());
        bounce.setVolume(0.5);
        bounce.play();
    }

    public static void bombPlaced() {
        AudioClip explosion = new AudioClip(Sound.class.getResource("/sounds/Effects/Place Bomb.wav").toExternalForm());
        explosion.setVolume(0.5);
        explosion.play();
    }

    public static void trapPlaced() {
        AudioClip explosion = new AudioClip(Sound.class.getResource("/sounds/Effects/Trap Activating.wav").toExternalForm());
        //explosion.setVolume(0.5);
        explosion.play();
    }


    /*
	|--------------------------------------------------------------------------
	| Entity Sounds
	|--------------------------------------------------------------------------
	 */

    public static void enemyDying() {
        AudioClip dying = new AudioClip(Sound.class.getResource("/sounds/Effects/Enemy Dies.wav").toExternalForm());
        dying.setVolume(0.5);
        dying.play();
    }

    public static void vaseBreaking() {
        AudioClip vase = new AudioClip(Sound.class.getResource("/sounds/Effects/Vase Breaking.wav").toExternalForm());
        vase.play();
        //vase.setVolume(0.1);
    }


}

