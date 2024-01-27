package src.models;

public final class Guerrier extends Personnage {
    private static Guerrier instance;

    private Guerrier(String name) {
        setPointsDeVie(1400);
        setPuissanceAttaques(50);
        setNom(name);
        setX(6);
        setY(3);
        setType("Guerrier");
    }

    public static Guerrier getInstance(String name) {
        if (instance == null) {
            instance = new Guerrier(name);
        }
        return instance;
    }
}
