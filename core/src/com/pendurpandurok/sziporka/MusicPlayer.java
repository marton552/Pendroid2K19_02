package com.pendurpandurok.sziporka;

import com.badlogic.gdx.audio.Music;

public class MusicPlayer {
    static Music menuMusic = Assets.manager.get(Assets.MENU_MUSIC);
    static Music[] minigame_m = {Assets.manager.get(Assets.MUSIC_1), Assets.manager.get(Assets.MUSIC_2), Assets.manager.get(Assets.MUSIC_3), Assets.manager.get(Assets.MUSIC_4), Assets.manager.get(Assets.MUSIC_5)};

    public static void playMenuMusic() {
        for (int i = 0; i < minigame_m.length; i++) {
            minigame_m[i].stop();
        }
        menuMusic.stop();

        menuMusic.play();
        menuMusic.setVolume(0.7f);
        menuMusic.setLooping(true);
    }

    public static void playMinigameMusic(int minigame) {
        for (int i = 0; i < minigame_m.length; i++) {
            minigame_m[i].stop();
        }
        menuMusic.stop();

        minigame_m[minigame].play();
        minigame_m[minigame].setLooping(true);
        minigame_m[minigame].setVolume(0.7f);

    }
}
