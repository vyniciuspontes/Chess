package com.uff.chess.gameobjects;


import com.uff.chess.gameobjects.GameObject;
import com.vpontes.gameframework.math.Vector2;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/*
*
* Chess Game
* Software Engineering II - Universidade Federal Fluminense
*
 */

/**
 *
 * @author gabri
 */
public class Difficulties extends GameObject
{
    
    public Difficulties(Vector2 position, int widght, int height,  BufferedImage image) {
        super(position, widght, height, image);
        
    }
    
   
    
    @Override
    public void draw(Graphics g) 
    {
        super.draw(g);
    }
}
