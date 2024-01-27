package src.controllers;

import java.awt.Color;
import java.util.Arrays;
import java.util.ArrayList;

public class Cases {
    public Case[][] plateau = new Case[7][7];

    private static final String sorcierePlateau = "src\\resources\\sorcierePlateau.png";
    private static final String guerrierPlateau = "src\\resources\\guerrierPlateau.png";
    private static final String archerePlateau = "src\\resources\\archerePlateau.png";
    private static final String clercPlateau = "src\\resources\\clercPlateau.png";
    private static final String pathImgChance = "src\\resources\\Chancee.png";
    private static final String pathImgMalchance = "src\\resources\\Malchancee.png";

    private static final String caseTypeDepart = "DEPART";
    private static final String caseTypeChance = "CHANCE";
    private static final String caseTypeMalchance = "MALCHANCE";
    private static final String caseTypeCombat = "COMBAT";
    private static final String caseTypeEnigme = "ENIGME";
    private static final String caseTypeNeutre = "NEUTRE";

    private static final ArrayList<String> enigmePaths = new ArrayList<>(
            Arrays.asList("src\\resources\\enigmes\\Enigme1.png",
                    "src\\resources\\enigmes\\Enigme2.png",
                    "src\\resources\\enigmes\\Enigme3.png",
                    "src\\resources\\enigmes\\Enigme4.png",
                    "src\\resources\\enigmes\\Enigme5.png",
                    "src\\resources\\enigmes\\Enigme6.png",
                    "src\\resources\\enigmes\\Enigme7.png",
                    "src\\resources\\enigmes\\Enigme8.png",
                    "src\\resources\\enigmes\\Enigme9.png",
                    "src\\resources\\enigmes\\Enigme10.png"));

    private static final ArrayList<String> enigmeReponses = new ArrayList<>(
            Arrays.asList("COURT",
                    "PAROLE",
                    "BOUGIE",
                    "REVE",
                    "PIANO",
                    "ORDINATEUR",
                    "NOMBRE BINAIRE 0",
                    "MOT DE PASSE",
                    "LE NAVIGATEUR TOR",
                    "LA MATRICE"));

    public Cases() {
        plateau = new Case[7][7];
        // Remplissage du plateau avec des boutons (vous pouvez personnaliser cela selon
        // vos besoins)
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++)
                // CASES DEPART
                if ((i == 6 && j == 2)) {
                    plateau[i][j] = new Case(i, j, Color.white, caseTypeDepart, sorcierePlateau);
                } else if (i == 6 && j == 3) {
                    plateau[i][j] = new Case(i, j, Color.white, caseTypeDepart, guerrierPlateau);
                } else if (i == 6 && j == 4) {
                    plateau[i][j] = new Case(i, j, Color.white, caseTypeDepart, archerePlateau);
                } else if (i == 6 && j == 5) {
                    plateau[i][j] = new Case(i, j, Color.white, caseTypeDepart, clercPlateau);
                }

