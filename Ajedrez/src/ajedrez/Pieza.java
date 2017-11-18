/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrez;

import java.awt.Color;

/**
 *
 * @author edujg
 */
public abstract class Pieza {

    private Color color;

    public abstract boolean movimiento(Pieza[][] tablero, int x, int y, int xo, int yo);

    public abstract Pieza[][] comer(Pieza[][] tablero, int x, int y, int xo, int yo);

    public Pieza(Color color) {
        this.color = color;
    }

    public Pieza() {
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

}
