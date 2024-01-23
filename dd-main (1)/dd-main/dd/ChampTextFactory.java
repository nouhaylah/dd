import interfaces.ChampTexte;

public class ChampTextFactory {
    public ChampTexte getChampTexte(String type) {
        if (type == null) {
            return null;
        }
        if (type.equalsIgnoreCase("ARRONDI")) {
            return new ChampTexteOval(15);
        } else if (type.equalsIgnoreCase("CARRE")) {
            return new ChampTexteCarre();
        }
        return null;
    }
}