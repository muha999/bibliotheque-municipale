package main.java.bibliotheque.gestion;

import java.time.LocalDate;

public class Amende {
    
    private int id;
    private double montant;
    private boolean payee;
    private LocalDate dateAmende;
    private int nbJoursRetard;

    // Constructeur
    public Amende(int id, int nbJoursRetard) {
        if (nbJoursRetard < 0) {
            throw new IllegalArgumentException("Le nombre de jours de retard ne peut pas être négatif");
        }
        this.id = id;
        this.nbJoursRetard = nbJoursRetard;
        this.montant = calculerMontant(nbJoursRetard);
        this.payee = false;
        this.dateAmende = LocalDate.now();
    }

    // Calcul automatique : 0.50€ par jour de retard
    public double calculerMontant(int nbJoursRetard) {
        return nbJoursRetard * 0.50;
    }

    // Payer l'amende
    public void payer() {
        if (payee) {
            System.out.println("Cette amende est déjà payée !");
        } else {
            this.payee = true;
            System.out.println("Amende de " + montant + "€ payée avec succès !");
        }
    }

    // Getters
    public int getId() { return id; }
    public double getMontant() { return montant; }
    public boolean isPayee() { return payee; }
    public LocalDate getDateAmende() { return dateAmende; }
    public int getNbJoursRetard() { return nbJoursRetard; }

    // Setters
    public void setId(int id) { this.id = id; }
    public void setMontant(double montant) { this.montant = montant; }

    @Override
    public String toString() {
        return "Amende{id=" + id + 
               ", montant=" + montant + "€" +
               ", payee=" + payee + 
               ", date=" + dateAmende + 
               ", joursRetard=" + nbJoursRetard + "}";
    }
}