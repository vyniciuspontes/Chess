/*
*
* Chess Game
* Software Engineering II - Universidade Federal Fluminense
*
 */
package com.uff.chess.gameobjects;

import com.uff.chess.main.ChessGame;
import com.vpontes.gameframework.core.Game;
import com.vpontes.gameframework.math.Vector2;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

/**
 *
 * @author gabri
 */
public class MenuSelector extends GameObject implements KeyListener
{

    private int position = 0;
    private Game game;
    
    public MenuSelector(Vector2 position, int widght, int height, BufferedImage image) {
        super(position, widght, height, image);
        this.game = game;
    }
    
     public void NextPosition()
    {
        position ++;
        
        if(position == 3)
        {
            position = 0;
        }
        
        UpdatePosition();
    }
    
    public void PreviousPosition()
    {
        position --;
        
        if(position == -1)
        {
            position = 2;
        }
        
        UpdatePosition();
    }
    
    private void UpdatePosition()
    {
        switch(position)
        {
            case 0:
                this.setPosition(new Vector2(200, 167));
                break;
                
            case 1:
                this.setPosition(new Vector2(200, 320));
                break;
                
            case 2:
                this.setPosition(new Vector2(200, 475));
                break;
        }
    }
    
    private void MenuSelection()
    {
        switch(position)
        {
            case 0:
                
                break;
                
            case 1:
                this.setPosition(new Vector2(200, 320));
                break;
                
            case 2:
                System.exit(0);
                break;
        }
    }
    
    @Override
    public void draw(Graphics g) {
        super.draw(g);
    }

    @Override
    public void keyTyped(KeyEvent ke) 
    {
        
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if(ke.getKeyCode() == KeyEvent.VK_UP)
        {
            PreviousPosition();
        }
        else if(ke.getKeyCode() == KeyEvent.VK_DOWN)
        {
            NextPosition();
        }
        else if(ke.getKeyCode() == KeyEvent.VK_ENTER)
        {
            MenuSelection();
        }
        else if(ke.getKeyCode() == KeyEvent.VK_ESCAPE)
        {
            System.exit(0);
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
