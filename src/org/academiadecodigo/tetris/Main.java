package org.academiadecodigo.tetris;

import org.academiadecodigo.tetris.Game.Game;
import org.academiadecodigo.tetris.Game.Sound;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws InterruptedException, UnsupportedAudioFileException, LineUnavailableException, IOException {

        String musicVar = "C:\\Users\\joaof\\OneDrive\\Ambiente de Trabalho\\Projetos\\Tetris\\Resources\\AudioTetrisAlpha.wav";
        Sound.playMusic(musicVar);


        Game game = new Game();
        game.start();
        game.gameOver();

    }
}