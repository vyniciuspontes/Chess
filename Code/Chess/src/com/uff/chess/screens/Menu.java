/*
*
* Chess Game
* Software Engineering II - Universidade Federal Fluminense
*
 */
package com.uff.chess.screens;

import com.uff.chess.gameobjects.Background;
import com.uff.chess.gameobjects.MenuSelector;
import com.uff.chess.utils.ResourceManager;
import com.vpontes.gameframework.core.Game;
import com.vpontes.gameframework.core.Screen;
import com.vpontes.gameframework.math.Vector2;
import java.awt.Graphics;

/**
 *
 * @author gabri
 */
public class Menu extends Screen
{

    Background background;
    MenuSelector menuSelector;
    
    public Menu(Game game) 
    {
        super(game);
        background = new Background(new Vector2(0, 0), 800, 600, ResourceManager.MENUBACKGROUND);
        menuSelector = new MenuSelector(new Vector2(200, 167), 70, 70, ResourceManager.MENUPAWN);
        game.addKeyListener(menuSelector);
        
    }

    @Override
    public void update(double deltaTime) 
    {
        //player1.update(deltaTime);
    }

    @Override
    public void draw(Graphics grphcs) {
        background.draw(grphcs);
        menuSelector.draw(grphcs);
    }
    
}
