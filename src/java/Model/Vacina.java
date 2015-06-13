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
public class Vacina {
    private int id_vacina;
    private String  nom_vacina;

    public Vacina(){
        id_vacina=0;
        nom_vacina="";
    }
    
    public Vacina(int Id_Vacina, String Nom_Vacina){
        id_vacina=Id_Vacina;
        nom_vacina=Nom_Vacina;
    }

    public Vacina(String Nom_Vacina){
        nom_vacina = Nom_Vacina;
    }

    /**
     * @return the id_vacina
     */
    public int getId_vacina() {
        return id_vacina;
    }

    /**
     * @param id_vacina the id_vacina to set
     */
    public void setId_vacina(int id_vacina) {
        this.id_vacina = id_vacina;
    }

    /**
     * @return the nom_vacina
     */
    public String getNom_vacina() {
        return nom_vacina;
    }

    /**
     * @param nom_vacina the nom_vacina to set
     */
    public void setNom_vacina(String nom_vacina) {
        this.nom_vacina = nom_vacina;
    }
}
