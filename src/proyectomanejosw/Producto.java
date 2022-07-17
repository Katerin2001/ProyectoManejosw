/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectomanejosw;

/**
 *
 * @author byron
 */
public class Producto {

    private String nombre;
    private int costoS;
    private int costoM;
    private int costoL;

    public Producto(String nombre, int costoS, int costoM, int costoL) {
        this.nombre = nombre;
        this.costoS = costoS;
        this.costoM = costoM;
        this.costoL = costoL;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCostoS() {
        return costoS;
    }

    public void setCostoS(int costoS) {
        this.costoS = costoS;
    }

    public int getCostoM() {
        return costoM;
    }

    public void setCostoM(int costoM) {
        this.costoM = costoM;
    }

    public int getCostoL() {
        return costoL;
    }

    public void setCostoL(int costoL) {
        this.costoL = costoL;
    }

}
