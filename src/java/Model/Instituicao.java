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
public class Instituicao {
    private int id_instituicao, cidade_id;
    private String nom_instituicao, sigla_instituicao;

    public Instituicao(){
        cidade_id = 0;
        nom_instituicao = "";
        sigla_instituicao = "";
    }
    public Instituicao(int Id_Cidade, String Nom_Instituicao, String Sigla_Instituicao){
        sigla_instituicao = Sigla_Instituicao;
        cidade_id = Id_Cidade;
        nom_instituicao = Nom_Instituicao;
    }

    public Instituicao(int Id_Instituicao, int Id_Cidade, String Nom_Instituicao, String Sigla_Instituicao){
        id_instituicao = Id_Instituicao;
        sigla_instituicao = Sigla_Instituicao;
        cidade_id = Id_Cidade;
        nom_instituicao = Nom_Instituicao;
    }

    /**
     * @return the id_instituicao
     */
    public int getId_instituicao() {
        return id_instituicao;
    }

    /**
     * @param Id_instituicao the id_instituicao to set
     */
    public void setId_instituicao(int Id_instituicao) {
        this.id_instituicao = Id_instituicao;
    }

    /**
     * @return the cidade_id
     */
    public int getCidade_id() {
        return cidade_id;
    }

    /**
     * @param Cidade_cod_cidade the cidade_id to set
     */
    public void setCidade_id(int Cidade_cod_cidade) {
        this.cidade_id = Cidade_cod_cidade;
    }

    /**
     * @return the nom_instituicao
     */
    public String getNom_instituicao() {
        return nom_instituicao;
    }

    /**
     * @param Nom_instituicao the nom_instituicao to set
     */
    public void setNom_instituicao(String Nom_instituicao) {
        this.nom_instituicao = Nom_instituicao;
    }

    /**
     * @return the sigla_instituicao
     */
    public String getSigla_instituicao() {
        return sigla_instituicao;
    }

    /**
     * @param Sigla_instituicao the sigla_instituicao to set
     */
    public void setSigla_instituicao(String Sigla_instituicao) {
        this.sigla_instituicao = Sigla_instituicao;
    }
}
