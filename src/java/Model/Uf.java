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
public class Uf {
    private int id_uf;
    private String nom_uf,sigla_uf;

    public Uf(){
        id_uf = 0;
        nom_uf = "";
        sigla_uf = "";
    }
    
    public Uf(String Nom_Uf, String Sigla_Uf){
        nom_uf = Nom_Uf;
        sigla_uf = Sigla_Uf;
    }
    
    public Uf(int Id_Uf, String Nom_Uf, String Sigla_Uf){
        id_uf = Id_Uf;
        nom_uf = Nom_Uf;
        sigla_uf = Sigla_Uf;
    }

    /**
     * @return the id_uf
     */
    public int getId_uf() {
        return id_uf;
    }

    /**
     * @param id_uf the id_uf to set
     */
    public void setId_uf(int id_uf) {
        this.id_uf = id_uf;
    }

    /**
     * @return the nom_uf
     */
    public String getNom_uf() {
        return nom_uf;
    }

    /**
     * @param nom_uf the nom_uf to set
     */
    public void setNom_uf(String nom_uf) {
        this.nom_uf = nom_uf;
    }

    /**
     * @return the sigla_uf
     */
    public String getSigla_uf() {
        return sigla_uf;
    }

    /**
     * @param sigla_uf the sigla_uf to set
     */
    public void setSigla_uf(String sigla_uf) {
        this.sigla_uf = sigla_uf;
    }
   
}
