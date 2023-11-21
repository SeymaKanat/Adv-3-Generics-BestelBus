package model;

public class Pakket  implements Weegbaar{

    private String naamVanKind;
    private String cadeau;
    private int gewicht;

    public Pakket(String naamVanKind, String cadeau, int gewicht) {
        this.naamVanKind = naamVanKind;
        this.cadeau = cadeau;
        this.gewicht = gewicht;
    }

    public int getGewicht() {
        return gewicht;
    }

    public boolean kanWordenGeladen() {
        return gewicht >= 0; // Pakket kan worden geladen als het gewicht niet negatief is
    }

    @Override
    public String toString() {
        return String.format("{Kind: %s; cadeau: %s; gewicht: %d}", naamVanKind, cadeau, gewicht);
    }
}
