package src.models;

public class Clerc extends Personnage {
    private static Clerc instance;

    private Clerc(String name) {
        setPointsDeVie(1000);
        setPuissanceAttaques(50);
        setNom(name);
        setX(6);
        setY(5);
        setType("Clerc");
    }

    public static Clerc getInstance(String name) {
        if (instance == null) {
            instance = new Clerc(name);
        }
        return instance;
    }
}
