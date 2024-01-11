package com.example.stckhero;
import javafx.scene.media.AudioClip;
public class sound {

    private boolean Play_background_sound;
    private boolean hit_sound;
    private boolean stick_drop_sound;
    private boolean walk_Sound;
    private boolean cherryCollected_sound;
    private boolean playerfall_sound;

    private boolean player_hit_sound;
    private AudioClip backgroundsoundEffect;
    private AudioClip hitSoundEffect;
    private AudioClip StickDropSoundEffect;
    private AudioClip walkSoundEffect;

    private AudioClip cherrySoundEffect;
    private AudioClip playerfallSoundEffect;
    private AudioClip playerHitSoundEffect;

    public void setCherryCollected_sound(boolean cherryCollected_sound) {
        this.cherryCollected_sound = cherryCollected_sound;

    }


    public void setPlay_background_sound(boolean play_background_sound) {
        Play_background_sound = play_background_sound;
    }

    public void setStick_drop_sound(boolean stick_drop_sound) {
        this.stick_drop_sound = stick_drop_sound;
    }

    public void setHitSound(boolean hitSound) {


        this.hit_sound = hitSound;

        if(hitSound){
            hitSoundEffect=new AudioClip("file:src/main/resources/com/example/stckhero/stick_fallen.wav");
            hitSoundEffect.play();
        }

    }

    public void setPlayerfall_sound(boolean playerfall_sound){
        this.playerfall_sound=playerfall_sound;
        if (playerfall_sound){
            playerfallSoundEffect=new AudioClip("file:src/main/resources/com/example/stckhero/death2.wav");
            playerfallSoundEffect.play();
        }
    }
    public boolean getWalk_Sound(){
        return  this.walk_Sound;
    }
    public void setWalk_Sound(boolean walk_Sound) {
        this.walk_Sound = walk_Sound;
        if (walk_Sound){
            walkSoundEffect=new AudioClip("file:src/main/resources/com/example/stckhero/walk_sound.mp3");
            walkSoundEffect.play();
        }
    }
    public void audio_clip_play_checker(){

    }

    public void setPlayer_hit_sound(boolean player_hit_sound){
        this.player_hit_sound=player_hit_sound;
        if (player_hit_sound){
            playerHitSoundEffect=new AudioClip("file:src/main/resources/com/example/stckhero/dead.wav");
            playerHitSoundEffect.play();
        }
    }
}
