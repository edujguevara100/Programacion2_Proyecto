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
public class Rey extends Pieza {

    Juego val = new Juego();

    public Rey(Color color) {
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
            return (char) 27 + "[34m| K |";
        } else {
            return (char) 27 + "[31m| K |";
        }
    }

    @Override
    public boolean movimiento(Pieza[][] tablero, int x, int y, int xo, int yo) {
        /*boolean inv = jaquemov(tablero, x, y, xo, yo);
        if (inv == true) {
            return false;
        }*/
        if (y + 1 == yo && x + 1 == xo) {
            if (!tablero[y][x].getColor().equals(tablero[yo][xo].getColor())) {
                return true;
            } else {
                //JOptionPane.showMessageDialog(null, "Movimiento Invalido");
                return false;
            }
        } else if (y + 1 == yo && x == xo) {
            if (!tablero[y][x].getColor().equals(tablero[yo][xo].getColor())) {
                return true;
            } else {
                //JOptionPane.showMessageDialog(null, "Movimiento Invalido");
                return false;
            }
        } else if (y + 1 == yo && x - 1 == xo) {
            if (!tablero[y][x].getColor().equals(tablero[yo][xo].getColor())) {
                return true;
            } else {
                //JOptionPane.showMessageDialog(null, "Movimiento Invalido");
                return false;
            }
        } else if (y == yo && x - 1 == xo) {
            if (!tablero[y][x].getColor().equals(tablero[yo][xo].getColor())) {
                return true;
            } else {
                //JOptionPane.showMessageDialog(null, "Movimiento Invalido");
                return false;
            }
        } else if (y - 1 == yo && x - 1 == xo) {
            if (!tablero[y][x].getColor().equals(tablero[yo][xo].getColor())) {
                return true;
            } else {
                //JOptionPane.showMessageDialog(null, "Movimiento Invalido");
                return false;
            }
        } else if (y - 1 == yo && x == xo) {
            if (!tablero[y][x].getColor().equals(tablero[yo][xo].getColor())) {
                return true;
            } else {
                //JOptionPane.showMessageDialog(null, "Movimiento Invalido");
                return false;
            }
        } else if (y - 1 == yo && x + 1 == xo) {
            if (!tablero[y][x].getColor().equals(tablero[yo][xo].getColor())) {
                return true;
            } else {
                //JOptionPane.showMessageDialog(null, "Movimiento Invalido");
                return false;
            }
        } else if (y == yo && x + 1 == xo) {
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

    public boolean jaque(Pieza[][] tablero, int turno) {
        if (turno % 2 == 0) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (tablero[i][j] instanceof Rey && tablero[i][j].getColor().equals(Color.white)) {
                        for (int k = 0; k < 8; k++) {
                            for (int l = 0; l < 8; l++) {
                                if (tablero[k][l].getColor().equals(Color.black) /*&& !(tablero[k][l] instanceof Rey)*/) {
                                    boolean jaq = tablero[k][l].movimiento(tablero, l, k, j, i);
                                    if (jaq == true) {
                                        System.out.println("entro jaque");
                                        return true;
                                    }
                                }
                            }
                        }
                        return false;
                    }
                }
            }

        } else {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (tablero[i][j] instanceof Rey && tablero[i][j].getColor().equals(Color.black)) {
                        System.out.println("entro blanco");
                        for (int k = 0; k < 8; k++) {
                            for (int l = 0; l < 8; l++) {
                                if (tablero[k][l].getColor().equals(Color.white) /*&& !(tablero[k][l] instanceof Rey)*/) {
                                    boolean jaq = tablero[k][l].movimiento(tablero, l, k, j, i);
                                    if (jaq == true) {
                                        return true;
                                    }
                                }
                            }
                        }
                        return false;
                    }
                }
            }
        }
        return false;
    }

    private boolean jaquemov(Pieza[][] tablero, int x, int y, int xo, int yo, int turno) {
        /*if (tablero[y][x].getColor().equals(Color.black)) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (tablero[i][j].getColor().equals(Color.white)) {
                        boolean jaq = tablero[i][j].movimiento(tablero, i, j, xo, yo);
                        if (jaq == true) {
                            //JOptionPane.showMessageDialog(null, "Movimiento invalido");
                            return true;
                        }
                    }
                }
            }
            return false;
        } else {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (tablero[i][j].getColor().equals(Color.black)) {
                        boolean jaq = tablero[i][j].movimiento(tablero, i, j, xo, yo);
                        if (jaq == true) {
                            //JOptionPane.showMessageDialog(null, "Movimiento invalido");
                            return true;
                        }
                    }
                }
            }
            return false;
        }*/
        if (tablero[y][x].getColor().equals(Color.black) && tablero[y][x] instanceof Rey) {
            Pieza[][] revert = new Pieza[8][8];
            revert = tablero;
            Pieza[][] temp = new Pieza[8][8];
            temp = tablero.clone();
            temp = temp[y][x].comer(temp, x, y, xo, yo);
            boolean jaque = jaque(temp, turno);
            if (jaque == true) {
                return true;
            } else {
                return false;
            }
        } else if (tablero[y][x].getColor().equals(Color.white) && tablero[y][x] instanceof Rey) {

        } else {
            return false;
        }
        return false;
    }
}
