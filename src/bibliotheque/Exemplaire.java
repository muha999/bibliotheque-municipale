public class Exemplaire {

    private int id;
    private Livre livre;
    private String etat;
    private boolean disponible;
    private String localisation;

    public Exemplaire(int id, Livre livre, String etat, boolean disponible, String localisation) {
        this.id = id;
        this.livre = livre;
        this.etat = etat;
        this.disponible = disponible;
        this.localisation = localisation;
    }

    public int getId() { return id; }
    public Livre getLivre() { return livre; }
    public String getEtat() { return etat; }
    public boolean isDisponible() { return disponible; }
    public String getLocalisation() { return localisation; }

    public void setDisponible(boolean disponible) { this.disponible = disponible; }
    public void setEtat(String etat) { this.etat = etat; }
    public void setLocalisation(String localisation) { this.localisation = localisation; }

    @Override
    public String toString() {
        return "Exemplaire{" +
               "id=" + id +
               ", livre='" + livre.getTitre() + '\'' +
               ", etat=" + etat +
               ", disponible=" + disponible +
               ", localisation='" + localisation + '\'' +
               '}';
    }
}
