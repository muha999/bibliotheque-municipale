package Bibliotheque;

public class Exemplaire {

    // --- Les états possibles d'un exemplaire ---
    public enum Etat {
        NEUF, BON, ABIME
    }

    // --- Les attributs ---
    private int id;
    private int livreId;
    private Etat etat;
    private boolean disponible;
    private String localisation;

    // --- Le constructeur ---
    public Exemplaire(int id, int livreId, Etat etat, String localisation) {
        this.id = id;
        this.livreId = livreId;
        this.etat = etat;
        this.disponible = true; // par défaut, un exemplaire est disponible
        this.localisation = localisation;
    }

    // --- Les Getters ---
    public int getId() { return id; }
    public int getLivreId() { return livreId; }
    public Etat getEtat() { return etat; }
    public boolean isDisponible() { return disponible; }
    public String getLocalisation() { return localisation; }

    // --- Les Setters ---
    public void setEtat(Etat etat) {
        if (etat == null) {
            System.out.println("Erreur : l'état ne peut pas être vide !");
        } else {
            this.etat = etat;
        }
    }

    public void setLocalisation(String localisation) {
        if (localisation == null || localisation.isEmpty()) {
            System.out.println("Erreur : la localisation ne peut pas être vide !");
        } else {
            this.localisation = localisation;
        }
    }

    // --- Méthodes spéciales ---
    public void marquerDisponible() {
        this.disponible = true;
        System.out.println("Exemplaire " + id + " est maintenant disponible.");
    }

    public void marquerIndisponible() {
        this.disponible = false;
        System.out.println("Exemplaire " + id + " est maintenant indisponible.");
    }

    // --- toString ---
    @Override
    public String toString() {
        return "Exemplaire{" +
               "id=" + id +
               ", livreId=" + livreId +
               ", etat=" + etat +
               ", disponible=" + disponible +
               ", localisation='" + localisation + '\'' +
               '}';
    }
}