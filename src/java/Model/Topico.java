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
public class Topico {
    private int id_topico, id_secao, nvl_topico;
    private String des_topico, titul_topico;
    
    public Topico(int Id_Topico, int Id_Secao, int Nvl_Topico, String Des_Topico,String Titul_Topico){
        id_topico = Id_Topico;
        id_secao = Id_Secao;
        nvl_topico = Nvl_Topico;
        des_topico = Des_Topico;
        titul_topico = Titul_Topico;
    }

    public Topico(int Id_Secao, int Nvl_Topico, String Des_Topico,String Titul_Topico){
        id_secao = Id_Secao;
        nvl_topico = Nvl_Topico;
        des_topico = Des_Topico;
        titul_topico = Titul_Topico;
    }

    /**
     * @return the id_topico
     */
    public int getId_topico() {
        return id_topico;
    }

    /**
     * @param id_topico the id_topico to set
     */
    public void setId_topico(int id_topico) {
        this.id_topico = id_topico;
    }

    /**
     * @return the id_secao
     */
    public int getId_secao() {
        return id_secao;
    }

    /**
     * @param id_secao the id_secao to set
     */
    public void setId_secao(int id_secao) {
        this.id_secao = id_secao;
    }

    /**
     * @return the nvl_topico
     */
    public int getNvl_topico() {
        return nvl_topico;
    }

    /**
     * @param nvl_topico the nvl_topico to set
     */
    public void setNvl_topico(int nvl_topico) {
        this.nvl_topico = nvl_topico;
    }

    /**
     * @return the des_topico
     */
    public String getDes_topico() {
        return des_topico;
    }

    /**
     * @param des_topico the des_topico to set
     */
    public void setDes_topico(String des_topico) {
        this.des_topico = des_topico;
    }

    /**
     * @return the titul_topico
     */
    public String getTitul_topico() {
        return titul_topico;
    }

    /**
     * @param titul_topico the titul_topico to set
     */
    public void setTitul_topico(String titul_topico) {
        this.titul_topico = titul_topico;
    }
}
