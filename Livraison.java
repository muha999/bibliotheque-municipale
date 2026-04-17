import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Livraison {

    private int id;
    private Vehicule vehicule;
    private List<String> exemplaires;
    private String annexeDepart;
    private String annexeArrivee;
    private LocalDate date;
    private boolean effectuee;

    // Constructeur
    public Livraison(int id, Vehicule vehicule, String annexeDepart, String annexeArrivee) {
        if (vehicule == null) {
            throw new IllegalArgumentException("Le véhicule ne peut pas être nul");
        }
        if (annexeDepart == null || annexeDepart.isEmpty()) {
            throw new IllegalArgumentException("L'annexe de départ ne peut pas être vide");
        }
        if (annexeArrivee == null || annexeArrivee.isEmpty()) {
            throw new IllegalArgumentException("L'annexe d'arrivée ne peut pas être vide");
        }
        if (annexeDepart.equals(annexeArrivee)) {
            throw new IllegalArgumentException("L'annexe de départ et d'arrivée ne peuvent pas être identiques");
        }
        this.id = id;
        this.vehicule = vehicule;
        this.annexeDepart = annexeDepart;
        this.annexeArrivee = annexeArrivee;
        this.exemplaires = new ArrayList<>();
        this.date = LocalDate.now();
        this.effectuee = false;
    }

    // Ajouter un exemplaire à livrer
    public void ajouterExemplaire(String exemplaire) {
        if (exemplaire == null || exemplaire.isEmpty()) {
            throw new IllegalArgumentException("L'exemplaire ne peut pas être vide");
        }
        this.exemplaires.add(exemplaire);
        System.out.println("Exemplaire ajouté à la livraison : " + exemplaire);
    }

    // Effectuer la livraison
    public void effectuerLivraison() {
        if (effectuee) {
            System.out.println("Cette livraison a déjà été effectuée !");
            return;
        }
        if (!vehicule.isDisponible()) {
            System.out.println("Le véhicule " + vehicule.getImmatriculation() + " n'est pas disponible !");
            return;
        }
        if (exemplaires.isEmpty()) {
            System.out.println("Aucun exemplaire à livrer !");
            return;
        }
        vehicule.reserver();
        this.effectuee = true;
        System.out.println("=== Livraison effectuée ===");
        System.out.println("De : " + annexeDepart + " → Vers : " + annexeArrivee);
        System.out.println("Nombre d'exemplaires livrés : " + exemplaires.size());
        vehicule.liberer();
    }

    // Getters
    public int getId() { return id; }
    public Vehicule getVehicule() { return vehicule; }
    public List<String> getExemplaires() { return exemplaires; }
    public String getAnnexeDepart() { return annexeDepart; }
    public String getAnnexeArrivee() { return annexeArrivee; }
    public LocalDate getDate() { return date; }
    public boolean isEffectuee() { return effectuee; }

    @Override
    public String toString() {
        return "Livraison{id=" + id +
               ", vehicule=" + vehicule.getImmatriculation() +
               ", de=" + annexeDepart +
               ", vers=" + annexeArrivee +
               ", date=" + date +
               ", effectuee=" + effectuee + "}";
    }
}