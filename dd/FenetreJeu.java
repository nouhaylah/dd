
import java.awt.GridLayout;

import javax.swing.*;
import models.Archer;
import models.Guerrier;
import models.Sorcier;

public class FenetreJeu extends JFrame {
    public PlateauDeJeu plateauDeJeu;
    public AvancementJeu avancementJeu;
    public Archer archere;
    public Sorcier sorciere;
    public Guerrier guerrier;

    public FenetreJeu(Archer archere, Sorcier sorciere, Guerrier guerrier) {
        this.archere = archere;
        this.sorciere = sorciere;
        this.guerrier = guerrier;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1800, 800); // Taille de la fenêtre
        setLayout(new GridLayout()); // Utilisation d'un GridLayout 6x6
        this.avancementJeu = new AvancementJeu(archere, sorciere, guerrier);
        this.plateauDeJeu = new PlateauDeJeu(archere, sorciere, guerrier, avancementJeu);
        add(plateauDeJeu);
        add(avancementJeu);
        setLocationRelativeTo(null); // Centrer la fenêtre sur l'écran
    }
}