public abstract class Abertura {
    private String marca;
    private String material;
    private double largoMetros;
    private double anchoMetros;

    public abstract double calcularResistencia();

    public Abertura(String marca, String material, double largoMetros, double anchoMetros) {
        this.marca = marca;
        this.material = material;
        this.largoMetros = largoMetros;
        this.anchoMetros = anchoMetros;
    }

    public double getLargoMetros() {
        return largoMetros;
    }

    public double getAnchoMetros() {
        return anchoMetros;
    }

    public String getMaterial() {
        return material;
    }
}
