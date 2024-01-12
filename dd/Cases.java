import java.awt.Color;

public class Cases {
    public Case[][] plateau = new Case[7][7];

    public Cases() {
        plateau = new Case[7][7];
        // Remplissage du plateau avec des boutons (vous pouvez personnaliser cela selon
        // vos besoins)
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++)
                // CASES DEPART
                if ((i == 6 && j == 2)) {
                    plateau[i][j] = new Case(i, j, Color.white, "DEPART", "images/sorcierePlateau.png");
                } else if (i == 6 && j == 3) {
                    plateau[i][j] = new Case(i, j, Color.white, "DEPART", "images/guerrierPlateau.png");
                } else if (i == 6 && j == 4) {
                    plateau[i][j] = new Case(i, j, Color.white, "DEPART", "images/archerePlateau.png");
                }
                // CASES CHANCE
                else if ((i == 5 && j == 1) || (i == 5 && j == 5) || (i == 1 && j == 1) || (i == 1 && j == 5)
                        || (i == 3 && j == 3) || (i == 3 && j == 0) || (i == 3 && j == 6)) {
                    if ((i == 5 && j == 1)) {
                        plateau[i][j] = new Case(i, j, "CHANCE", "images/Chancee.png", 50);
                    } else if ((i == 5 && j == 5)) {
                        plateau[i][j] = new Case(i, j, "CHANCE", "images/Chancee.png", 30);
                    } else if ((i == 1 && j == 1)) {
                        plateau[i][j] = new Case(i, j, "CHANCE", "images/Chancee.png", 70);
                    } else if ((i == 1 && j == 5)) {
                        plateau[i][j] = new Case(i, j, "CHANCE", "images/Chancee.png", 55);
                    } else if ((i == 3 && j == 3)) {
                        plateau[i][j] = new Case(i, j, "CHANCE", "images/Chancee.png", 80);
                    } else if ((i == 3 && j == 0)) {
                        plateau[i][j] = new Case(i, j, "CHANCE", "images/Chancee.png", 20);
                    } else if ((i == 3 && j == 6)) {
                        plateau[i][j] = new Case(i, j, "CHANCE", "images/Chancee.png", 30);
                    }
                }
                // CASES MALCHANCE
                else if ((i == 2 && j == 2) || (i == 2 && j == 4) || (i == 4 && j == 2) || (i == 4 && j == 4)
                        || (i == 1 && j == 3) || (i == 5 && j == 3) || (i == 0 && j == 1) || (i == 0 && j == 5)) {
                    if ((i == 2 && j == 2)) {
                        plateau[i][j] = new Case(i, j, "MALCHANCE", "images/Malchancee.png", 50);
                    } else if ((i == 2 && j == 4)) {
                        plateau[i][j] = new Case(i, j, "MALCHANCE", "images/Malchancee.png", 30);
                    } else if ((i == 4 && j == 2)) {
                        plateau[i][j] = new Case(i, j, "MALCHANCE", "images/Malchancee.png", 70);
                    } else if ((i == 4 && j == 4)) {
                        plateau[i][j] = new Case(i, j, "MALCHANCE", "images/Malchancee.png", 55);
                    } else if ((i == 1 && j == 3)) {
                        plateau[i][j] = new Case(i, j, "MALCHANCE", "images/Malchancee.png", 80);
                    } else if ((i == 5 && j == 3)) {
                        plateau[i][j] = new Case(i, j, "MALCHANCE", "images/Malchancee.png", 20);
                    } else if ((i == 0 && j == 1)) {
                        plateau[i][j] = new Case(i, j, "MALCHANCE", "images/Malchancee.png", 30);
                    } else if ((i == 0 && j == 5)) {
                        plateau[i][j] = new Case(i, j, "MALCHANCE", "images/Malchancee.png", 35);
                    }
                }
                // CASES COMBAT
                else if ((i == 2 && j == 3) || (i == 4 && j == 3) || (i == 2 && j == 1) || (i == 4 && j == 5)
                        || (i == 2 && j == 6) || (i == 4 && j == 0)) {
                    plateau[i][j] = new Case(i, j, Color.green, "COMBAT");
                }
                // CASES ENIGME
                else if ((i == 3 && j == 2) || (i == 3 && j == 4) || (i == 4 && j == 1) || (i == 2 && j == 5)
                        || (i == 2 && j == 0) || (i == 4 && j == 6) || (i == 2 && j == 6) || (i == 4 && j == 3)
                        || (i == 3 && j == 1) || (i == 1 && j == 6)) {
                    if (i == 3 && j == 2) {
                        plateau[i][j] = new Case(i, j, Color.blue, "ENIGME", "images/enigmes/Enigme1.png", "COURT", "");
                    } else if (i == 3 && j == 4) {
                        plateau[i][j] = new Case(i, j, Color.blue, "ENIGME", "images/enigmes/Enigme2.png", "PAROLE",
                                "");
                    } else if (i == 4 && j == 1) {
                        plateau[i][j] = new Case(i, j, Color.blue, "ENIGME", "images/enigmes/Enigme3.png", "BOUGIE",
                                "");
                    } else if (i == 2 && j == 5) {
                        plateau[i][j] = new Case(i, j, Color.blue, "ENIGME", "images/enigmes/Enigme4.png", "REVE", "");
                    } else if (i == 2 && j == 0) {
                        plateau[i][j] = new Case(i, j, Color.blue, "ENIGME", "images/enigmes/Enigme5.png", "PIANO", "");
                    } else if (i == 4 && j == 6) {
                        plateau[i][j] = new Case(i, j, Color.blue, "ENIGME", "images/enigmes/Enigme6.png", "ORDINATEUR",
                                "");
                    } else if (i == 2 && j == 6) {
                        plateau[i][j] = new Case(i, j, Color.blue, "ENIGME", "images/enigmes/Enigme7.png",
                                "NOMBRE BINAIRE 0", "");
                    } else if (i == 4 && j == 3) {
                        plateau[i][j] = new Case(i, j, Color.blue, "ENIGME", "images/enigmes/Enigme8.png",
                                "MOT DE PASSE",
                                "");
                    } else if (i == 3 && j == 1) {
                        plateau[i][j] = new Case(i, j, Color.blue, "ENIGME", "images/enigmes/Enigme9.png",
                                "LE NAVIGATEUR TOR",
                                "");
                    } else if (i == 1 && j == 6) {
                        plateau[i][j] = new Case(i, j, Color.blue, "ENIGME", "images/enigmes/Enigme10.png",
                                "LA MATRICE",
                                "");
                    }
                }
                // CASES NEUTRE
                else {
                    plateau[i][j] = new Case(i, j, Color.white, "NEUTRE");
                }
        }
    }

    public Case[][] getPlateau() {
        return plateau;
    }
}
