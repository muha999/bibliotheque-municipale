import java.util.ArrayList;
import java.util.List;

public class Membre {
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private List<Emprunt> historique;
    private boolean actif;

    public Membre(int id, String nom, String prenom, String email) {
        if (nom == null || nom.isBlank()) throw new IllegalArgumentException("Nom invalide");
        if (email == null || !email.contains("@")) throw new IllegalArgumentException("Email invalide");
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.historique = new ArrayList<>();
        this.actif = true;
    }

    public int getNombreEmpruntsEnCours() {
        int count = 0;
        for (Emprunt e : historique) {
            if (!e.isRendu()) count++;
        }
        return count;
    }

    public void ajouterEmprunt(Emprunt e) { historique.add(e); }


    public int getId() { return id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public List<Emprunt> getHistorique() { return historique; }
    public boolean isActif() { return actif; }
    public void setActif(boolean actif) { this.actif = actif; }

    @Override
    public String toString() {
        return "Membre[" + id + "] " + prenom + " " + nom +
               " | Email: " + email +
               " | Actif: " + actif +
               " | Emprunts en cours: " + getNombreEmpruntsEnCours();
    }
}
    

