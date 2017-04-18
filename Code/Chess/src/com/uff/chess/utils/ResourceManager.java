/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uff.chess.utils;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Aqui ficam as images a serem usados no jogo
 * @author Vynicius Pontes
 */
public class ResourceManager {
    
    public final static String BACKGROUND = ".//images//background.png";
    public final static String BLACK_SPOT = ".//images//black_spot.png";
    public final static String WHITE_SPOT = ".//images//white_spot.png";
    
    public final static String BLACK_BISHOP = ".//images//blackBishop.png";
    public final static String BLACK_KING = ".//images//blackKing.png";
    public final static String BLACK_KNIGHT = ".//images//blackKnight.png";
    public final static String BLACK_PAWN = ".//images//blackPawn.png";
    public final static String BLACK_QUEEN = ".//images//blackQueen.png";
    public final static String BLACK_ROOK = ".//images//blackRook.png";
    
    public final static String WHITE_BISHOP = ".//images//whiteBishop.png";
    public final static String WHITE_KING = ".//images//whiteKing.png";
    public final static String WHITE_KNIGHT = ".//images//whiteKnight.png";
    public final static String WHITE_PAWN = ".//images//whitePawn.png";
    public final static String WHITE_QUEEN = ".//images//whiteQueen.png";
    public final static String WHITE_ROOK = ".//images//whiteRook.png";
    
    public static Image loadImage(String imageURL){
        BufferedImage img;
        try {
            img = ImageIO.read(new File(imageURL));
            return img;
        } catch (IOException e) {
            System.out.println(e.getMessage() + ": Image not found: " + imageURL );
        }
        return null;
    }
}
