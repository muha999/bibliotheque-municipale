package main.java.bibliotheque.gestion;

import java.util.ArrayList;
import java.util.List;

public class Caisse {

    private double solde;
    private List<Amende> amendes;

    // Constructeur
    public Caisse() {
        this.solde = 0.0;
        this.amendes = new ArrayList<>();
    }

    // Ajouter une amende sans la payer
    public void ajouterAmende(Amende amende) {
        if (amende == null) {
            throw new IllegalArgumentException("L'amende ne peut pas être nulle");
        }
        this.amendes.add(amende);
        System.out.println("Amende ajoutée : " + amende);
    }

    // Encaisser une amende existante
    public void encaisserAmende(Amende amende) {
        if (amende == null) {
            throw new IllegalArgumentException("L'amende ne peut pas être nulle");
        }
        if (amende.isPayee()) {
            System.out.println("Cette amende est déjà payée !");
            return;
        }
        amende.payer();
        this.solde += amende.getMontant();
        System.out.println("Caisse mise à jour. Nouveau solde : " + solde + "€");
    }

    // Obtenir les amendes impayées
    public List<Amende> getAmendesImpayees() {
        List<Amende> impayees = new ArrayList<>();
        for (Amende a : amendes) {
            if (!a.isPayee()) {
                impayees.add(a);
            }
        }
        return impayees;
    }

    // Afficher tout l'historique
    public void afficherHistorique() {
        if (amendes.isEmpty()) {
            System.out.println("Aucune amende enregistrée.");
            return;
        }
        System.out.println("=== Historique des amendes ===");
        for (Amende a : amendes) {
            System.out.println(a);
        }
        System.out.println("Solde total : " + solde + "€");
    }

    // Getters
    public double getSolde() { return solde; }
    public List<Amende> getAmendes() { return amendes; }

    @Override
    public String toString() {
        return "Caisse{solde=" + solde + "€, nombreAmendes=" + amendes.size() + "}";
    }
}