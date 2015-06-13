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
public class Correspond_topico {
    private int id_correspond_topico, doenca_id_doenca, vacina_id_vacina, topico_id_topico;

    public Correspond_topico(){
        id_correspond_topico = 0;
        doenca_id_doenca = 0;
        vacina_id_vacina = 0;
        topico_id_topico = 0;
    }

    public Correspond_topico(int Id_Correspond_Topico, int Doenca_Id_Doenca, int Vacina_Id_Vacina, int Topico_Id_Topico){
        id_correspond_topico = Id_Correspond_Topico;
        doenca_id_doenca = Doenca_Id_Doenca;
        vacina_id_vacina = Vacina_Id_Vacina;
        topico_id_topico = Topico_Id_Topico;
    }

    public Correspond_topico(int Doenca_Id_Doenca, int Vacina_Id_Vacina, int Topico_Id_Topico){
        doenca_id_doenca = Doenca_Id_Doenca;
        vacina_id_vacina = Vacina_Id_Vacina;
        topico_id_topico = Topico_Id_Topico;
    }
    
    /**
     * @return the topico_id_topico
     */
    public int getTopico_id_topico() {
        return topico_id_topico;
    }

    /**
     * @param topico_id_topico the topico_id_topico to set
     */
    public void setTopico_id_topico(int topico_id_topico) {
        this.topico_id_topico = topico_id_topico;
    }

    /**
     * @return the vacina_id_vacina
     */
    public int getVacina_id_vacina() {
        return vacina_id_vacina;
    }

    /**
     * @param vacina_id_vacina the vacina_id_vacina to set
     */
    public void setVacina_id_vacina(int vacina_id_vacina) {
        this.vacina_id_vacina = vacina_id_vacina;
    }

    /**
     * @return the doenca_id_doenca
     */
    public int getDoenca_id_doenca() {
        return doenca_id_doenca;
    }

    /**
     * @param doenca_id_doenca the doenca_id_doenca to set
     */
    public void setDoenca_id_doenca(int doenca_id_doenca) {
        this.doenca_id_doenca = doenca_id_doenca;
    }

    /**
     * @return the id_correspond_topico
     */
    public int getId_correspond_topico() {
        return id_correspond_topico;
    }

    /**
     * @param id_correspond_topico the id_correspond_topico to set
     */
    public void setId_correspond_topico(int id_correspond_topico) {
        this.id_correspond_topico = id_correspond_topico;
    }
}
