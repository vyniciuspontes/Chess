package com.uff.chess.gameobjects;

import com.vpontes.gameframework.math.Vector2;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

public abstract class GameObject {

    private boolean disabled;
    protected BufferedImage image;
    private Vector2 position;
    private Vector2 center;
    private int widght;
    private int height;

    public Image getImage() {
        return image;
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public Vector2 getCenter(int objectWidght, int objectHeight) {
        return new Vector2(this.position.getX() + this.widght / 2 - (objectWidght / 2), this.position.getY() + this.height / 2 - (objectHeight / 2));
    }

    public int getWidght() {
        return widght;
    }

    public void setWidght(int widght) {
        this.widght = widght;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public GameObject(Vector2 position, int widght, int height) {
        this.position = position;
        this.widght = widght;
        this.height = height;
    }
    
    public GameObject(Vector2 position, int widght, int height, BufferedImage image) {
        this.position = position;
        this.widght = widght;
        this.height = height;

        this.image = image;
    }

    public GameObject(Vector2 position, int widght, int height, BufferedImage image, boolean disabled) {
        this.position = position;
        this.widght = widght;
        this.height = height;
        this.disabled = disabled;
        this.image = image;
    }

    public void draw(Graphics g) {
        if (!disabled) {
            g.drawImage(this.image, (int) position.getX(), (int) position.getY(), this.widght, this.height, null);
        }
    }
    
    public void draw(Graphics g, Image image) {
        if (!disabled) {
            g.drawImage(image, (int) position.getX(), (int) position.getY(), this.widght, this.height, null);
        }
    }
}
