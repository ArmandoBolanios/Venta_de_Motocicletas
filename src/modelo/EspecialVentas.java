package modelo;

public class EspecialVentas {
    private int cedulaCliente;
    private int idEmpleado;
    private int codigoMoto;
    private int cantidadVenta;
    private double precioVenta;
    private double precioGral;
    private String fecha;  
    private String marcaMoto;

    public int getCedulaCliente() {
        return cedulaCliente;
    }

    public void setCedulaCliente(int cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getCodigoMoto() {
        return codigoMoto;
    }

    public void setCodigoMoto(int codigoMoto) {
        this.codigoMoto = codigoMoto;
    }

    public int getCantidadVenta() {
        return cantidadVenta;
    }

    public void setCantidadVenta(int cantidadVenta) {
        this.cantidadVenta = cantidadVenta;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public double getPrecioGral() {
        return precioGral;
    }

    public void setPrecioGral(double precioGral) {
        this.precioGral = precioGral;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getMarcaMoto() {
        return marcaMoto;
    }

    public void setMarcaMoto(String marcaMoto) {
        this.marcaMoto = marcaMoto;
    }

    
}
