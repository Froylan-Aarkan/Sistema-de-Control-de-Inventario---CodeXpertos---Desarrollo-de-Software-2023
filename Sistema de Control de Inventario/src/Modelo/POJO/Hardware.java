/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.POJO;

import java.sql.Date;

/**
 *
 * @author froyl
 */
public class Hardware {
    private int idHardware;
    private String modelo;
    private String numeroSerie;
    private String estado;
    private String procesador;
    private String posicion;
    private float almacenamiento;
    private float ram;
    private String direccionMac;
    private String direccionIp;
    private String grafica;
    private Date fechaIngreso;
    private String sistemaOperativo;
    private int arquitectura;
    private String marca;
    private String tarjetaMadre;
    private int idCentroComputo;

    public Hardware() {
    }

    public int getIdHardware() {
        return idHardware;
    }

    public String getModelo() {
        return modelo;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public String getEstado() {
        return estado;
    }

    public String getProcesador() {
        return procesador;
    }

    public String getPosicion() {
        return posicion;
    }

    public float getAlmacenamiento() {
        return almacenamiento;
    }

    public float getRam() {
        return ram;
    }

    public String getDireccionMac() {
        return direccionMac;
    }

    public String getDireccionIp() {
        return direccionIp;
    }

    public String getGrafica() {
        return grafica;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public int getArquitectura() {
        return arquitectura;
    }

    public String getMarca() {
        return marca;
    }

    public String getTarjetaMadre() {
        return tarjetaMadre;
    }

    public int getIdCentroComputo() {
        return idCentroComputo;
    }

    public void setIdHardware(int idHardware) {
        this.idHardware = idHardware;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public void setAlmacenamiento(float almacenamiento) {
        this.almacenamiento = almacenamiento;
    }

    public void setRam(float ram) {
        this.ram = ram;
    }

    public void setDireccionMac(String direccionMac) {
        this.direccionMac = direccionMac;
    }

    public void setDireccionIp(String direccionIp) {
        this.direccionIp = direccionIp;
    }

    public void setGrafica(String grafica) {
        this.grafica = grafica;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

    public void setArquitectura(int arquitectura) {
        this.arquitectura = arquitectura;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setTarjetaMadre(String tarjetaMadre) {
        this.tarjetaMadre = tarjetaMadre;
    }

    public void setIdCentroComputo(int idCentroComputo) {
        this.idCentroComputo = idCentroComputo;
    }
}