package Bibliotheque;

import java.util.ArrayList;
import java.util.List;

public class Catalogue {


    private List<Livre> livres;

    
    public Catalogue() {
        this.livres = new ArrayList<>();
    }


    public void ajouterLivre(Livre livre) {
        if (livre == null) {
            System.out.println("Erreur : le livre est invalide !");
            return;
        }
        livres.add(livre);
        System.out.println("Livre ajouté : " + livre.getTitre());
    }

    public void supprimerLivre(int id) {
        Livre livreASupprimer = null;

        for (Livre l : livres) {
            if (l.getId() == id) {
                livreASupprimer = l;
                break;
            }
        }

        if (livreASupprimer != null) {
            livres.remove(livreASupprimer);
            System.out.println("Livre supprimé : " + livreASupprimer.getTitre());
        } else {
            System.out.println("Erreur : aucun livre trouvé avec l'id " + id);
        }
    }

    public Livre rechercherParTitre(String titre) {
        for (Livre l : livres) {
            if (l.getTitre().equalsIgnoreCase(titre)) {
                return l;
            }
        }
        System.out.println("Aucun livre trouvé avec le titre : " + titre);
        return null;
    }

    public Livre rechercherParAuteur(String auteur) {
        for (Livre l : livres) {
            if (l.getAuteur().equalsIgnoreCase(auteur)) {
                return l;
            }
        }
        System.out.println("Aucun livre trouvé avec l'auteur : " + auteur);
        return null;
    }

    public Livre rechercherParISBN(String isbn) {
        for (Livre l : livres) {
            if (l.getIsbn().equalsIgnoreCase(isbn)) {
                return l;
            }
        }
        System.out.println("Aucun livre trouvé avec l'ISBN : " + isbn);
        return null;
    }

    public void afficherTous() {
        if (livres.isEmpty()) {
            System.out.println("Le catalogue est vide.");
            return;
        }
        System.out.println("=== CATALOGUE ===");
        for (Livre l : livres) {
            System.out.println(l);
        }
    }

    public List<Livre> getLivres() {
        return livres;
    }
}
