/*
*
* Chess Game
* Software Engineering II - Universidade Federal Fluminense
*
 */
package com.uff.chess.gameobjects;

import com.uff.chess.main.ChessGame;
import com.uff.chess.screens.GameScreen;
import com.uff.chess.screens.Menu;
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
    
    private boolean inGame = false;
    
    public static enum CurrentScene 
    {
        Menu,
        ModeSelection,
        Creditos,
        DifficultySelection,
        Game;
        
    }
    
    public CurrentScene currentScene;
    
    public MenuSelector(Vector2 position, int widght, int height, BufferedImage image, Game game) {
        super(position, widght, height, image);
        this.game = game;
        inGame = false;
        currentScene = CurrentScene.Menu;
    }
    
     public void NextPosition()
    {
        position ++;
        
        if(currentScene == CurrentScene.Menu || currentScene == CurrentScene.DifficultySelection)
        {
            if(position == 3)
            {
                position = 0;
            }
        }
        else
        {
            if(position == 2)
            {
                position = 0;
            }
        }        
        
        UpdatePosition();
    }
    
    public void PreviousPosition()
    {
        position --;
        
        if(currentScene == CurrentScene.Menu || currentScene == CurrentScene.DifficultySelection)
        {
            if(position == -1)
            {
                position = 2;
            }
        }
        else
        {
            if(position == -1)
            {
                position = 1;
            }
        }
        
        UpdatePosition();
    }
    
    private void UpdatePosition()
    {
        if(currentScene == CurrentScene.Menu || currentScene == CurrentScene.DifficultySelection)
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
        else
        {
            switch(position)
            {
                case 0:
                    this.setPosition(new Vector2(200, 215));
                    break;

                case 1:
                    this.setPosition(new Vector2(200, 395));
                    break;
            }
        }
        
    }
    
    private void MenuSelection()
    {
        switch(position)
        {
            case 0:
                //Selecionou Jogar
                if(currentScene == CurrentScene.Menu)
                {
                    currentScene = CurrentScene.ModeSelection;
                    UpdatePosition();
                }
                //Selecionou Jogar 1 Jogador
                else if (currentScene == CurrentScene.ModeSelection)
                {
                    currentScene = CurrentScene.Game;
                    game.setScreen(new GameScreen(game));
                }
                //Apertou para sair dos creditos
                else if (currentScene == CurrentScene.Creditos)
                {
                    currentScene = CurrentScene.Menu;
                }
                //Selecionou fácil para jogar
                else if (currentScene == CurrentScene.DifficultySelection)
                {
                    //Inicia IA no FACIL
                    currentScene = CurrentScene.Game;
                    game.setScreen(new GameScreen(game));
                }
                break;
                
            case 1:
                //Selecionou os creditos
                if(currentScene == CurrentScene.Menu)
                {
                    currentScene = CurrentScene.Creditos;
                }
                //Selecionou para jogar contra a IA
                else if (currentScene == CurrentScene.ModeSelection)
                {
                    currentScene = CurrentScene.DifficultySelection;
                    position = 0;
                    UpdatePosition();
                }
                //Apertou para sair dos creditos
                else if(currentScene == CurrentScene.Creditos)
                {
                    currentScene = CurrentScene.Menu;
                    position = 0;
                    UpdatePosition();
                }
                //Selecionou para jogar no medio
                else if (currentScene == CurrentScene.DifficultySelection)
                {
                    //Inicia IA no MEDIO
                    currentScene = CurrentScene.Game;
                    game.setScreen(new GameScreen(game));
                }
                break;
                
            case 2:
                //Selecionou para jogar no dificil
                if (currentScene == CurrentScene.DifficultySelection)
                {
                    //Inicia IA no DIFICIL
                    currentScene = CurrentScene.Game;
                    game.setScreen(new GameScreen(game));
                }
                //Selecionou para sair
                else
                {
                    System.exit(0);
                }
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
        if(ke.getKeyCode() == KeyEvent.VK_UP && currentScene != CurrentScene.Creditos)
        {
            PreviousPosition();
        }
        else if(ke.getKeyCode() == KeyEvent.VK_DOWN && currentScene != CurrentScene.Creditos)
        {
            NextPosition();
        }
        else if(ke.getKeyCode() == KeyEvent.VK_ENTER)
        {
            MenuSelection();
        }
        else if(ke.getKeyCode() == KeyEvent.VK_ESCAPE)
        {
            if(currentScene == CurrentScene.Menu)
            {
                System.exit(0);
            }
            else if (currentScene == CurrentScene.Game)
            {
                currentScene = CurrentScene.Menu;
                position = 0;
                UpdatePosition();
                game.setScreen(new Menu(game));
            }
            else
            {
                currentScene = CurrentScene.Menu;
                position = 0;
                UpdatePosition();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
