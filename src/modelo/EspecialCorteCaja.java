package modelo;

public class EspecialCorteCaja {
    private String venta;
    private String cliente;
    private String empleado;
    private String codigoMoto;
    private String cantidad;
    private String precio;
    private String total;
    private String fecha;

    public EspecialCorteCaja(String venta, String cliente, String empleado, 
            String codigoMoto, String cantidad, String precio, String total,
            String fecha) {
        this.venta = venta;
        this.cliente = cliente;
        this.empleado = empleado;
        this.codigoMoto = codigoMoto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.total = total;
        this.fecha = fecha;
    }

    public String getVenta() {
        return venta;
    }

    public void setVenta(String venta) {
        this.venta = venta;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    public String getCodigoMoto() {
        return codigoMoto;
    }

    public void setCodigoMoto(String codigoMoto) {
        this.codigoMoto = codigoMoto;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
}
