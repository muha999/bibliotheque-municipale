package Bibliotheque;

import java.util.ArrayList;
import java.util.List;

public class Stock {

    private List<Exemplaire> exemplaires;

     public Stock() {
        this.exemplaires = new ArrayList<>();
    }

    public void ajouterExemplaire(Exemplaire exemplaire) {
        if (exemplaire == null) {
            System.out.println("Erreur : l'exemplaire est invalide !");
            return;
        }
        exemplaires.add(exemplaire);
        System.out.println("Exemplaire ajouté : " + exemplaire.getId());
    }
     public void retirerExemplaire(int id) {
        Exemplaire exemplaireARetirer = null;
        for (Exemplaire e : exemplaires) {
            if (e.getId() == id) {
                exemplaireARetirer = e;
                break;
            }
        }
        if (exemplaireARetirer != null) {
            exemplaires.remove(exemplaireARetirer);
            System.out.println("Exemplaire retiré : " + id);
        } else {
            System.out.println("Erreur : aucun exemplaire trouvé avec l'id " + id);
        }
    }
    public List<Exemplaire> getExemplairesDisponibles() {
        List<Exemplaire> disponibles = new ArrayList<>();
        for (Exemplaire e : exemplaires) {
            if (e.isDisponible()) {
                disponibles.add(e);
            }
        }
        return disponibles;
    }

    public Exemplaire getExemplaireParId(int id) {
        for (Exemplaire e : exemplaires) {
            if (e.getId() == id) {
                return e;
            }
        }
        System.out.println("Aucun exemplaire trouvé avec l'id : " + id);
        return null;
    }

    public void afficherTous() {
        if (exemplaires.isEmpty()) {
            System.out.println("Le stock est vide.");
            return;
        }
        System.out.println("=== STOCK ===");
        for (Exemplaire e : exemplaires) {
            System.out.println(e);
        }
    }


    public List<Exemplaire> getExemplaires() {
        return exemplaires;
    }
}
