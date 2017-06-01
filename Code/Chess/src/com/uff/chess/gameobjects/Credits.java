/*
*
* Chess Game
* Software Engineering II - Universidade Federal Fluminense
*
 */
package com.uff.chess.gameobjects;

import com.vpontes.gameframework.math.Vector2;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author gabri
 */
public class Credits extends GameObject
{
    
    public Credits(Vector2 position, int widght, int height,  BufferedImage image) {
        super(position, widght, height, image);
        
    }
    
   
    
    @Override
    public void draw(Graphics g) 
    {
        super.draw(g);
    }
}