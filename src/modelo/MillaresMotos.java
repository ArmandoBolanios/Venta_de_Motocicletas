package modelo;

public class MillaresMotos {
    private String codigo;
    private String marca;
    private String modelo;
    private String color;
    private String categoria;
    private String factura;
    private String proveedor;
    private String costo;
    private String stock;
    private String precio;

    public MillaresMotos(String codigo, String marca, String modelo, String color, String categoria, String factura, String proveedor, String costo, String stock, String precio) {
        this.codigo = codigo;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.categoria = categoria;
        this.factura = factura;
        this.proveedor = proveedor;
        this.costo = costo;
        this.stock = stock;
        this.precio = precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getFactura() {
        return factura;
    }

    public void setFactura(String factura) {
        this.factura = factura;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

        
}
