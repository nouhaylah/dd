package src.controllers;

import java.awt.Color;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Case extends JButton {
    private Color couleur;
    private String type;
    private Icon icon;
    private String path;
    private int x, y;
    private String answer;
    private String pathEnigme;
    private int points;

    public Case(int x, int y, Color couleur, String type, String pathEnigme, String answer) { // pour les
                                                                                              // cases
                                                                                              // enigme
        super();
        this.couleur = couleur;
        this.type = type;
        this.pathEnigme = pathEnigme;
        this.x = x;
        this.y = y;
        this.answer = answer;
    }

    public Case(int x, int y, Color couleur, String type) { // pour les cases combat
        super();
        this.couleur = couleur;
        this.type = type;
        this.path = "";
        this.x = x;
        this.y = y;
        this.answer = "";
    }

    public Case(int x, int y, String type, String path, int points) { // pour les cases chance et malchance
        super();
        this.type = type;
        this.x = x;
        this.y = y;
        this.path = path;
        this.points = points;
    }

    public Case(int x, int y, Color couleur, String type, String path) { // pour les cases depart
        super();
        this.couleur = couleur;
        this.type = type;
        this.path = path;
        this.x = x;
        this.y = y;
        this.answer = "";
        this.icon = new ImageIcon(path);
        // setIcon(icon);
    }

    public String getPathEnigme() {
        return pathEnigme;
    }

    public void setPathEnigme(String pathEnigme) {
        this.pathEnigme = pathEnigme;
    }

    public Color getCouleur() {
        return couleur;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(String path) {
        icon = new ImageIcon(path);
        setIcon(icon);
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getPoints() {
        return points;
    }

}
