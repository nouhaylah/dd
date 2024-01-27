package src.controllers;

import src.models.Personnage;

public class PointsDeVieManager implements PointsDeVieManagerInterface {

    @Override
    public boolean augmenterPoints(Personnage perso, int points) {
        perso.setPointsDeVie(perso.getPointsDeVie() + points);
        return true;
    }

    @Override
    public boolean diminuerPoints(Personnage perso, int points) {
        perso.setPointsDeVie(perso.getPointsDeVie() - points);
        return true;
    }

}
