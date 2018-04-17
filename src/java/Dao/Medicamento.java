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
public class Medicamento {
    private int idMedicamento;
    private String nombre;
    private String marca;
    private String substancia;
    private String fecha;

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
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * @return the substancia
     */
    public String getSubstancia() {
        return substancia;
    }

    /**
     * @param substancia the substancia to set
     */
    public void setSubstancia(String substancia) {
        this.substancia = substancia;
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
}
