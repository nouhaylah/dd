import javax.swing.*;
import actions.TourManager;
import models.Archer;
import models.Clerc;
import models.Guerrier;
import models.Personnage;
import models.Sorcier;
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
                        if ((xSorciere == xArcher && ySorciere == yArcher)
                                || (xSorciere == xGuerrier && ySorciere == yGuerrier)
                                || (xSorciere == xClerc && ySorciere == yClerc)
                                || (sorciere.getX() == 5 && xSorciere == 6
                                        && (sorciere.getY() == ySorciere + 1 || sorciere.getY() == ySorciere - 1))) {
                            System.out.println("Deplacement Impossible. Un autre joueur est sur cette case");
                        } else if (sorciere.getX() == 6 && xSorciere == 5
                                && (sorciere.getY() == ySorciere + 1 || sorciere.getY() == ySorciere - 1)) {
                            System.out.println("sorciere");
                            plateau[sorciere.getX()][sorciere.getY()].setIcon(new ImageIcon(""));
                            sorciere.setX(xSorciere);
                            sorciere.setY(ySorciere);
                            plateau[xSorciere][ySorciere].setIcon(new ImageIcon("images\\sorcierePlateau.png"));
                            if (casess[xSorciere][ySorciere].getType().equals("ENIGME")) {
                                FenetreCaseEnigme fenetreCase = new FenetreCaseEnigme(avancementJeu, sorciere,
                                        casess[xSorciere][ySorciere], "");
                                fenetreCase.setVisible(true);
                            } else if (casess[xSorciere][ySorciere].getType().equals("CHANCE")
                                    || casess[xSorciere][ySorciere].getType().equals("MALCHANCE")) {
                                PopUp fenetreCase = new PopUp(casess[xSorciere][ySorciere], sorciere, avancementJeu);
                                fenetreCase.setVisible(true);
                            } else if (casess[xSorciere][ySorciere].getType().equals("COMBAT")) {
                                FenetreCaseCombat fenetreCase = new FenetreCaseCombat(casess[xSorciere][ySorciere],
                                        sorciere, avancementJeu);
                                fenetreCase.setVisible(true);
                            }
                            personnage = "Guerrier";
                            avancementJeu.joueurActuel.setText(guerrier.getNom());
                            break;
                        } else if (sorciere.getX() < 6
                                && (xSorciere == sorciere.getX() + 1 || xSorciere == sorciere.getX() - 1)
                                && (sorciere.getY() == ySorciere + 1 || sorciere.getY() == ySorciere - 1)) {
                            System.out.println("sorciere");
                            plateau[sorciere.getX()][sorciere.getY()].setIcon(new ImageIcon(""));
                            sorciere.setX(xSorciere);
                            sorciere.setY(ySorciere);
                            plateau[xSorciere][ySorciere].setIcon(new ImageIcon("images\\sorcierePlateau.png"));
                            if (casess[xSorciere][ySorciere].getType().equals("ENIGME")) {
                                FenetreCaseEnigme fenetreCase = new FenetreCaseEnigme(avancementJeu, sorciere,
                                        casess[xSorciere][ySorciere], "");
                                fenetreCase.setVisible(true);
                            } else if (casess[xSorciere][ySorciere].getType().equals("CHANCE")
                                    || casess[xSorciere][ySorciere].getType().equals("MALCHANCE")) {
                                PopUp fenetreCase = new PopUp(casess[xSorciere][ySorciere], sorciere, avancementJeu);
                                fenetreCase.setVisible(true);
                            } else if (casess[xSorciere][ySorciere].getType().equals("COMBAT")) {
                                FenetreCaseCombat fenetreCase = new FenetreCaseCombat(casess[xSorciere][ySorciere],
                                        sorciere, avancementJeu);
                                fenetreCase.setVisible(true);
                            }
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
                        if ((xGuerrier == xArcher && yGuerrier == yArcher)
                                || (xGuerrier == xSorciere && yGuerrier == ySorciere)
                                || (xGuerrier == xClerc && yGuerrier == yClerc)) {
                            System.out.println("Deplacement Impossible. Un autre joueur est sur cette case");
                        } else if (guerrier.getX() == 5 && xGuerrier == 6 && guerrier.getY() == yGuerrier) {
                            System.out.println("deplacement impossible");
                        } else if (guerrier.getX() == 6 && xGuerrier == 5 && guerrier.getY() == yGuerrier) {
                            System.out.println("guerrier");
                            plateau[guerrier.getX()][guerrier.getY()].setIcon(new ImageIcon(""));
                            guerrier.setX(xGuerrier);
                            guerrier.setY(yGuerrier);
                            plateau[xGuerrier][yGuerrier].setIcon(new ImageIcon("images\\guerrierPlateau.png"));
                            if (casess[xGuerrier][yGuerrier].getType().equals("ENIGME")) {
                                FenetreCaseEnigme fenetreCase = new FenetreCaseEnigme(avancementJeu, guerrier,
                                        casess[xGuerrier][yGuerrier], "");
                                fenetreCase.setVisible(true);
                            } else if (casess[xGuerrier][yGuerrier].getType().equals("CHANCE")
                                    || casess[xGuerrier][yGuerrier].getType().equals("MALCHANCE")) {
                                PopUp fenetreCase = new PopUp(casess[xGuerrier][yGuerrier], guerrier, avancementJeu);
                                fenetreCase.setVisible(true);
                            } else if (casess[xGuerrier][yGuerrier].getType().equals("COMBAT")) {
                                FenetreCaseCombat fenetreCase = new FenetreCaseCombat(casess[xGuerrier][yGuerrier],
                                        guerrier, avancementJeu);
                                fenetreCase.setVisible(true);
                            }
                            personnage = "Archer";
                            avancementJeu.joueurActuel.setText(archere.getNom());
                            break;
                        } else if (guerrier.getX() < 6
                                && (xGuerrier == guerrier.getX() + 1 || xGuerrier == guerrier.getX() - 1)
                                && guerrier.getY() == yGuerrier) {
                            System.out.println("guerrier");
                            plateau[guerrier.getX()][guerrier.getY()].setIcon(new ImageIcon(""));
                            guerrier.setX(xGuerrier);
                            guerrier.setY(yGuerrier);
                            plateau[xGuerrier][yGuerrier].setIcon(new ImageIcon("images\\guerrierPlateau.png"));
                            if (casess[xGuerrier][yGuerrier].getType().equals("ENIGME")) {
                                FenetreCaseEnigme fenetreCase = new FenetreCaseEnigme(avancementJeu, guerrier,
                                        casess[xGuerrier][yGuerrier], "");
                                fenetreCase.setVisible(true);
                            } else if (casess[xGuerrier][yGuerrier].getType().equals("CHANCE")
                                    || casess[xGuerrier][yGuerrier].getType().equals("MALCHANCE")) {
                                PopUp fenetreCase = new PopUp(casess[xGuerrier][yGuerrier], guerrier, avancementJeu);
                                fenetreCase.setVisible(true);
                            } else if (casess[xGuerrier][yGuerrier].getType().equals("COMBAT")) {
                                FenetreCaseCombat fenetreCase = new FenetreCaseCombat(casess[xGuerrier][yGuerrier],
                                        guerrier, avancementJeu);
                                fenetreCase.setVisible(true);
                            }
                            personnage = "Archer";
                            avancementJeu.joueurActuel.setText(archere.getNom());
                            break;
                        } else if (guerrier.getX() < 6
                                && (yGuerrier == guerrier.getY() + 1 || yGuerrier == guerrier.getY() - 1)
                                && guerrier.getX() == xGuerrier) {
                            System.out.println("guerrier");
                            plateau[guerrier.getX()][guerrier.getY()].setIcon(new ImageIcon(""));
                            guerrier.setX(xGuerrier);
                            guerrier.setY(yGuerrier);
                            plateau[xGuerrier][yGuerrier].setIcon(new ImageIcon("images\\guerrierPlateau.png"));
                            if (casess[xGuerrier][yGuerrier].getType().equals("ENIGME")) {
                                FenetreCaseEnigme fenetreCase = new FenetreCaseEnigme(avancementJeu, guerrier,
                                        casess[xGuerrier][yGuerrier], "");
                                fenetreCase.setVisible(true);
                            } else if (casess[xGuerrier][yGuerrier].getType().equals("CHANCE")
                                    || casess[xGuerrier][yGuerrier].getType().equals("MALCHANCE")) {
                                PopUp fenetreCase = new PopUp(casess[xGuerrier][yGuerrier], guerrier, avancementJeu);
                                fenetreCase.setVisible(true);
                            } else if (casess[xGuerrier][yGuerrier].getType().equals("COMBAT")) {
                                FenetreCaseCombat fenetreCase = new FenetreCaseCombat(casess[xGuerrier][yGuerrier],
                                        guerrier, avancementJeu);
                                fenetreCase.setVisible(true);
                            }
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
                        if ((xArcher == xGuerrier && yArcher == yGuerrier)
                                || (xArcher == xSorciere && yArcher == ySorciere)
                                || (xArcher == xClerc && yArcher == yClerc)) {
                            System.out.println("Deplacement Impossible. Un autre joueur est sur cette case");
                        } else if (archere.getX() == 5 && xArcher == 6) {
                            System.out
                                    .println(
                                            "Deplacement Impossible. Vous ne pouvez pas revenir sur votre case de depart");
                        } else if ((archere.getX() == 6 && xArcher == 5
                                && (archere.getY() == yArcher + 2 || archere.getY() == yArcher - 2))
                                || (archere.getX() == 6 && xArcher == 4
                                        && (archere.getY() == yArcher + 1 || archere.getY() == yArcher - 1))) {
                            System.out.println("archer");
                            plateau[archere.getX()][archere.getY()].setIcon(new ImageIcon(""));
                            archere.setX(xArcher);
                            archere.setY(yArcher);
                            plateau[xArcher][yArcher].setIcon(new ImageIcon("images\\archerePlateau.png"));
                            if (casess[xArcher][yArcher].getType().equals("ENIGME")) {
                                FenetreCaseEnigme fenetreCase = new FenetreCaseEnigme(avancementJeu, archere,
                                        casess[xArcher][yArcher], "");
                                fenetreCase.setVisible(true);
                            } else if (casess[xArcher][yArcher].getType().equals("CHANCE")
                                    || casess[xArcher][yArcher].getType().equals("MALCHANCE")) {
                                PopUp fenetreCase = new PopUp(casess[xArcher][yArcher], archere, avancementJeu);
                                fenetreCase.setVisible(true);
                            } else if (casess[xArcher][yArcher].getType().equals("COMBAT")) {
                                FenetreCaseCombat fenetreCase = new FenetreCaseCombat(casess[xArcher][yArcher],
                                        archere, avancementJeu);
                                fenetreCase.setVisible(true);
                            }
                            personnage = "Clerc";
                            avancementJeu.joueurActuel.setText("Clerc");
                            break;
                        } else if (archere.getX() < 6
                                && (xArcher == archere.getX() + 1 || xArcher == archere.getX() - 1)
                                && (archere.getY() == yArcher + 2 || archere.getY() == yArcher - 2)) {

                            System.out.println("archer");
                            plateau[archere.getX()][archere.getY()].setIcon(new ImageIcon(""));
                            archere.setX(xArcher);
                            archere.setY(yArcher);
                            plateau[xArcher][yArcher].setIcon(new ImageIcon("images\\archerePlateau.png"));
                            if (casess[xArcher][yArcher].getType().equals("ENIGME")) {
                                FenetreCaseEnigme fenetreCase = new FenetreCaseEnigme(avancementJeu, archere,
                                        casess[xArcher][yArcher], "");
                                fenetreCase.setVisible(true);
                            } else if (casess[xArcher][yArcher].getType().equals("CHANCE")
                                    || casess[xArcher][yArcher].getType().equals("MALCHANCE")) {
                                PopUp fenetreCase = new PopUp(casess[xArcher][yArcher], archere, avancementJeu);
                                fenetreCase.setVisible(true);
                            } else if (casess[xArcher][yArcher].getType().equals("COMBAT")) {
                                FenetreCaseCombat fenetreCase = new FenetreCaseCombat(casess[xArcher][yArcher],
                                        archere, avancementJeu);
                                fenetreCase.setVisible(true);
                            }
                            personnage = "Clerc";
                            avancementJeu.joueurActuel.setText("Clerc");
                            break;
                        } else if (archere.getX() < 6
                                && (xArcher == archere.getX() + 2 || xArcher == archere.getX() - 2)
                                && (archere.getY() == yArcher + 1 || archere.getY() == yArcher - 1)) {
                            System.out.println("archer");
                            plateau[archere.getX()][archere.getY()].setIcon(new ImageIcon(""));
                            archere.setX(xArcher);
                            archere.setY(yArcher);
                            plateau[xArcher][yArcher].setIcon(new ImageIcon("images\\archerePlateau.png"));
                            if (casess[xArcher][yArcher].getType().equals("ENIGME")) {
                                FenetreCaseEnigme fenetreCase = new FenetreCaseEnigme(avancementJeu, archere,
                                        casess[xArcher][yArcher], "");
                                fenetreCase.setVisible(true);
                            } else if (casess[xArcher][yArcher].getType().equals("CHANCE")
                                    || casess[xArcher][yArcher].getType().equals("MALCHANCE")) {
                                PopUp fenetreCase = new PopUp(casess[xArcher][yArcher], archere, avancementJeu);
                                fenetreCase.setVisible(true);
                            } else if (casess[xArcher][yArcher].getType().equals("COMBAT")) {
                                FenetreCaseCombat fenetreCase = new FenetreCaseCombat(casess[xArcher][yArcher],
                                        archere, avancementJeu);
                                fenetreCase.setVisible(true);
                            }
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

    public void performClercTurn() {
        int delay = 5000;
        Timer timer = new Timer(delay, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                List<String> possibleMoves = getPossibleMovesForClerc();
                String move = chooseRandomMove(possibleMoves);
                makeMoveForClerc(move);
                handleCasesClerc();
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

    private void handleCasesClerc() {
        if (casess[xClerc][yClerc].getType().equals("ENIGME")) {
            FenetreCaseEnigme fenetreCase = new FenetreCaseEnigme(avancementJeu, clerc,
                    casess[xClerc][yClerc], "");
            fenetreCase.setVisible(true);
        } else if (casess[xClerc][yClerc].getType().equals("CHANCE")
                || casess[xClerc][yClerc].getType().equals("MALCHANCE")) {
            PopUp fenetreCase = new PopUp(casess[xClerc][yClerc], clerc, avancementJeu);
            fenetreCase.setVisible(true);
        } else if (casess[xClerc][yClerc].getType().equals("COMBAT")) {
            FenetreCaseCombat fenetreCase = new FenetreCaseCombat(casess[xClerc][yClerc],
                    clerc, avancementJeu);
            fenetreCase.setVisible(true);
        }
    }

    private void updateBoardWithClercPosition() {
        plateau[clerc.getX()][clerc.getY()].setIcon(new ImageIcon(""));
        clerc.setX(xClerc);
        clerc.setY(yClerc);
        plateau[xClerc][yClerc].setIcon(new ImageIcon("images\\clercPlateau.png"));
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
