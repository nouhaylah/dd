package src.views;

import javax.swing.*;

import src.controllers.AvancementJeu;
import src.controllers.Case;
import src.controllers.Cases;
import src.controllers.TourManager;
import src.models.Archer;
import src.models.Clerc;
import src.models.Guerrier;
import src.models.Personnage;
import src.models.Sorcier;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.List;

public class PlateauDeJeu extends JPanel implements ActionListener {
    public Cases cases = new Cases();
    public Case[][] casess = cases.getPlateau();
    public JButton[][] plateau = new JButton[7][7];
    private int currentJoueur = 1;
    public Archer archere;
    public Sorcier sorciere;
    public Guerrier guerrier;
    public Clerc clerc;
    public String personnage;
    public AvancementJeu avancementJeu;
    public int xSorciere, ySorciere, xArcher, yArcher, xGuerrier, yGuerrier, xClerc, yClerc, x;
    private String sorcierePlateau = "src\\resources\\sorcierePlateau.png";
    private String archerPlateau = "src\\resources\\archerePlateau.png";
    private String guerrierPlateau = "src\\resources\\guerrierPlateau.png";
    private String clercPlateau = "src\\resources\\clercPlateau.png";

    public PlateauDeJeu(Archer archere, Sorcier sorciere, Guerrier guerrier, Clerc clerc, AvancementJeu avancementJeu) {
        this.avancementJeu = avancementJeu;
        this.archere = archere;
        this.sorciere = sorciere;
        this.guerrier = guerrier;
        this.clerc = clerc;
        TourManager tourManager = new TourManager();
        this.personnage = tourManager.tourPersonnage(currentJoueur);
        this.xSorciere = sorciere.getX();
        this.ySorciere = sorciere.getY();
        this.xArcher = archere.getX();
        this.yArcher = archere.getY();
        this.xGuerrier = guerrier.getX();
        this.yGuerrier = guerrier.getY();
        this.xClerc = clerc.getX();
        this.yClerc = clerc.getY();

        setSize(700, 700); // Taille de la fenêtre
        setLayout(new GridLayout(7, 7)); // Utilisation d'un GridLayout 6x6
        // Remplissage du plateau avec des boutons (vous pouvez personnaliser cela selon
        // vos besoins)
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                plateau[i][j] = new JButton();
                plateau[i][j].setIcon(casess[i][j].getIcon());
                plateau[i][j].setBorder(BorderFactory.createLineBorder(Color.white));
                plateau[i][j].addActionListener(this);
                add(plateau[i][j]);

                // Implementation des couleurs du plateau
                if ((i + j) % 2 == 0) {
                    plateau[i][j].setBackground(Color.black);
                } else {
                    plateau[i][j].setBackground(Color.darkGray);
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (personnage.equals("Sorcier")) {
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 7; j++) {
                    if (e.getSource() == plateau[i][j]) {
                        xSorciere = i;
                        ySorciere = j;
                        System.out.println(xSorciere + " " + ySorciere);

                        if (isOccupiedSorciere(xSorciere, ySorciere)) {
                            System.out.println(
                                    "Deplacement Impossible. Un autre joueur est sur cette case!");
                        } else if (!isValidDiagonalMove(sorciere, xSorciere, ySorciere)) {
                            System.out.println(
                                    "Deplacement Impossible. Mouvement non valide!");
                        } else {
                            moveSorciere(sorciere, xSorciere, ySorciere);
                            handleCases(xSorciere, ySorciere, sorciere);
                            personnage = "Guerrier";
                            avancementJeu.joueurActuel.setText(guerrier.getNom());
                            break;
                        }
                    }
                }
            }
        }

