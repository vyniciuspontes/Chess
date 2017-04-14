/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uff.chess.gameobjects;

import com.vpontes.gameframework.math.Vector2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Vynicius Pontes
 */
public class Background extends GameObject {

    public Background(Vector2 position, int widght, int height, String imagePath) {
        super(position, widght, height, imagePath);
    }
}
