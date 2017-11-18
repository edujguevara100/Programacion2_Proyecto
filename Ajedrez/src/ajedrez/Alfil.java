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
public class Alfil extends Pieza {

    public Alfil(Color color) {
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
            return (char) 27 + "[34m| B |";
        } else {
            return (char) 27 + "[31m| B |";
        }
    }

    @Override
    public boolean movimiento(Pieza[][] tablero, int x, int y, int xo, int yo) {
        if (Math.abs(xo - x) == Math.abs(yo - y) && yo != y && xo != x) {
            String direccion = "";
            if (x - xo > 0 && y - yo > 0) {
                direccion = "ai";
            } else if (x - xo < 0 && y - yo < 0) {
                direccion = "od";
            } else if (x - xo < 0 && y - yo > 0) {
                direccion = "ad";
            } else {
                direccion = "oi";
            }
            if (direccion.equals("ai")) {
                for (int i = y; i >= yo; i--) {
                    for (int j = x; j >= xo; j--) {
                        if (i != yo + 1 && j != xo + 1) {
                            if (tablero[i - 1][j - 1] instanceof Blank) {

                            } else {
                                //JOptionPane.showMessageDialog(null, "Movimiento invalido");
                                return false;
                            }
                        } else {
                            if (tablero[yo][xo] instanceof Blank) {
                                /*Pieza temp = tablero[y][x];
                                tablero[y][x] = new Blank(Color.BLUE);
                                tablero[yo][xo] = temp;
                                System.out.println(tablero[yo][xo].getColor() + "///" + Color.white);*/
                                return true;
                            } else if (!(tablero[yo][xo].getColor().equals(tablero[y][x].getColor()))) {
                                /*Pieza temp = tablero[y][x];
                                tablero[y][x] = new Blank(Color.BLUE);
                                tablero[yo][xo] = temp;
                                System.out.println(tablero[yo][xo].getColor() + "///" + Color.white);*/
                                return true;
                            } else {
                                //JOptionPane.showMessageDialog(null, "Movimiento invalido");
                                return false;
                            }
                        }
                    }
                }
            } else if (direccion.equals("od")) {
                for (int i = y; i <= yo; i++) {
                    for (int j = x; j <= xo; j++) {
                        if (i != yo - 1 && j != xo - 1) {
                            if (tablero[i + 1][j + 1] instanceof Blank) {

                            } else {
                                //JOptionPane.showMessageDialog(null, "Movimiento invalido");
                                return false;
                            }
                        } else {
                            if (tablero[yo][xo] instanceof Blank) {
                                /*Pieza temp = tablero[y][x];
                                tablero[y][x] = new Blank(Color.BLUE);
                                tablero[yo][xo] = temp;*/
                                return true;
                            } else if (!(tablero[y][x].getColor().equals(tablero[i + 1][j + 1].getColor()))) {
                                /*Pieza temp = tablero[y][x];
                                tablero[y][x] = new Blank(Color.BLUE);
                                tablero[yo][xo] = temp;*/
                                return true;
                            } else {
                                //JOptionPane.showMessageDialog(null, "Movimiento invalido");
                                return false;
                            }
                        }
                    }
                }
            } else if (direccion.equals("ad")) {
                for (int i = y; i >= yo; i--) {
                    for (int j = x; j <= xo; j++) {
                        if (i != yo + 1 && j != xo - 1) {
                            if (tablero[i - 1][j + 1] instanceof Blank) {

                            } else {
                                //JOptionPane.showMessageDialog(null, "Movimiento invalido");
                                return false;
                            }
                        } else {
                            if (tablero[yo][xo] instanceof Blank) {
                                /*Pieza temp = tablero[y][x];
                                tablero[y][x] = new Blank(Color.BLUE);
                                tablero[yo][xo] = temp;*/
                                return true;
                            } else if (!(tablero[y][x].getColor().equals(tablero[yo][xo].getColor()))) {
                                /*Pieza temp = tablero[y][x];
                                tablero[y][x] = new Blank(Color.BLUE);
                                tablero[yo][xo] = temp;*/
                                return true;
                            } else {
                                //JOptionPane.showMessageDialog(null, "Movimiento invalido");
                                return false;
                            }
                        }
                    }
                }
            } else {
                for (int i = y; i <= yo; i++) {
                    for (int j = x; j >= xo; j--) {
                        if (i != yo - 1 && j != xo + 1) {
                            if (tablero[i + 1][j - 1] instanceof Blank) {

                            } else {
                                //JOptionPane.showMessageDialog(null, "Movimiento invalido");
                                return false;
                            }
                        } else {
                            if (tablero[yo][xo] instanceof Blank) {
                                /*-Pieza temp = tablero[y][x];
                                tablero[y][x] = new Blank(Color.BLUE);
                                tablero[yo][xo] = temp;*/
                                return true;
                            } else if (!(tablero[y][x].getColor().equals(tablero[yo][xo].getColor()))) {
                                /*Pieza temp = tablero[y][x];
                                tablero[y][x] = new Blank(Color.BLUE);
                                tablero[yo][xo] = temp;*/
                                return true;
                            } else {
                                //JOptionPane.showMessageDialog(null, "Movimiento invalido");
                                return false;
                            }
                        }
                    }
                }
            }
        } else {
            //JOptionPane.showMessageDialog(null, "Movimiento invalido3");
            return false;
        }
        return false;
    }

}
