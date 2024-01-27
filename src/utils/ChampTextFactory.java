package src.utils;

public class ChampTextFactory {
    public ChampTexte getChampTexte(String type) {
        if (type == null) {
            return null;
        }
        if (type.equalsIgnoreCase("ARRONDI")) {
            return new ChampTexteArrondi(15);
        } else if (type.equalsIgnoreCase("CARRE")) {
            return new ChampTexteCarre();
        }
        return null;
    }
}