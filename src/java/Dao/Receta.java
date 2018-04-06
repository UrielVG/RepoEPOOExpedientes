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
public class Receta {
    private int idReceta;
    private int idDoctor;
    private int idPaciente;
    private int idTratamiento;
    private String fecha;
    private String observacones;

    /**
     * @return the idReceta
     */
    public int getIdReceta() {
        return idReceta;
    }

    /**
     * @param idReceta the idReceta to set
     */
    public void setIdReceta(int idReceta) {
        this.idReceta = idReceta;
    }

    /**
     * @return the idDoctor
     */
    public int getIdDoctor() {
        return idDoctor;
    }

    /**
     * @param idDoctor the idDoctor to set
     */
    public void setIdDoctor(int idDoctor) {
        this.idDoctor = idDoctor;
    }

    /**
     * @return the idPaciente
     */
    public int getIdPaciente() {
        return idPaciente;
    }

    /**
     * @param idPaciente the idPaciente to set
     */
    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

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

    /**
     * @return the observacones
     */
    public String getObservacones() {
        return observacones;
    }

    /**
     * @param observacones the observacones to set
     */
    public void setObservacones(String observacones) {
        this.observacones = observacones;
    }
    
    
}
