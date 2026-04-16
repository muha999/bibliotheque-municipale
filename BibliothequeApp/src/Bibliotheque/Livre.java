package Bibliotheque;

public class Livre {
    // Attributs(Informations sur le livre )
    private int id;
    private String titre;
    private String auteur;
    private String isbn;
    private String genre;
    private int anneePublication;
    //les constructeurs
    public Livre(int id ,String titre,String auteur ,String idbn ,String genre,int anneePublication){
        this.id=id;
        this.titre=titre;
        this.auteur=auteur;
        this.isbn=idbn;
        this.genre=genre;
        this.anneePublication=anneePublication;
    }
    //les getters 
    public int getId() {
        return id;
    }
    public String getTitre() {
        return titre;
    }
    public String getAuteur() {
        return auteur;
    }
    public String getIsbn() {
        return isbn;
    }
    public String getGenre() {
        return genre;
    }
    public int getAnneePublication() {
        return anneePublication;
    } 
    //les setters 
    public void setTitre(String titre){
        if (titre == null || titre.isEmpty()){
            System.out.println("Erreur:le Titre ne peut pas etre vide");
        }
        else{
            this.titre=titre;

        }
    }
    public void setAuteur(String auteur){
        if (auteur == null || auteur.isEmpty()){
            System.out.println("Erreur:le Auteur ne peut pas etre vide");
        }
        else{
            this.auteur=auteur;

        }   
        
    }
    public void setIsbn(String isbn){
        if (isbn == null || isbn.isEmpty()){
            System.out.println("Erreur:le ISBN ne peut pas etre vide");
        }
        else{
            this.isbn=isbn;

        }   
        
    }
    public void setGenre(String genre ){
        this.genre=genre;
    }
    public void setAnneePublication(int anneePublication){
        if (anneePublication < 0|| anneePublication > 2025){
            System.out.println("Erreur: annee de publication invalide");
        }
        else{
            this.anneePublication=anneePublication;
        }
    }
    //methode pour afficher les informations du livre
    public String toString(){
        return "Livre{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", auteur='" + auteur + '\'' +
                ", isbn='" + isbn + '\'' +
                ", genre='" + genre + '\'' +
                ", anneePublication=" + anneePublication +
                '}';
    }
}


    
    

