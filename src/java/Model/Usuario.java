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
public class Usuario {
    private int id_usuario, instituicao_id, tipo_usuario;
    private String nom_usuario, senha_usuario, email_usuario;

    public Usuario(){
        id_usuario=0;
        nom_usuario="";
        instituicao_id=0;
        senha_usuario="";
        email_usuario="";
        tipo_usuario = 0;
    }
    
    public Usuario(int Id_User, int Instituicao_Id, int Tipo_Usuario, String Email_User, String Nom_User, String Senha_User){
        id_usuario=Id_User;
        nom_usuario=Nom_User;
        instituicao_id=Instituicao_Id;
        senha_usuario=Senha_User;
        email_usuario=Email_User;
        tipo_usuario = Tipo_Usuario;
    }   
     
    public Usuario(int Instituicao_Id, int Tipo_Usuario, String Email_User, String Nom_User, String Senha_User){
        nom_usuario=Nom_User;
        instituicao_id=Instituicao_Id;
        senha_usuario=Senha_User;
        email_usuario=Email_User;
        tipo_usuario = Tipo_Usuario;
    }   

    public Usuario(int Instituicao_Id, String Email_User, String Nom_User, String Senha_User){
        nom_usuario=Nom_User;
        instituicao_id=Instituicao_Id;
        senha_usuario=Senha_User;
        email_usuario=Email_User;
    }
    
    /**
     * @return the id_usuario
     */
    public int getId_usuario() {
        return id_usuario;
    }

    /**
     * @param Id_user the id_usuario to set
     */
    public void setId_usuario(int Id_user) {
        this.id_usuario = Id_user;
    }

    /**
     * @return the instituicao_id
     */
    public int getInstituicao_id() {
        return instituicao_id;
    }

    /**
     * @param instituicao_id the instituicao_id to set
     */
    public void setInstituicao_id(int instituicao_id) {
        this.instituicao_id = instituicao_id;
    }

    /**
     * @return the nom_usuario
     */
    public String getNom_usuario() {
        return nom_usuario;
    }

    /**
     * @param Nom_usuario the nom_usuario to set
     */
    public void setNom_usuario(String Nom_usuario) {
        this.nom_usuario = Nom_usuario;
    }

    /**
     * @return the senha_usuario
     */
    public String getSenha_usuario() {
        return senha_usuario;
    }

    /**
     * @param Senha_usuario the senha_usuario to set
     */
    public void setSenha_usuario(String Senha_usuario) {
        this.senha_usuario = Senha_usuario;
    }

    /**
     * @return the email_usuario
     */
    public String getEmail_usuario() {
        return email_usuario;
    }

    /**
     * @param Email_user the email_usuario to set
     */
    public void setEmail_usuario(String Email_user) {
        this.email_usuario = Email_user;
    }

    /**
     * @return the tipo_usuario
     */
    public int getTipo_usuario() {
        return tipo_usuario;
    }

    /**
     * @param tipo_usuario the tipo_usuario to set
     */
    public void setTipo_usuario(int tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }
}
