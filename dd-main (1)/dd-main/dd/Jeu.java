import actions.TourManager;
import models.Archer;
import models.Clerc;
import models.Guerrier;
import models.Sorcier;

public class Jeu {
    public FenetreJeu fenetreJeu;
    public Archer archere;
    public Sorcier sorciere;
    public Guerrier guerrier;

    TourManager tourManager = new TourManager();

    public Jeu(FenetreJeu fenetreJeu, Archer archere, Sorcier sorciere, Guerrier guerrier, Clerc clerc) {
        this.fenetreJeu = fenetreJeu;
        this.archere = archere;
        this.sorciere = sorciere;
        this.guerrier = guerrier;

        tourManager = new TourManager();
        int i = 0;
        while (i == 0) {
            // String personnage = tourManager.tourPersonnage();
            // System.out.println(personnage);
        }
    }

    public void start() {
        System.out.println("Jeu lancé");

    }

}
