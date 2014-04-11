/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gastroclinica;

/**
 *
 * @author Geek
 */
public class VentasT {

    
    
    private int id;
    private String nombre;
    private String fabricante;
    private String presentacion;
    private double precio;
    private int existencia;
    private int cantidad;
    
    

    public VentasT(int id, String nombre, String fabricante, String presentacion, double precio, int existencia, int cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.fabricante = fabricante;
        this.presentacion = presentacion;
        this.precio = precio;
        this.existencia = existencia;
        this.cantidad=cantidad;
    }
    
     void setId(int id){
         this.id =id;
     }
     int getId(){
         return id;
     }
     void setNombre(String nombre){
         this.nombre =nombre;     
     }
     String getNombre(){
         return nombre;
     }
     void setFabricante(String fabricante){
         this.fabricante = fabricante;
     }
     String getFabricante(){
         return fabricante;
     }
     void setPresentacion(String presentacion){
         this.presentacion = presentacion;
     }
     String getPresentacion(){
         return presentacion;
     }
     void setPrecio(double precio){
         this.precio = precio;
     }
     Double getPrecio(){
         return precio;
     }
     public int getExistencia() {
        return existencia;
     }

     public void setExistencia(int existencia) {
        this.existencia = existencia;
     }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
     
     
    
    
}
