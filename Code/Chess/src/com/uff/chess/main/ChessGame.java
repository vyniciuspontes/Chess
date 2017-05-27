/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uff.chess.main;

import com.uff.chess.screens.GameScreen;
import com.uff.chess.screens.Menu;
import com.uff.chess.utils.ResourceManager;
import com.vpontes.gameframework.core.Game;
import com.vpontes.gameframework.core.Screen;

/**
 *
 * @author Vynicius Pontes
 */
public class ChessGame extends Game {

    public static void main(String[] args) {
        new ChessGame(800, 600, "Chess").run();
    }

    public ChessGame(int screenWidth, int screenHeight, String windowTitle) {
        super(screenWidth, screenHeight, windowTitle);
    }

    @Override
    protected Screen getFirstScreen() {
        ResourceManager.loadImages();
        return new GameScreen(this);
        //return new Menu(this);
    }
}