                // CASES CHANCE
                else if ((i == 5 && j == 1) || (i == 5 && j == 5) || (i == 1 && j == 1) || (i == 1 && j == 5)
                        || (i == 3 && j == 3) || (i == 3 && j == 0) || (i == 3 && j == 6)) {
                    if ((i == 5 && j == 1)) {
                        plateau[i][j] = new Case(i, j, caseTypeChance, pathImgChance, 50);
                    } else if ((i == 5 && j == 5)) {
                        plateau[i][j] = new Case(i, j, caseTypeChance, pathImgChance, 300);
                    } else if ((i == 1 && j == 1)) {
                        plateau[i][j] = new Case(i, j, caseTypeChance, pathImgChance, 70);
                    } else if ((i == 1 && j == 5)) {
                        plateau[i][j] = new Case(i, j, caseTypeChance, pathImgChance, 55);
                    } else if ((i == 3 && j == 3)) {
                        plateau[i][j] = new Case(i, j, caseTypeChance, pathImgChance, 80);
                    } else if ((i == 3 && j == 0)) {
                        plateau[i][j] = new Case(i, j, caseTypeChance, pathImgChance, 20);
                    } else if ((i == 3 && j == 6)) {
                        plateau[i][j] = new Case(i, j, caseTypeChance, pathImgChance, 30);
                    }
                }
                // CASES MALCHANCE
                else if ((i == 2 && j == 2) || (i == 2 && j == 4) || (i == 4 && j == 2) || (i == 4 && j == 4)
                        || (i == 1 && j == 3) || (i == 5 && j == 3) || (i == 0 && j == 1) || (i == 0 && j == 5)) {
                    if ((i == 2 && j == 2)) {
                        plateau[i][j] = new Case(i, j, caseTypeMalchance, pathImgMalchance, 50);
                    } else if ((i == 2 && j == 4)) {
                        plateau[i][j] = new Case(i, j, caseTypeMalchance, pathImgMalchance, 30);
                    } else if ((i == 4 && j == 2)) {
                        plateau[i][j] = new Case(i, j, caseTypeMalchance, pathImgMalchance, 70);
                    } else if ((i == 4 && j == 4)) {
                        plateau[i][j] = new Case(i, j, caseTypeMalchance, pathImgMalchance, 55);
                    } else if ((i == 1 && j == 3)) {
                        plateau[i][j] = new Case(i, j, caseTypeMalchance, pathImgMalchance, 80);
                    } else if ((i == 5 && j == 3)) {
                        plateau[i][j] = new Case(i, j, caseTypeMalchance, pathImgMalchance, 20);
                    } else if ((i == 0 && j == 1)) {
                        plateau[i][j] = new Case(i, j, caseTypeMalchance, pathImgMalchance, 30);
                    } else if ((i == 0 && j == 5)) {
                        plateau[i][j] = new Case(i, j, caseTypeMalchance, pathImgMalchance, 35);
                    }
                }
                // CASES COMBAT
                else if ((i == 2 && j == 3) || (i == 4 && j == 3) || (i == 2 && j == 1) || (i == 4 && j == 5)
                        || (i == 2 && j == 6) || (i == 4 && j == 0)) {
                    plateau[i][j] = new Case(i, j, Color.GREEN, caseTypeCombat);
                }
                // CASES ENIGME
                else if ((i == 3 && j == 2) || (i == 3 && j == 4) || (i == 4 && j == 1) || (i == 2 && j == 5)
                        || (i == 2 && j == 0) || (i == 4 && j == 6) || (i == 2 && j == 6) || (i == 4 && j == 3)
                        || (i == 3 && j == 1) || (i == 1 && j == 6)) {
                    if (i == 3 && j == 2) {
                        plateau[i][j] = new Case(i, j, Color.BLUE, caseTypeEnigme,
                                enigmePaths.get(0),
                                enigmeReponses.get(0));
                    } else if (i == 3 && j == 4) {
                        plateau[i][j] = new Case(i, j, Color.BLUE, caseTypeEnigme,
                                enigmePaths.get(1),
                                enigmeReponses.get(1));
                    } else if (i == 4 && j == 1) {
                        plateau[i][j] = new Case(i, j, Color.BLUE, caseTypeEnigme,
                                enigmePaths.get(2),
                                enigmeReponses.get(2));
                    } else if (i == 2 && j == 5) {
                        plateau[i][j] = new Case(i, j, Color.BLUE, caseTypeEnigme,
                                enigmePaths.get(3),
                                enigmeReponses.get(3));
                    } else if (i == 2 && j == 0) {
                        plateau[i][j] = new Case(i, j, Color.BLUE, caseTypeEnigme,
                                enigmePaths.get(4),
                                enigmeReponses.get(4));
                    } else if (i == 4 && j == 6) {
                        plateau[i][j] = new Case(i, j, Color.BLUE, caseTypeEnigme,
                                enigmePaths.get(5),
                                enigmeReponses.get(5));
                    } else if (i == 2 && j == 6) {
                        plateau[i][j] = new Case(i, j, Color.BLUE, caseTypeEnigme,
                                enigmePaths.get(6),
                                enigmeReponses.get(6));
                    } else if (i == 4 && j == 3) {
                        plateau[i][j] = new Case(i, j, Color.BLUE, caseTypeEnigme,
                                enigmePaths.get(7),
                                enigmeReponses.get(7));
                    } else if (i == 3 && j == 1) {
                        plateau[i][j] = new Case(i, j, Color.BLUE, caseTypeEnigme,
                                enigmePaths.get(8),
                                enigmeReponses.get(8));
                    } else if (i == 1 && j == 6) {
                        plateau[i][j] = new Case(i, j, Color.BLUE, caseTypeEnigme,
                                enigmePaths.get(9),
                                enigmeReponses.get(9));
                    }
                }
                // CASES NEUTRE
                else {
                    plateau[i][j] = new Case(i, j, Color.white, caseTypeNeutre);
                }
        }
    }

    public Case[][] getPlateau() {
        return plateau;
    }
}
