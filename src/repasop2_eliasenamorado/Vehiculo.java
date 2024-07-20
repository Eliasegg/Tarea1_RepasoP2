package repasop2_eliasenamorado;

/**
 *
 * @author Elias
 */
class Vehiculo {
    private String matricula;
    private String marca;
    private String modelo;
    private String color;
    private int añoFabricacion;
    private double precio;

    public Vehiculo(String matricula, String marca, String modelo, String color, int añoFabricacion, double precio) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.añoFabricacion = añoFabricacion;
        this.precio = precio;
    }

    public String getMatricula() { return matricula; }
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public String getColor() { return color; }
    public int getAñoFabricacion() { return añoFabricacion; }
    public double getPrecio() { return precio; }

    public void setMarca(String marca) { this.marca = marca; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    public void setColor(String color) { this.color = color; }
    public void setAñoFabricacion(int añoFabricacion) { this.añoFabricacion = añoFabricacion; }
    public void setPrecio(double precio) { this.precio = precio; }

    @Override
    public String toString() {
        return "------------------- \n"
                + "Matricula: " + matricula + "\n"
                + "Marca: " + marca + "\n"
                + "Modelo: " + modelo + "\n"
                + "Color: " + color + "\n"
                + "Año de fabricación: " + añoFabricacion + "\n"
                + "Precio: " + precio + "\n"
                + "-------------------\n";
    }
}

