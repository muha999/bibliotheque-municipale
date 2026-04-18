import java.time.LocalDate;

/**
 * Classe Conservation
 * Surveille les conditions (température, humidité) d'un exemplaire de livre.
 * Auteur : Personne 4
 */
public class Conservation {

    // ===================== ATTRIBUTS =====================

    private int id;
    private Exemplaire exemplaire;
    private double temperature;   // en degrés Celsius
    private double humidite;      // en pourcentage (%)
    private LocalDate dateControle;

    // ===================== CONSTRUCTEUR =====================

    public Conservation(int id, Exemplaire exemplaire, double temperature,
                        double humidite, LocalDate dateControle) {
        this.id = id;
        this.exemplaire = exemplaire;
        this.temperature = temperature;
        this.humidite = humidite;
        this.dateControle = dateControle;
    }

    // ===================== METHODE PRINCIPALE =====================

    /**
     * Vérifie si les conditions de conservation sont acceptables.
     * ALERTE si température > 25°C ou humidité > 60%
     */
    public void verifierConditions() {
        System.out.println("=== Contrôle de conservation [ID: " + id + "] ===");
        System.out.println("  Exemplaire : " + exemplaire.getId()
                + " | Livre : " + exemplaire.getLivre().getTitre());
        System.out.println("  Température  : " + temperature + "°C");
        System.out.println("  Humidité     : " + humidite + "%");
        System.out.println("  Date contrôle: " + dateControle);

        boolean alerteTemp     = temperature > 25.0;
        boolean alerteHumidite = humidite > 60.0;

        if (alerteTemp) {
            System.out.println("  ⚠️  ALERTE : Température trop élevée (" + temperature
                    + "°C > 25°C) ! Risque de détérioration.");
        }
        if (alerteHumidite) {
            System.out.println("  ⚠️  ALERTE : Humidité trop élevée (" + humidite
                    + "% > 60%) ! Risque de moisissures.");
        }
        if (!alerteTemp && !alerteHumidite) {
            System.out.println("  ✅  Conditions optimales. Aucun problème détecté.");
        }
        System.out.println();
    }

    // ===================== GETTERS & SETTERS =====================

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Exemplaire getExemplaire() { return exemplaire; }
    public void setExemplaire(Exemplaire exemplaire) { this.exemplaire = exemplaire; }

    public double getTemperature() { return temperature; }
    public void setTemperature(double temperature) { this.temperature = temperature; }

    public double getHumidite() { return humidite; }
    public void setHumidite(double humidite) { this.humidite = humidite; }

    public LocalDate getDateControle() { return dateControle; }
    public void setDateControle(LocalDate dateControle) { this.dateControle = dateControle; }

    // ===================== TOSTRING =====================

    @Override
    public String toString() {
        return "Conservation{" +
                "id=" + id +
                ", livre='" + exemplaire.getLivre().getTitre() + '\'' +
                ", temperature=" + temperature + "°C" +
                ", humidite=" + humidite + "%" +
                ", dateControle=" + dateControle +
                '}';
    }
}
