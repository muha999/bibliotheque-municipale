import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        separateur("DÉMARRAGE DU SYSTÈME — Bibliothèque Municipale");

        // ============================================================
        // ÉTAPE 1 : Création du catalogue et ajout de livres
        // ============================================================
        separateur("ÉTAPE 1 : Ajout des livres au catalogue");

        Catalogue catalogue = new Catalogue();
        Stock stock = new Stock();

        Livre livre1 = new Livre("978-2-07-036024-5", "Le Petit Prince",
                "Antoine de Saint-Exupéry", "Roman", 1943);
        Livre livre2 = new Livre("978-2-07-040850-4", "L'Étranger",
                "Albert Camus", "Roman", 1942);
        Livre livre3 = new Livre("978-2-07-036822-7", "Les Misérables",
                "Victor Hugo", "Roman historique", 1862);

        catalogue.ajouterLivre(livre1);
        catalogue.ajouterLivre(livre2);
        catalogue.ajouterLivre(livre3);

        System.out.println("📚 Livres ajoutés au catalogue :");
        catalogue.afficherTousLesLivres();

        Exemplaire ex1 = new Exemplaire(1, livre1, "NEUF", true, "Annexe A");
        Exemplaire ex2 = new Exemplaire(2, livre1, "BON", true, "Annexe B");
        Exemplaire ex3 = new Exemplaire(3, livre2, "ABIME", true, "Annexe A");
        Exemplaire ex4 = new Exemplaire(4, livre3, "BON", true, "Annexe A");

        stock.ajouterExemplaire(ex1);
        stock.ajouterExemplaire(ex2);
        stock.ajouterExemplaire(ex3);
        stock.ajouterExemplaire(ex4);

        System.out.println("\n📦 Exemplaires disponibles pour '" + livre1.getTitre() + "' :");
        List<Exemplaire> disponibles = stock.getExemplairesDisponibles(livre1);
        for (Exemplaire e : disponibles) {
            System.out.println("  → " + e);
        }
        System.out.println("  Nombre total : " + stock.getNombreTotal(livre1));

        // ============================================================
        // ÉTAPE 2 : Ajout des membres
        // ============================================================
        separateur("ÉTAPE 2 : Ajout des membres");

        Membre membre1 = new Membre(1, "Diallo", "Mamadou", "mamadou.diallo@email.sn");
        Membre membre2 = new Membre(2, "Ndiaye", "Fatou", "fatou.ndiaye@email.sn");

        System.out.println("👤 Membres enregistrés :");
        System.out.println("  → " + membre1);
        System.out.println("  → " + membre2);

        // ============================================================
        // ÉTAPE 3 : Création d'emprunts
        // ============================================================
        separateur("ÉTAPE 3 : Création des emprunts");

        GestionEmprunts gestionEmprunts = new GestionEmprunts();

        Emprunt emprunt1 = gestionEmprunts.creerEmprunt(membre1, ex1);
        System.out.println("📖 Emprunt créé :");
        System.out.println("  → " + emprunt1);
        System.out.println("  Exemplaire disponible ? " + ex1.isDisponible());

        Emprunt empruntEnRetard = gestionEmprunts.creerEmprunt(membre2, ex3);
        empruntEnRetard.setDateEmprunt(LocalDate.now().minusDays(20));
        empruntEnRetard.setDateRetourPrevue(LocalDate.now().minusDays(6));
        System.out.println("\n📖 Emprunt (en retard simulé) :");
        System.out.println("  → " + empruntEnRetard);
        System.out.println("  Est en retard ? " + empruntEnRetard.estEnRetard());
        System.out.println("  Jours de retard : " + empruntEnRetard.getNbJoursRetard());

        // ============================================================
        // ÉTAPE 4 : Générer une amende
        // ============================================================
        separateur("ÉTAPE 4 : Génération d'une amende pour retard");

        int joursRetard = empruntEnRetard.getNbJoursRetard();
        Amende amende1 = new Amende(1, joursRetard);
        amende1.calculerMontant(joursRetard);

        System.out.println("💸 Amende générée :");
        System.out.println("  → " + amende1);
        System.out.println("  Montant : " + amende1.getMontant() + " €");
        System.out.println("  Payée ? " + amende1.isPayee());

        // ============================================================
        // ÉTAPE 5 : Encaisser l'amende
        // ============================================================
        separateur("ÉTAPE 5 : Encaissement de l'amende");

        Caisse caisse = new Caisse();
        caisse.ajouterAmende(amende1);
        caisse.encaisserAmende(amende1);

        System.out.println("🏦 État de la caisse :");
        System.out.println("  Solde total : " + caisse.getSolde() + " €");
        System.out.println("  Amendes impayées : " + caisse.getAmendesImpayees().size());
        caisse.afficherHistorique();

        // ============================================================
        // ÉTAPE 6 : Livraison entre annexes
        // ============================================================
        separateur("ÉTAPE 6 : Livraison d'exemplaires entre annexes");

        Vehicule vehicule1 = new Vehicule(1, "DK-4521-AB");
        System.out.println("🚗 Véhicule : " + vehicule1);

        Livraison livraison1 = new Livraison(1, vehicule1, "Annexe A", "Annexe B");
        livraison1.ajouterExemplaire(ex4.toString());
        livraison1.effectuerLivraison();
        System.out.println("  Véhicule disponible après livraison ? " + vehicule1.isDisponible());

        // ============================================================
        // ÉTAPE 7 : Conservation
        // ============================================================
        separateur("ÉTAPE 7 : Contrôle des conditions de conservation");

        Conservation ctrl1 = new Conservation(1, ex2, 20.0, 45.0, LocalDate.now());
        ctrl1.verifierConditions();

        Conservation ctrl2 = new Conservation(2, ex4, 29.5, 55.0, LocalDate.now());
        ctrl2.verifierConditions();

        Conservation ctrl3 = new Conservation(3, ex3, 27.0, 75.0, LocalDate.now());
        ctrl3.verifierConditions();

        // ============================================================
        // ÉTAPE 8 : État global
        // ============================================================
        separateur("ÉTAPE 8 : ÉTAT GLOBAL DU SYSTÈME");

        System.out.println("📚 CATALOGUE :");
        catalogue.afficherTousLesLivres();

        System.out.println("\n👥 MEMBRES :");
        System.out.println("  → " + membre1 + " | Emprunts en cours : " + membre1.getNombreEmpruntsEnCours());
        System.out.println("  → " + membre2 + " | Emprunts en cours : " + membre2.getNombreEmpruntsEnCours());

        System.out.println("\n📋 EMPRUNTS EN COURS :");
        List<Emprunt> enCours = gestionEmprunts.getEmpruntsEnCours();
        if (enCours.isEmpty()) {
            System.out.println("  Aucun emprunt en cours.");
        } else {
            for (Emprunt e : enCours) {
                System.out.println("  → " + e);
            }
        }

        System.out.println("\n⚠️  EMPRUNTS EN RETARD :");
        List<Emprunt> enRetard = gestionEmprunts.getEmpruntsEnRetard();
        if (enRetard.isEmpty()) {
            System.out.println("  Aucun emprunt en retard.");
        } else {
            for (Emprunt e : enRetard) {
                System.out.println("  → " + e);
            }
        }

        System.out.println("\n💰 CAISSE :");
        System.out.println("  Solde actuel : " + caisse.getSolde() + " €");

        separateur("FIN DE LA SIMULATION — Système opérationnel ✅");
    }

    private static void separateur(String titre) {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("  " + titre);
        System.out.println("=".repeat(60));
    }
}
