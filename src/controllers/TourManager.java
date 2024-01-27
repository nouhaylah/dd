package src.controllers;

public class TourManager {
    public int tour;

    public TourManager() {
        tour = 1;
    }

    public void tourSuivant() {
        tour++;
    }

    public int getTour() {
        return tour;
    }

    public void setTour(int tour) {
        this.tour = tour;
    }

    public void resetTour() {
        tour = 1;
    }

    public String tourPersonnage(int tour) {
        if (tour % 3 == 0) {
            return "Archer";
        } else if (tour % 3 == 1) {
            return "Sorcier";
        } else {
            return "Guerrier";
        }
    }

}
