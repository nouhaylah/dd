package actions;

import models.Personnage;

public class PointsDeVieManager implements PointsDeVieManagerInterface {

    @Override
    public boolean augmenterPoints(Personnage perso, int points) {
        perso.setPointsDeVie(perso.getPointsDeVie()+points);
        return true;
        //throw new UnsupportedOperationException("Unimplemented method 'augmenterPoints'");
    }

    @Override
    public boolean diminuerPoints(Personnage perso, int points) {
        perso.setPointsDeVie(perso.getPointsDeVie() - points);
        return true;
        //throw new UnsupportedOperationException("Unimplemented method 'diminuerPoints'");
    }
    
}
