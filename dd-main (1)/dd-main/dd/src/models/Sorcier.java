package src.models;

public class Sorcier extends Personnage {
    private static Sorcier instance;

    private Sorcier(String name) {
        setPointsDeVie(1200);
        setPuissanceAttaques(100);
        setNom(name);
        setX(6);
        setY(2);
        setType("Sorcier");
    }

    public static Sorcier getInstance(String name) {
        if (instance == null) {
            instance = new Sorcier(name);
        }
        return instance;
    }
}
