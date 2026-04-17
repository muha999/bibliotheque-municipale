import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GestionEmprunts {
    private List<Emprunt> emprunts;
    private int compteurId;
    private static final int MAX_EMPRUNTS = 3;

    public GestionEmprunts() {
        this.emprunts = new ArrayList<>();
        this.compteurId = 1;
    }

    public Emprunt creerEmprunt(Membre membre, Exemplaire exemplaire) {
        if (!membre.isActif())
            throw new IllegalStateException("Le membre est inactif");
        if (membre.getNombreEmpruntsEnCours() >= MAX_EMPRUNTS)
            throw new IllegalStateException("Limite de " + MAX_EMPRUNTS + " emprunts atteinte");
        if (!exemplaire.isDisponible())
            throw new IllegalStateException("L'exemplaire n'est pas disponible");

        Emprunt emprunt = new Emprunt(compteurId++, membre, exemplaire);
        exemplaire.setDisponible(false);
        membre.ajouterEmprunt(emprunt);
        emprunts.add(emprunt);

        System.out.println("✅ Emprunt créé : " + emprunt);
        return emprunt;
    }

    public void enregistrerRetour(int idEmprunt) {
        Emprunt emprunt = trouverParId(idEmprunt);
        if (emprunt == null)
            throw new IllegalArgumentException("Emprunt introuvable : id=" + idEmprunt);

        emprunt.effectuerRetour();
        emprunt.getExemplaire().setDisponible(true);

        System.out.println("📦 Retour enregistré : " + emprunt);
        if (emprunt.getNbJoursRetard() > 0) {
            System.out.println("⚠️  " + emprunt.getNbJoursRetard() + " jour(s) de retard → amende à créer (P3)");
        }
    }

    public List<Emprunt> getEmpruntsEnCours() {
        return emprunts.stream()
                .filter(e -> !e.isRendu())
                .collect(Collectors.toList());
    }

    public List<Emprunt> getEmpruntsEnRetard() {
        return emprunts.stream()
                .filter(Emprunt::estEnRetard)
                .collect(Collectors.toList());
    }

    public List<Emprunt> getEmprunts() { return emprunts; }

    private Emprunt trouverParId(int id) {
        return emprunts.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void afficherEtat() {
        System.out.println("\n===== GESTION DES EMPRUNTS =====");
        if (emprunts.isEmpty()) {
            System.out.println("Aucun emprunt enregistré.");
        } else {
            emprunts.forEach(System.out::println);
        }
        System.out.println("================================\n");
    }
}