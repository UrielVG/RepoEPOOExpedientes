/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

/**
 *
 * @author Unitec
 */
public class Tratamiento {

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    private int idTratamiento;
    private int idMedicamento;
    private int idDiagnostico;
    private String diagnostico;
    private String medicamento;
    private String fecha;

    /**
     * @return the idTratamiento
     */
    public int getIdTratamiento() {
        return idTratamiento;
    }

    /**
     * @param idTratamiento the idTratamiento to set
     */
    public void setIdTratamiento(int idTratamiento) {
        this.idTratamiento = idTratamiento;
    }

    /**
     * @return the idMedicamento
     */
    public int getIdMedicamento() {
        return idMedicamento;
    }

    /**
     * @param idMedicamento the idMedicamento to set
     */
    public void setIdMedicamento(int idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    /**
     * @return the idDiagnostico
     */
    public int getIdDiagnostico() {
        return idDiagnostico;
    }

    /**
     * @param idDiagnostico the idDiagnostico to set
     */
    public void setIdDiagnostico(int idDiagnostico) {
        this.idDiagnostico = idDiagnostico;
    }

    /**
     * @return the diagnostico
     */
    public String getDiagnostico() {
        return diagnostico;
    }

    /**
     * @param diagnostico the diagnostico to set
     */
    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    /**
     * @return the medicamento
     */
    public String getMedicamento() {
        return medicamento;
    }

    /**
     * @param medicamento the medicamento to set
     */
    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }
    
}
