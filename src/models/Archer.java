package src.models;

public final class Archer extends Personnage {
    private static Archer instance;

    private Archer(String name) {
        setPointsDeVie(1000);
        setPuissanceAttaques(150);
        setNom(name);
        setX(6);
        setY(4);
        setType("Archer");
    }

    public static Archer getInstance(String name) {
        if (instance == null) {
            instance = new Archer(name);
        }
        return instance;
    }
}
