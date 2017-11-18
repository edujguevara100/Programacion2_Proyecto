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
public class Blank extends Pieza {

    public Blank(Color color) {
        super(color);
    }

    public Blank() {
        super();
    }

    @Override
    public Pieza[][] comer(Pieza[][] tablero, int x, int y, int xo, int yo) {
        return tablero;
    }

    @Override
    public String toString() {
        return "|   |";
    }

    @Override
    public boolean movimiento(Pieza[][] tablero, int x, int y, int xo, int yo) {
        return false;
    }

}