        if (personnage.equals("Guerrier")) {
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 7; j++) {
                    if (e.getSource() == plateau[i][j]) {
                        xGuerrier = i;
                        yGuerrier = j;
                        System.out.println(xGuerrier + " " + yGuerrier);

                        if (isOccupiedGuerrier(xGuerrier, yGuerrier)) {
                            System.out.println("Deplacement Impossible. Un autre joueur est sur cette case!");
                        } else if (!isValidHorizontalOrVerticalMove(guerrier, xGuerrier, yGuerrier)) {
                            System.out.println("Deplacement Impossible. Mouvement non valide !");
                        } else {
                            moveGuerrier(guerrier, xGuerrier, yGuerrier);
                            handleCases(xGuerrier, yGuerrier, guerrier);
                            personnage = "Archer";
                            avancementJeu.joueurActuel.setText(archere.getNom());
                            break;
                        }
                    }
                }
            }
        }

        if (personnage.equals("Archer")) {
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 7; j++) {
                    if (e.getSource() == plateau[i][j]) {
                        xArcher = i;
                        yArcher = j;
                        System.out.println(xArcher + " " + yArcher);

                        if (isOccupiedArcher(xArcher, yArcher)) {
                            System.out.println(
                                    "Deplacement Impossible. Un autre joueur est sur cette case!");
                        } else if (!isValidLMove(archere, xArcher, yArcher)) {
                            System.out.println(
                                    "Deplacement Impossible. Mouvement non valide!");
                        } else {
                            moveArcher(archere, xArcher, yArcher);
                            handleCases(xArcher, yArcher, archere);
                            personnage = "Clerc";
                            avancementJeu.joueurActuel.setText("Clerc");
                            break;
                        }
                    }
                }
            }
        }

        if (personnage.equals("Clerc")) {
            performClercTurn();
        }

        verifierVictoire();
    }

    // Fonctions sorciere
    private boolean isOccupiedSorciere(int x, int y) {
        return x == xArcher && y == yArcher || x == xGuerrier && y == yGuerrier || x == xClerc && y == yClerc;
    }

    private boolean isValidDiagonalMove(Personnage sorciere, int newX, int newY) {
        return Math.abs(newX - sorciere.getX()) == 1 && Math.abs(newY - sorciere.getY()) == 1;
    }

    private void moveSorciere(Personnage sorciere, int xSorciere, int ySorciere) {
        plateau[sorciere.getX()][sorciere.getY()].setIcon(new ImageIcon(""));
        sorciere.setX(xSorciere);
        sorciere.setY(ySorciere);
        plateau[xSorciere][ySorciere].setIcon(new ImageIcon(sorcierePlateau));
    }

    // Fonctions guerrier
    private boolean isOccupiedGuerrier(int x, int y) {
        return x == xArcher && y == yArcher || x == xSorciere && y == ySorciere || x == xClerc && y == yClerc;
    }

    private boolean isValidHorizontalOrVerticalMove(Personnage guerrier, int newX, int newY) {
        return (guerrier.getX() == newX && Math.abs(guerrier.getY() - newY) == 1) ||
                (guerrier.getY() == newY && Math.abs(guerrier.getX() - newX) == 1);
    }

    private void moveGuerrier(Personnage guerrier, int newX, int newY) {
        plateau[guerrier.getX()][guerrier.getY()].setIcon(new ImageIcon(""));
        guerrier.setX(xGuerrier);
        guerrier.setY(yGuerrier);
        plateau[xGuerrier][yGuerrier].setIcon(new ImageIcon(guerrierPlateau));
    }

    // Fonctions archer
    private boolean isOccupiedArcher(int x, int y) {
        return x == xGuerrier && y == yGuerrier || x == xSorciere && y == ySorciere || x == xClerc && y == yClerc;
    }

    private boolean isValidLMove(Personnage archere, int newX, int newY) {
        return (Math.abs(archere.getX() - newX) == 2 && Math.abs(archere.getY() - newY) == 1) ||
                (Math.abs(archere.getX() - newX) == 1 && Math.abs(archere.getY() - newY) == 2);
    }

    private void moveArcher(Personnage archere, int newX, int newY) {
        plateau[archere.getX()][archere.getY()].setIcon(new ImageIcon(""));
        archere.setX(xArcher);
        archere.setY(yArcher);
        plateau[xArcher][yArcher].setIcon(new ImageIcon(archerPlateau));
    }

    // Fonctions clerc
    public void performClercTurn() {
        int delay = 5000;
        Timer timer = new Timer(delay, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                List<String> possibleMoves = getPossibleMovesForClerc();
                String move = chooseRandomMove(possibleMoves);
                makeMoveForClerc(move);
                handleCases(xClerc, yClerc, clerc);
                personnage = "Sorcier";
                avancementJeu.joueurActuel.setText(sorciere.getNom());
                ((Timer) evt.getSource()).stop(); // Stop the timer after executing once
            }
        });

        timer.start();
    }

    private List<String> getPossibleMovesForClerc() {
        List<String> moves = new ArrayList<>();
        // Horizontal and Vertical Moves
        if (isValidMove(xClerc, yClerc - 1))
            moves.add("UP");
        if (isValidMove(xClerc, yClerc + 1))
            moves.add("DOWN");
        if (isValidMove(xClerc - 1, yClerc))
            moves.add("LEFT");
        if (isValidMove(xClerc + 1, yClerc))
            moves.add("RIGHT");

        // Diagonal Moves
        if (isValidMove(xClerc - 1, yClerc - 1))
            moves.add("UP_LEFT");
        if (isValidMove(xClerc + 1, yClerc - 1))
            moves.add("UP_RIGHT");
        if (isValidMove(xClerc - 1, yClerc + 1))
            moves.add("DOWN_LEFT");
        if (isValidMove(xClerc + 1, yClerc + 1))
            moves.add("DOWN_RIGHT");

        return moves;
    }

    private String chooseRandomMove(List<String> moves) {
        Random random = new Random();
        return moves.get(random.nextInt(moves.size()));
    }

    private boolean isCellOccupied(int x, int y) {
        return (x == xArcher && y == yArcher) || (x == xGuerrier && y == yGuerrier)
                || (x == xSorciere && y == ySorciere);
    }

    private boolean isValidMove(int x, int y) {
        // Check if the move is within the grid boundaries
        if (x < 0 || x >= 6 || y < 0 || y >= 6) {
            return false;
        }
        // Check if the cell is not occupied by another character
        return !isCellOccupied(x, y);
    }

    private void makeMoveForClerc(String move) {
        switch (move) {
            case "UP":
                yClerc--;
                break;
            case "DOWN":
                yClerc++;
                break;
            case "LEFT":
                xClerc--;
                break;
            case "RIGHT":
                xClerc++;
                break;
            case "UP_LEFT":
                xClerc--;
                yClerc--;
                break;
            case "UP_RIGHT":
                xClerc++;
                yClerc--;
                break;
            case "DOWN_LEFT":
                xClerc--;
                yClerc++;
                break;
            case "DOWN_RIGHT":
                xClerc++;
                yClerc++;
                break;
        }

        updateBoardWithClercPosition();
    }

    private void updateBoardWithClercPosition() {
        plateau[clerc.getX()][clerc.getY()].setIcon(new ImageIcon(""));
        clerc.setX(xClerc);
        clerc.setY(yClerc);
        plateau[xClerc][yClerc].setIcon(new ImageIcon(clercPlateau));
    }

    // Fonction cases
    private void handleCases(int xPersonnage, int yPersonnage, Personnage personnage) {
        if (casess[xPersonnage][yPersonnage].getType().equals("ENIGME")) {
            FenetreCaseEnigme fenetreCase = new FenetreCaseEnigme(avancementJeu, personnage,
                    casess[xPersonnage][yPersonnage], "");
            fenetreCase.setVisible(true);
        } else if (casess[xPersonnage][yPersonnage].getType().equals("CHANCE")
                || casess[xPersonnage][yPersonnage].getType().equals("MALCHANCE")) {
            PopUp fenetreCase = new PopUp(casess[xPersonnage][yPersonnage], personnage, avancementJeu);
            fenetreCase.setVisible(true);
        } else if (casess[xPersonnage][yPersonnage].getType().equals("COMBAT")) {
            FenetreCaseCombat fenetreCase = new FenetreCaseCombat(casess[xPersonnage][yPersonnage],
                    personnage, avancementJeu);
            fenetreCase.setVisible(true);
        }
    }

    private void verifierVictoire() {
        if (sorciere.getPointsDeVie() >= 2000) {
            finJeu(sorciere);
        }

        if (guerrier.getPointsDeVie() >= 2000) {
            finJeu(guerrier);
        }

        if (archere.getPointsDeVie() >= 2000) {
            finJeu(archere);
        }

        if (clerc.getPointsDeVie() >= 2000) {
            finJeu(clerc);
        }
    };

    private void finJeu(Personnage winner) {
        JOptionPane.showMessageDialog(this,
                winner.getNom() + " a gagné la partie avec " + winner.getPointsDeVie() + "PV!", "Fin du Jeu",
                JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}
