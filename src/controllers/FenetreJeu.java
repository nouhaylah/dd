package src.controllers;

import java.awt.GridLayout;

import javax.swing.*;

import src.models.Archer;
import src.models.Clerc;
import src.models.Guerrier;
import src.models.Sorcier;
import src.views.PlateauDeJeu;

public class FenetreJeu extends JFrame {
    public PlateauDeJeu plateauDeJeu;
    public AvancementJeu avancementJeu;
    public Archer archere;
    public Sorcier sorciere;
    public Guerrier guerrier;

    public FenetreJeu(Archer archere, Sorcier sorciere, Guerrier guerrier, Clerc clerc) {
        this.archere = archere;
        this.sorciere = sorciere;
        this.guerrier = guerrier;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1800, 800); // Taille de la fenêtre
        setLayout(new GridLayout()); // Utilisation d'un GridLayout 6x6
        this.avancementJeu = new AvancementJeu(archere, sorciere, guerrier, clerc);
        this.plateauDeJeu = new PlateauDeJeu(archere, sorciere, guerrier, clerc, avancementJeu);
        add(plateauDeJeu);
        add(avancementJeu);
        setLocationRelativeTo(null); // Centrer la fenêtre sur l'écran
    }
}