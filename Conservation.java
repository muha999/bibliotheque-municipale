import java.time.LocalDate;

public class Conservation {

    private int id;
    private Exemplaire exemplaire;
    private double temperature;
    private double humidite;
    private LocalDate dateControle;

    public Conservation(int id, Exemplaire exemplaire, double temperature,
                        double humidite, LocalDate dateControle) {
        this.id = id;
        this.exemplaire = exemplaire;
        this.temperature = temperature;
        this.humidite = humidite;
        this.dateControle = dateControle;
    }

    public void verifierConditions() {
        System.out.println("=== Contrôle de conservation [ID: " + id + "] ===");
        System.out.println("  Exemplaire : " + exemplaire.getId()
                + " | Livre : " + exemplaire.getLivre().getTitre());
        System.out.println("  Température  : " + temperature + "°C");
        System.out.println("  Humidité     : " + humidite + "%");
        System.out.println("  Date contrôle: " + dateControle);

        boolean alerteTemp = temperature > 25.0;
        boolean alerteHumidite = humidite > 60.0;

        if (alerteTemp) {
            System.out.println("  ⚠️  ALERTE : Température trop élevée (" + temperature + "°C > 25°C) !");
        }
        if (alerteHumidite) {
            System.out.println("  ⚠️  ALERTE : Humidité trop élevée (" + humidite + "% > 60%) !");
        }
        if (!alerteTemp && !alerteHumidite) {
            System.out.println("  ✅  Conditions optimales. Aucun problème détecté.");
        }
        System.out.println();
    }

    public int getId() { return id; }
    public Exemplaire getExemplaire() { return exemplaire; }
    public double getTemperature() { return temperature; }
    public double getHumidite() { return humidite; }
    public LocalDate getDateControle() { return dateControle; }
    public void setTemperature(double temperature) { this.temperature = temperature; }
    public void setHumidite(double humidite) { this.humidite = humidite; }

    @Override
    public String toString() {
        return "Conservation{id=" + id +
                ", livre='" + exemplaire.getLivre().getTitre() + '\'' +
                ", temperature=" + temperature + "°C" +
                ", humidite=" + humidite + "%" +
                ", dateControle=" + dateControle + '}';
    }
}