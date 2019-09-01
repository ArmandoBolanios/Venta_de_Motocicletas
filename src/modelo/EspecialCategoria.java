package modelo;

public class EspecialCategoria {
  
    private String marca;
    private String modelo;
    private String color;
    private double preciovt;
    private int stock;
    private int categoria;

            
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

    public double getPreciovt() {
        return preciovt;
    }

    public void setPreciovt(double precio) {
        this.preciovt = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }
}