package main.java.bibliotheque.logistique;

public class Vehicule {

    private int id;
    private String immatriculation;
    private boolean disponible;

    // Constructeur
    public Vehicule(int id, String immatriculation) {
        if (immatriculation == null || immatriculation.isEmpty()) {
            throw new IllegalArgumentException("L'immatriculation ne peut pas être vide");
        }
        this.id = id;
        this.immatriculation = immatriculation;
        this.disponible = true;
    }

    // Réserver le véhicule
    public void reserver() {
        if (!disponible) {
            System.out.println("Le véhicule " + immatriculation + " est déjà réservé !");
        } else {
            this.disponible = false;
            System.out.println("Véhicule " + immatriculation + " réservé avec succès !");
        }
    }

    // Libérer le véhicule
    public void liberer() {
        if (disponible) {
            System.out.println("Le véhicule " + immatriculation + " est déjà disponible !");
        } else {
            this.disponible = true;
            System.out.println("Véhicule " + immatriculation + " libéré avec succès !");
        }
    }

    // Getters
    public int getId() { return id; }
    public String getImmatriculation() { return immatriculation; }
    public boolean isDisponible() { return disponible; }

    // Setters
    public void setId(int id) { this.id = id; }
    public void setImmatriculation(String immatriculation) { this.immatriculation = immatriculation; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }

    @Override
    public String toString() {
        return "Vehicule{id=" + id +
               ", immatriculation=" + immatriculation +
               ", disponible=" + disponible + "}";
    }
}