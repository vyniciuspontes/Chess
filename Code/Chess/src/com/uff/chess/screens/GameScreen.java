/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uff.chess.screens;

import com.uff.chess.gameobjects.Background;
import com.uff.chess.gameobjects.Spot;
import com.uff.chess.utils.ResourceManager;
import com.vpontes.gameframework.core.Game;
import com.vpontes.gameframework.core.Screen;
import com.vpontes.gameframework.math.OverlapTester;
import com.vpontes.gameframework.math.Vector2;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vynicius Pontes
 */
public class GameScreen extends Screen implements MouseListener{

    private final Background background;
    private List<Spot> spots;
    private final String[] blocksImages = {
        ResourceManager.WHITE_SPOT,
        ResourceManager.BLACK_SPOT
    };
    
    public GameScreen(Game game) {
        super(game);
        background = new Background(new Vector2(0,0), 800, 600, ResourceManager.BACKGROUND);
        game.addMouseListener(this);
        setupSpots();
    }
    
    /**
     * Organiza os blocos em suas posicoes iniciais
     */
    private void setupSpots(){
        Integer aux = 0;
        Vector2 startPosition = new Vector2(game.getScreenWidth()/2 - (60*8)/2,game.getScreenHeight()/2 - (60*8)/2);
        String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H"};
        spots = new ArrayList<>();
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                Spot newSpot = new Spot(new Vector2((x * 60) + startPosition.getX(), (y * 60) + startPosition.getY()), 60, 60, 
                        blocksImages[(x + aux)%2], letters[y] + ""+(x + 1));
                spots.add(newSpot);
            }
            if(aux == 1)
                aux = 0;
            else
                aux = 1;
        }
    }

    @Override
    public void update(double deltaTime) {
    }

    @Override
    public void draw(Graphics graphics) {
        background.draw(graphics);
        spots.forEach((spot) -> {
            spot.draw(graphics);
        });
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(e.getButton() != 1)
            return;
        Vector2 clickPosition = new Vector2(e.getPoint().getX(), e.getPoint().getY());
        spots.forEach((spot) -> {
            if(OverlapTester.pointInRectangle(spot.getRect(),clickPosition))
                spot.mouseClicked();
        });
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
