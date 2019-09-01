package modelo;

public class EspecialFacturaMoto {
    private String cantidad;
    private String descripcion;
    private String precio;
    private String total;
    

    
    public EspecialFacturaMoto(String cantidad, String descripcion, String precio, String total) {
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.precio = precio;
        this.total = total;

    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

}
