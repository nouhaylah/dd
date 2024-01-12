package models;


public class Personnage {
    private int pointsDeVie;
    private int puissanceAttaques;
    private String nom;
    private int x,y;
    private String icon;
    private String type;

    public Personnage(){
        this.pointsDeVie = 0;
        this.puissanceAttaques = 0;
        this.nom = "";
        this.x = 0;
        this.y = 0;
    }

    public Personnage(String type){
        this.pointsDeVie = 0;
        this.puissanceAttaques = 0;
        this.nom = "";
        this.x = 0;
        this.y = 0;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPointsDeVie() {
        return pointsDeVie;
    }

    public int getPuissanceAttaques() {
        return puissanceAttaques;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIcon() {
        return icon;
    }
    
    public void setPointsDeVie(int pointsDeVie) {
        this.pointsDeVie = pointsDeVie;
    }

    public void setPuissanceAttaques(int puissanceAttaques) {
        this.puissanceAttaques = puissanceAttaques;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getNom() {
        return nom;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


}
