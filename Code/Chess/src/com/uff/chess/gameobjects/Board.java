package com.uff.chess.gameobjects;

import com.uff.chess.utils.ResourceManager;
import com.vpontes.gameframework.math.OverlapTester;
import com.vpontes.gameframework.math.Vector2;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Vynicius Pontes
 */
public class Board extends GameObject implements MouseListener {

    private final Spot[][] spots= new Spot[8][8];
    private final String[] blocksImages = {
        ResourceManager.WHITE_SPOT,
        ResourceManager.BLACK_SPOT
    };

    public Spot[][] getSpots() {
        return spots;
    }
    
    public Board(Vector2 position, int widght, int height, String imagePath) {
        super(position, widght, height, imagePath);
        setupSpots();
    }
    
     /**
     * Organiza os blocos em suas posicoes iniciais
     */
    private void setupSpots(){
        Integer aux = 0;
        Vector2 startPosition = new Vector2(this.getWidght()/2 - (60*8)/2,this.getHeight()/2 - (60*8)/2);
        String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H"};
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                Spot newSpot = new Spot(new Vector2((x * 60) + startPosition.getX(), (y * 60) + startPosition.getY()), 60, 60, 
                        blocksImages[(x + aux)%2], letters[y] + ""+(x + 1));
                spots[y][x] = newSpot;
            }
            if(aux == 1)
                aux = 0;
            else
                aux = 1;
        }
    }


    @Override
    public void draw(Graphics g){
        super.draw(g);
        for (Spot[] spotY : spots) {
            for (Spot spotX : spotY) {
                spotX.draw(g);
            }
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getButton() != 1)
            return;
        
        Vector2 clickPosition = new Vector2(e.getPoint().getX(), e.getPoint().getY());
        for (Spot[] spotY : spots) {
            for (Spot spotX : spotY) {
                if(OverlapTester.pointInRectangle(spotX.getRect(),clickPosition))
                    spotX.mouseClicked();
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
