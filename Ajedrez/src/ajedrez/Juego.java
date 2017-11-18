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
public class Juego {

    public Pieza getSel() {
        return sel;
    }

    public void setSel(Pieza sel) {
        this.sel = sel;
    }

    private Pieza sel;
    private int turno;
    private boolean enjuego;
    private ArrayList movs = new ArrayList();

    public Juego() {
    }

    public Juego(int turno, boolean enjuego) {
        this.turno = turno;
        this.enjuego = enjuego;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public boolean isEnjuego() {
        return enjuego;
    }

    public void setEnjuego(boolean enjuego) {
        this.enjuego = enjuego;
    }

    public ArrayList getMovs() {
        return movs;
    }

    public void setMovs(ArrayList movs) {
        this.movs = movs;
    }

    public boolean juegoval(Pieza[][] tablero, int x, int y, int turno) {
        System.out.println(turno);
        if (turno % 2 == 0) {
            if (tablero[y][x].getColor().equals(Color.white)) {
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "No selecciono una pieza suya");
                return false;
            }
        } else {
            if (tablero[y][x].getColor().equals(Color.black)) {
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "No selecciono una pieza suya");
                return false;
            }
        }
    }
}
