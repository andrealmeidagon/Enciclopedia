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
public class Cidade {
    private int id_cidade, uf_id;
    private String nom_cidade;

    public Cidade(){
        id_cidade = 0;
        nom_cidade = "";
        uf_id = 0;
    }
    
    public Cidade(int Uf_Id, String Nom_Cidade){
        nom_cidade = Nom_Cidade;
        uf_id = Uf_Id;
    }

    public Cidade(int Id_Cidade, int Uf_Id, String Nom_Cidade){
        id_cidade = Id_Cidade;
        nom_cidade = Nom_Cidade;
        uf_id = Uf_Id;
    }

    /**
     * @return the id_cidade
     */
    public int getId_cidade() {
        return id_cidade;
    }

    /**
     * @param id_cidade the id_cidade to set
     */
    public void setId_cidade(int id_cidade) {
        this.id_cidade = id_cidade;
    }

    /**
     * @return the uf_id
     */
    public int getUf_id() {
        return uf_id;
    }

    /**
     * @param Uf_id the uf_id to set
     */
    public void setUf_id(int Uf_id) {
        this.uf_id = Uf_id;
    }

    /**
     * @return the nom_cidade
     */
    public String getNom_cidade() {
        return nom_cidade;
    }

    /**
     * @param Nom_cidade the nom_cidade to set
     */
    public void setNom_cidade(String Nom_cidade) {
        this.nom_cidade = Nom_cidade;
    }
}
