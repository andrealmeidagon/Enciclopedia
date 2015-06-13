/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author André
 */
public class Doenca {
    private int id_doenca;
    private String  nom_doenca;

    public Doenca(){
        id_doenca=0;
        nom_doenca="";
    }
    
    public Doenca(int Id_Doenca, String Nom_Doenca){
        id_doenca=Id_Doenca;
        nom_doenca=Nom_Doenca;
    }

    
    public Doenca(String Nom_Doenca){
        nom_doenca = Nom_Doenca;
    }

    /**
     * @return the id_doenca
     */
    public int getId_doenca() {
        return id_doenca;
    }

    /**
     * @param id_doenca the id_doenca to set
     */
    public void setId_doenca(int id_doenca) {
        this.id_doenca = id_doenca;
    }

    /**
     * @return the nom_doenca
     */
    public String getNom_doenca() {
        return nom_doenca;
    }

    /**
     * @param nom_doenca the nom_doenca to set
     */
    public void setNom_doenca(String nom_doenca) {
        this.nom_doenca = nom_doenca;
    }
}
