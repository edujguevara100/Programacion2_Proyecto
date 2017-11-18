/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrez;

import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author edujg
 */
public class Caballo extends Pieza {

    public Caballo(Color color) {
        super(color);
    }

    @Override
    public Pieza[][] comer(Pieza[][] tablero, int x, int y, int xo, int yo) {
        Pieza temp = tablero[y][x];
        tablero[y][x] = new Blank(Color.BLUE);
        tablero[yo][xo] = temp;
        return tablero;
    }

    @Override
    public String toString() {
        if (super.getColor().equals(Color.white)) {
            return (char) 27 + "[34m| H |";
        } else {
            return (char) 27 + "[31m| H |";
        }

    }

    @Override
    public boolean movimiento(Pieza[][] tablero, int x, int y, int xo, int yo) {
        if (y + 2 == yo && x + 1 == xo) {
            //ad
            if (!tablero[y][x].getColor().equals(tablero[yo][xo].getColor())) {
                return true;
            } else {
                //JOptionPane.showMessageDialog(null, "Movimiento Invalido");
                return false;
            }
        } else if (y + 2 == yo && x - 1 == xo) {
            //ai
            if (!tablero[y][x].getColor().equals(tablero[yo][xo].getColor())) {
                return true;
            } else {
                //JOptionPane.showMessageDialog(null, "Movimiento Invalido");
                return false;
            }
        } else if (x - 2 == xo && y + 1 == yo) {
            //ia
            if (!tablero[y][x].getColor().equals(tablero[yo][xo].getColor())) {
                return true;
            } else {
                //JOptionPane.showMessageDialog(null, "Movimiento Invalido");
                return false;
            }
        } else if (x - 2 == xo && y - 1 == yo) {
            //io
            if (!tablero[y][x].getColor().equals(tablero[yo][xo].getColor())) {
                return true;
            } else {
                //JOptionPane.showMessageDialog(null, "Movimiento Invalido");
                return false;
            }
        } else if (y - 2 == yo && x - 1 == xo) {
            //oi
            if (!tablero[y][x].getColor().equals(tablero[yo][xo].getColor())) {
                return true;
            } else {
                //JOptionPane.showMessageDialog(null, "Movimiento Invalido");
                return false;
            }
        } else if (y - 2 == yo && x + 1 == xo) {
            //od
            if (!tablero[y][x].getColor().equals(tablero[yo][xo].getColor())) {
                return true;
            } else {
                //JOptionPane.showMessageDialog(null, "Movimiento Invalido");
                return false;
            }
        } else if (x + 2 == xo && y - 1 == yo) {
            //do
            if (!tablero[y][x].getColor().equals(tablero[yo][xo].getColor())) {
                return true;
            } else {
                //JOptionPane.showMessageDialog(null, "Movimiento Invalido");
                return false;
            }
        } else if (x + 2 == xo && y + 1 == yo) {
            //da
            if (!tablero[y][x].getColor().equals(tablero[yo][xo].getColor())) {
                return true;
            } else {
                //JOptionPane.showMessageDialog(null, "Movimiento Invalido");
                return false;
            }
        } else {
            //JOptionPane.showMessageDialog(null, "Movimiento Invalido");
            return false;
        }
    }

}
