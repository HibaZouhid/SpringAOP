package ma.ensa.beans;

import ma.ensa.service.IMetier;

public class Compte {
    private double solde= 500;
    public double getSolde() {
        return solde;
    }
    public void setSolde(double solde) {
        this.solde = solde;
    }
    public void retirer(double montant) {
        solde-=montant;
    }
    public void verser(double montant) {
        solde+=montant;

    }
}
