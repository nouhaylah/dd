package actions;

import models.Personnage;

public interface PointsDeVieManagerInterface {
    public boolean augmenterPoints(Personnage perso,int points);
    public boolean diminuerPoints(Personnage perso,int points);

}
