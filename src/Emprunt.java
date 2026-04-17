import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Emprunt {
    private int id;
    private Membre membre;
    private Exemplaire exemplaire;
    private LocalDate dateEmprunt;
    private LocalDate dateRetourPrevue;
    private LocalDate dateRetourEffective;
    private boolean rendu;

    public Emprunt(int id, Membre membre, Exemplaire exemplaire) {
        if (membre == null) throw new IllegalArgumentException("Membre invalide");
        if (exemplaire == null) throw new IllegalArgumentException("Exemplaire invalide");
        this.id = id;
        this.membre = membre;
        this.exemplaire = exemplaire;
        this.dateEmprunt = LocalDate.now();
        this.dateRetourPrevue = dateEmprunt.plusDays(14);
        this.dateRetourEffective = null;
        this.rendu = false;
    }

    public boolean estEnRetard() {
        if (rendu) return false;
        return LocalDate.now().isAfter(dateRetourPrevue);
    }

    public int getNbJoursRetard() {
        if (!estEnRetard() && dateRetourEffective == null) return 0;
        LocalDate reference = (dateRetourEffective != null) ? dateRetourEffective : LocalDate.now();
        long jours = ChronoUnit.DAYS.between(dateRetourPrevue, reference);
        return (int) Math.max(0, jours);
    }

    public void effectuerRetour() {
        if (rendu) throw new IllegalStateException("Cet emprunt est déjà rendu");
        this.rendu = true;
        this.dateRetourEffective = LocalDate.now();
    }

    
    public int getId() { return id; }
    public Membre getMembre() { return membre; }
    public Exemplaire getExemplaire() { return exemplaire; }
    public LocalDate getDateEmprunt() { return dateEmprunt; }
    public LocalDate getDateRetourPrevue() { return dateRetourPrevue; }
    public LocalDate getDateRetourEffective() { return dateRetourEffective; }
    public boolean isRendu() { return rendu; }

    
    public void setDateRetourPrevue(LocalDate date) { this.dateRetourPrevue = date; }
    
    public void setDateEmprunt(LocalDate date) { this.dateEmprunt = date; }
    @Override
    public String toString() {
        String statut;
        if (rendu) {
            statut = getNbJoursRetard() > 0
                ? "RENDU EN RETARD (" + getNbJoursRetard() + "j)"
                : "RENDU À TEMPS";
        } else {
            statut = estEnRetard()
                ? "EN RETARD (" + getNbJoursRetard() + "j)"
                : "EN COURS";
        }
        return "Emprunt[" + id + "] " + membre.getNom() +
               " → Exemplaire[" + exemplaire.getId() + "]" +
               " | Emprunté: " + dateEmprunt +
               " | Retour prévu: " + dateRetourPrevue +
               " | Statut: " + statut;
    }
}
