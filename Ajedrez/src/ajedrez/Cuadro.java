/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrez;

import java.awt.Color;
import javax.swing.JLabel;

/**
 *
 * @author edujg
 */
public class Cuadro {
    private JLabel j;
    private Color color;
    private boolean select;
    private boolean ocup;
    private Pieza piece;

    public Cuadro() {
    }

    public Cuadro(JLabel j, Color color, boolean select, boolean ocup, Pieza piece) {
        this.j = j;
        this.color = color;
        this.select = select;
        this.ocup = ocup;
        this.piece = piece;
    }

    public JLabel getJ() {
        return j;
    }

    public void setJ(JLabel j) {
        this.j = j;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isSelect() {
        return select;
    }

    public void setSelect(boolean select) {
        this.select = select;
    }

    public boolean isOcup() {
        return ocup;
    }

    public void setOcup(boolean ocup) {
        this.ocup = ocup;
    }

    public Pieza getPiece() {
        return piece;
    }

    public void setPiece(Pieza piece) {
        this.piece = piece;
    }

    @Override
    public String toString() {
        return "Cuadro{" + "j=" + j + ", color=" + color + ", select=" + select + ", ocup=" + ocup + ", piece=" + piece + '}';
    }
    
}
