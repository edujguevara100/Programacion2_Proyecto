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
public class Peon extends Pieza {

    private boolean primermov = false;

    public Peon(Color color) {
        super(color);
    }

    public boolean isPrimermov() {
        return primermov;
    }

    public void setPrimermov(boolean primermov) {
        this.primermov = primermov;
    }

    @Override
    public Pieza[][] comer(Pieza[][] tablero, int x, int y, int xo, int yo) {
        if (yo == 0) {
            boolean pieza = false;
            while (!pieza) {
                String p = JOptionPane.showInputDialog("Ingrese una opcion:\n"
                        + "1: Reina\n"
                        + "2: Caballo\n"
                        + "3: Alfil\n"
                        + "4: Torre\n");
                switch (p) {
                    case "1":
                        Pieza temp = new Reina(Color.white);
                        tablero[y][x] = new Blank(Color.BLUE);
                        tablero[yo][xo] = temp;
                        pieza = true;
                        break;
                    case "2":
                        Pieza t = new Caballo(Color.white);
                        tablero[y][x] = new Blank(Color.BLUE);
                        tablero[yo][xo] = t;
                        pieza = true;
                        break;
                    case "3":
                        Pieza te = new Alfil(Color.white);
                        tablero[y][x] = new Blank(Color.BLUE);
                        tablero[yo][xo] = te;
                        pieza = true;
                        break;
                    case "4":
                        Pieza tem = new Torre(Color.white);
                        tablero[y][x] = new Blank(Color.BLUE);
                        tablero[yo][xo] = tem;
                        pieza = true;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Pieza invalida");
                }
            }
            return tablero;
        } else if (yo == 7) {
            boolean pieza = false;
            while (!pieza) {
                String p = JOptionPane.showInputDialog("Ingrese una opcion:\n"
                        + "1: Reina\n"
                        + "2: Caballo\n"
                        + "3: Alfil\n"
                        + "4: Torre\n");
                switch (p) {
                    case "1":
                        Pieza temp = new Reina(Color.black);
                        tablero[y][x] = new Blank(Color.BLUE);
                        tablero[yo][xo] = temp;
                        pieza = true;
                        break;
                    case "2":
                        Pieza t = new Caballo(Color.black);
                        tablero[y][x] = new Blank(Color.BLUE);
                        tablero[yo][xo] = t;
                        pieza = true;
                        break;
                    case "3":
                        Pieza te = new Alfil(Color.black);
                        tablero[y][x] = new Blank(Color.BLUE);
                        tablero[yo][xo] = te;
                        pieza = true;
                        break;
                    case "4":
                        Pieza tem = new Torre(Color.black);
                        tablero[y][x] = new Blank(Color.BLUE);
                        tablero[yo][xo] = tem;
                        pieza = true;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Pieza invalida");
                }
            }
            return tablero;
        } else {
            Pieza temp = tablero[y][x];
            tablero[y][x] = new Blank(Color.BLUE);
            tablero[yo][xo] = temp;
            return tablero;
        }
    }

    @Override
    public String toString() {
        if (super.getColor().equals(Color.white)) {
            return (char) 27 + "[34m| P |";
        } else {
            return (char) 27 + "[31m| P |";
        }
    }

    @Override
    public boolean movimiento(Pieza[][] tablero, int x, int y, int xo, int yo) {
        if (!primermov) {
            boolean jaq = false;
            if (tablero[y][x].getColor().equals(Color.black)) {
                if (xo - x == 0 && (y + 1 == yo || y + 2 == yo)) {
                    for (int i = y; i <= yo; i++) {
                        if (i != yo - 1) {
                            if (tablero[i + 1][x] instanceof Blank) {
                            } else {
                                //JOptionPane.showMessageDialog(null, "Movimiento Invalido");
                                return false;
                            }
                        } else {
                            if (tablero[i + 1][x] instanceof Blank) {
                                /*Pieza temp = tablero[y][x];
                                tablero[y][x] = new Blank(Color.BLUE);
                                tablero[i + 1][x] = temp;
                                ((Peon) (tablero[i + 1][x])).setPrimermov(true);*/
                                return true;
                            } else {
                                //JOptionPane.showMessageDialog(null, "Movimiento Invalido");
                                return false;
                            }
                        }
                    }
                } else if (y + 1 == yo && x + 1 == xo) {
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
                } else {
                    //JOptionPane.showMessageDialog(null, "Movimiento invalido");
                    return false;
                }
            } else {
                //blanca
                if (xo - x == 0 && (y - 1 == yo || y - 2 == yo)) {
                    for (int i = y; i >= yo; i--) {
                        if (i != yo + 1) {
                            if (tablero[i - 1][x] instanceof Blank) {

                            } else {
                                //JOptionPane.showMessageDialog(null, "Movimiento Invalido");
                                return false;
                            }
                        } else {
                            if (tablero[i - 1][x] instanceof Blank) {
                                /*Pieza temp = tablero[y][x];
                                tablero[y][x] = new Blank(Color.BLUE);
                                tablero[i - 1][x] = temp;
                                ((Peon) (tablero[i - 1][x])).setPrimermov(true);*/
                                return true;
                            } else {
                                //JOptionPane.showMessageDialog(null, "Movimiento Invalido");
                                return false;
                            }
                        }
                    }
                } else if (y - 1 == yo && x + 1 == xo) {
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
                } else {
                    //JOptionPane.showMessageDialog(null, "Movimiento invalido");
                    return false;
                }
            }
        } else {
            if (tablero[y][x].getColor().equals(Color.black)) {
                if (xo - x == 0 && y + 1 == yo) {
                    for (int i = y; i <= yo; i++) {
                        if (tablero[i + 1][x] instanceof Blank) {
                            /*Pieza temp = tablero[y][x];
                            tablero[y][x] = new Blank(Color.BLUE);
                            tablero[i + 1][x] = temp;
                            ((Peon) (tablero[i + 1][x])).setPrimermov(true);*/
                            return true;

                        } else {
                            //JOptionPane.showMessageDialog(null, "Movimiento Invalido");
                            return false;
                        }
                    }
                } else {
                    //JOptionPane.showMessageDialog(null, "Movimiento invalido");
                    return false;
                }
            } else {
                //blanca
                if (xo - x == 0 && y - 1 == yo) {
                    for (int i = y; i >= yo; i--) {
                        if (tablero[i - 1][x] instanceof Blank) {
                            /*Pieza temp = tablero[y][x];
                            tablero[y][x] = new Blank(Color.BLUE);
                            tablero[i - 1][x] = temp;
                            ((Peon) (tablero[i - 1][x])).setPrimermov(true);*/
                            return true;

                        } else {
                            //JOptionPane.showMessageDialog(null, "Movimiento Invalido");
                            return false;
                        }
                    }
                } else {
                    //JOptionPane.showMessageDialog(null, "Movimiento invalido");
                    return false;
                }
            }
        }
        return false;
    }

}
