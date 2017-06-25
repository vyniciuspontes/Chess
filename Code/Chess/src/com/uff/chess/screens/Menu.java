/*
*
* Chess Game
* Software Engineering II - Universidade Federal Fluminense
*
 */
package com.uff.chess.screens;

import com.uff.chess.gameobjects.Background;
import com.uff.chess.gameobjects.GameMode;
import com.uff.chess.gameobjects.Credits;
import com.uff.chess.gameobjects.Difficulties;
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
    GameMode gameMode;
    Credits credits;
    Difficulties difficulties;
    MenuSelector menuSelector;
    
    Vector2 credtsPosition;
    
    public Menu(Game game) 
    {
        super(game);
        background = new Background(new Vector2(0, 0), 800, 600, ResourceManager.MENUBACKGROUND);
        gameMode = new GameMode(new Vector2(0, 0), 800, 600, ResourceManager.GAMEMODE);
        credits = new Credits(new Vector2(0, 0), 800, 2158, ResourceManager.CREDITS);
        menuSelector = new MenuSelector(new Vector2(200, 167), 70, 70, ResourceManager.MENUPAWN, game);
        difficulties = new Difficulties(new Vector2(0, 0), 800, 600, ResourceManager.DIFFICULTY);
        credtsPosition = new Vector2(0,0);
        
        game.addKeyListener(menuSelector);
    }

    @Override
    public void update(double deltaTime) 
    {
        if(menuSelector.currentScene == MenuSelector.CurrentScene.Creditos)
        {
            credtsPosition.setY(credtsPosition.getY() - 1.1f);
            credits.setPosition(credtsPosition);
            if(credtsPosition.getY() <= -1545)
            {
                credtsPosition.setY(0);
            }
        }
        else
        {
            credtsPosition.setY(0);
        }
    }

    @Override
    public void draw(Graphics grphcs) 
    {
        switch(menuSelector.currentScene)
        {
            case Menu:
                background.draw(grphcs);
                menuSelector.draw(grphcs);
                break;
                
            case ModeSelection:
                gameMode.draw(grphcs);
                menuSelector.draw(grphcs);
                break;
                
            case Creditos:
                credits.draw(grphcs);
                break;
                
            case DifficultySelection:
                difficulties.draw(grphcs);
                menuSelector.draw(grphcs);
                break;
                
        }
        //background.draw(grphcs);
        //gameMode.draw(grphcs);
        //menuSelector.draw(grphcs);
    }
    
}
