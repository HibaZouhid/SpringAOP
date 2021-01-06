package ma.ensa.beans;

import ma.ensa.service.IMetier;

public class Client implements IMetier {
    private String nom;
    private Compte cp;
    public Client(){
        this.cp=new Compte();
        this.cp.setSolde(500);
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public Compte getCp() {
        return cp;
    }
    public void setCp(Compte cp) {
        this.cp = cp;
    }

    @Override
    public void retirer(double montant) {
        cp.retirer(montant);
    }

    @Override
    public void verser(double montant) {
      cp.verser(montant);
    }
}
