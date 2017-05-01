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
 *
 * @author Vynicius Pontes
 */
public class ResourceManager {

    public static BufferedImage BACKGROUND;
    public static BufferedImage BLACK_SPOT;
    public static BufferedImage WHITE_SPOT;
    public static BufferedImage SELECTED_SPOT;

    public static BufferedImage BLACK_BISHOP;
    public static BufferedImage BLACK_KING;
    public static BufferedImage BLACK_KNIGHT;
    public static BufferedImage BLACK_PAWN;
    public static BufferedImage BLACK_QUEEN;
    public static BufferedImage BLACK_ROOK;

    public static BufferedImage WHITE_BISHOP;
    public static BufferedImage WHITE_KING;
    public static BufferedImage WHITE_KNIGHT;
    public static BufferedImage WHITE_PAWN;
    public static BufferedImage WHITE_QUEEN;
    public static BufferedImage WHITE_ROOK;

    public static void loadImages() {
        try {

            BACKGROUND = ImageIO.read(new File(".//images//background.png"));
            BLACK_SPOT = ImageIO.read(new File(".//images//black_spot.png"));
            WHITE_SPOT = ImageIO.read(new File(".//images//white_spot.png"));
            SELECTED_SPOT = ImageIO.read(new File(".//images//selected_spot.png"));

            BLACK_BISHOP = ImageIO.read(new File(".//images//blackBishop.png"));
            BLACK_KING = ImageIO.read(new File(".//images//blackKing.png"));
            BLACK_KNIGHT = ImageIO.read(new File(".//images//blackKnight.png"));
            BLACK_PAWN = ImageIO.read(new File(".//images//blackPawn.png"));
            BLACK_QUEEN = ImageIO.read(new File(".//images//blackQueen.png"));
            BLACK_ROOK = ImageIO.read(new File(".//images//blackRook.png"));

            WHITE_BISHOP = ImageIO.read(new File(".//images//whiteBishop.png"));
            WHITE_KING = ImageIO.read(new File(".//images//whiteKing.png"));
            WHITE_KNIGHT = ImageIO.read(new File(".//images//whiteKnight.png"));
            WHITE_PAWN = ImageIO.read(new File(".//images//whitePawn.png"));
            WHITE_QUEEN = ImageIO.read(new File(".//images//whiteQueen.png"));
            WHITE_ROOK = ImageIO.read(new File(".//images//whiteRook.png"));

        } catch (IOException e) {
            System.out.println(e.getMessage() + ": Image not found");
        }
    }
}
