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
public class Vacina_Doenca {
    private int vacina_id_vacina;
    private int doenca_id_doenca;
    
    public Vacina_Doenca(){
        doenca_id_doenca = 0;
        vacina_id_vacina = 0;
    }

    public Vacina_Doenca(int Doenca_id, int Vacina_id){
        doenca_id_doenca = Doenca_id;
        vacina_id_vacina = Vacina_id;
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
}
