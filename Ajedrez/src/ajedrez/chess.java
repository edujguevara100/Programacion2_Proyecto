/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrez;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author edujg
 */
public class chess {

    static Juego val = new Juego();
    static ArrayList<Pieza[][]> jugadas = new ArrayList();
    static Pieza[][] tablero;

    public static void main(String args[]) {
        tablero = tablero();
        jugadas.add(tablero());
        Imprimir(jugadas.get(jugadas.size() - 1), 0, 0);
        boolean w = false;
        int turno = 0;
        while (!w) {
            boolean select = false;
            int x = 0;
            int y = 0;
            int xo = 0;
            int yo = 0;
            while (!select) {
                boolean ex = false;
                while (!ex) {
                    try {
                        y = Integer.parseInt(JOptionPane.showInputDialog("Seleccione la posicion en y de su pieza:"));
                        if (y < 0 || y > 7) {
                            throw new NullPointerException();
                        }
                        ex = true;
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Posicion Invalida");
                        ex = false;
                    }
                }
                ex = false;
                while (!ex) {
                    try {
                        x = Integer.parseInt(JOptionPane.showInputDialog("Seleccione la posicion en x de su pieza:"));
                        if (x < 0 || x > 7) {
                            throw new NullPointerException();
                        }
                        ex = true;
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Posicion Invalida");
                        ex = false;
                    }
                }
                select = val.juegoval(tablero, x, y, turno);
            }
            boolean mov = false;
            while (!mov) {
                boolean ex = false;
                while (!ex) {
                    try {
                        yo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la posicion en y a la que se quiere mover:"));
                        if (yo < 0 || yo > 7) {
                            throw new NullPointerException();
                        }
                        ex = true;
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Posicion Invalida");
                        ex = false;
                    }
                }
                ex = false;
                while (!ex) {
                    try {
                        xo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la posicion en x a la que se quiere mover:"));
                        if (xo < 0 || xo > 7) {
                            throw new NullPointerException();
                        }
                        ex = true;
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Posicion Invalida");
                        ex = false;
                    }
                }
                //Pieza[][] temp = new Pieza[8][8];
                boolean movvalid = tablero[y][x].movimiento(tablero, x, y, xo, yo);
                //if (movvalid == true) {
                // temp = tablero.clone();
                // temp[y][x].comer(tablero, x, y, xo, yo);
                //}
                System.out.println(movvalid);
                boolean jaque = false, jaque2 = false;
                Pieza[][] revert = new Pieza[8][8];
                revert = tablero.clone();
                Pieza[][] temp = clone(tablero.clone());
                if (movvalid) {
                    if (turno % 2 == 0) {
                        for (int i = 0; i < 8; i++) {
                            for (int j = 0; j < 8; j++) {
                                if (tablero[i][j] instanceof Rey && tablero[i][j].getColor().equals(Color.white)) {
                                    jaque = ((Rey) (tablero[i][j])).jaque(tablero, turno);
                                    jaque2 = ((Rey) (temp[i][j])).jaque(temp[y][x].comer(temp, x, y, xo, yo), turno);
                                    if (jaque == true && jaque2 == true) {
                                        JOptionPane.showMessageDialog(null, "Jugador 1 en jaque");
                                        tablero = revert;
                                        break;
                                    } else {
                                        break;
                                    }
                                }
                            }
                        }
                    } else {
                        for (int i = 0; i < 8; i++) {
                            for (int j = 0; j < 8; j++) {
                                if (tablero[i][j] instanceof Rey && tablero[i][j].getColor().equals(Color.black)) {
                                    jaque = ((Rey) (tablero[i][j])).jaque(tablero, turno);
                                    jaque2 = ((Rey) (temp[i][j])).jaque(temp[y][x].comer(temp, x, y, xo, yo), turno);
                                    if (jaque == true && jaque2 == true) {
                                        JOptionPane.showMessageDialog(null, "Jugador 2 en jaque");
                                        tablero = revert;
                                        break;
                                    } else {
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
                if (jaque == true && jaque2 == true) {
                    JOptionPane.showMessageDialog(null, "Movimiento Invalido");
                    break;
                }
                if (movvalid == false) {
                    JOptionPane.showMessageDialog(null, "Movimiento Invalido");
                    break;
                } else {
                    tablero = tablero[y][x].comer(tablero, x, y, xo, yo);
                    Imprimir(tablero, 0, 0);
                    turno++;
                    mov = true;
                }

            }
        }
    }

    public static Pieza[][] tablero() {
        Pieza[][] tablero = {
            {new Torre(Color.black), new Caballo(Color.black), new Alfil(Color.black), new Reina(Color.black), new Rey(Color.black), new Alfil(Color.black), new Caballo(Color.black), new Torre(Color.black)},
            {new Peon(Color.black), new Peon(Color.black), new Peon(Color.black), new Peon(Color.black), new Peon(Color.black), new Peon(Color.black), new Peon(Color.black), new Peon(Color.black)},
            {new Blank(Color.BLUE), new Blank(Color.BLUE), new Blank(Color.BLUE), new Blank(Color.BLUE), new Blank(Color.BLUE), new Blank(Color.BLUE), new Blank(Color.BLUE), new Blank(Color.BLUE)},
            {new Blank(Color.BLUE), new Blank(Color.BLUE), new Blank(Color.BLUE), new Blank(Color.BLUE), new Blank(Color.BLUE), new Blank(Color.BLUE), new Blank(Color.BLUE), new Blank(Color.BLUE)},
            {new Blank(Color.BLUE), new Blank(Color.BLUE), new Blank(Color.BLUE), new Blank(Color.BLUE), new Blank(Color.BLUE), new Blank(Color.BLUE), new Blank(Color.BLUE), new Blank(Color.BLUE)},
            {new Blank(Color.BLUE), new Blank(Color.BLUE), new Blank(Color.BLUE), new Blank(Color.BLUE), new Blank(Color.BLUE), new Blank(Color.BLUE), new Blank(Color.BLUE), new Blank(Color.BLUE)},
            {new Peon(Color.white), new Peon(Color.white), new Peon(Color.white), new Peon(Color.white), new Peon(Color.white), new Peon(Color.white), new Peon(Color.white), new Peon(Color.white)},
            {new Torre(Color.white), new Caballo(Color.white), new Alfil(Color.white), new Reina(Color.white), new Rey(Color.white), new Alfil(Color.white), new Caballo(Color.white), new Torre(Color.white)}
        };
        return tablero;
    }

    public static void Imprimir(Pieza[][] matriz, int filas, int columnas) {
        if (filas == matriz.length - 1 && columnas == matriz.length - 1) {
            System.out.println(matriz[filas][columnas].toString() + "\t");
        } else {
            if (columnas == matriz.length - 1) {
                System.out.println(matriz[filas][columnas].toString());
                Imprimir(matriz, filas + 1, 0);
            } else {
                System.out.print(matriz[filas][columnas].toString() + "\t");
                Imprimir(matriz, filas, columnas + 1);
            }
        }
    }

    public static Pieza[][] clone(Pieza[][] tablero) {
        Pieza[][] temp = new Pieza[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                temp[i][j] = tablero[i][j];
            }
        }
        return temp;
    }
}
