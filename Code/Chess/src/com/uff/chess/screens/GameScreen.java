/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uff.chess.screens;

import com.uff.chess.gameobjects.Board;
import com.uff.chess.gameobjects.GameManager;
import com.uff.chess.gameobjects.players.HumamPlayer;
import com.uff.chess.gameobjects.players.IA;
import com.uff.chess.gameobjects.players.Player;
import com.uff.chess.gameobjects.pieces.Piece;
import com.uff.chess.gameobjects.pieces.Piece.PieceColor;
import com.uff.chess.utils.ResourceManager;
import com.vpontes.gameframework.core.Game;
import com.vpontes.gameframework.core.Screen;
import com.vpontes.gameframework.math.Vector2;
import java.awt.Graphics;

/**
 *
 * @author Vynicius Pontes
 */
public class GameScreen extends Screen {

    private final Board board;
    private final GameManager pm; 

    public GameScreen(Game game) {
        super(game);
        this.board = new Board(new Vector2(0, 0), 800, 600, ResourceManager.BACKGROUND);
        this.pm = new GameManager(board, Piece.PieceColor.WHITE, Piece.PieceColor.BLACK, true);
        game.addMouseListener(pm);
    }

    @Override
    public void update(double deltaTime) {
        pm.update(deltaTime);
    }

    @Override
    public void draw(Graphics graphics) {
        board.draw(graphics);

    }
}
