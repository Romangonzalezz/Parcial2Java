public class Puerta extends Abertura{
    private int espesor;
    private String ladoP;

    @Override
    public double calcularResistencia() {
        double resistencia = super.getLargoMetros() * super.getAnchoMetros();

        if (super.getMaterial().equalsIgnoreCase("Madera")) {
            resistencia *= 1.8 + espesor;
        } else if (super.getMaterial().equalsIgnoreCase("Aluminio")) {
            resistencia *= 1.2 + espesor;
        } else if (super.getMaterial().equalsIgnoreCase("Chapa")) {
            resistencia *= 2.2 + espesor;
        }

        return resistencia;
    }

    public Puerta(String marca, String material, double largoMetros, double anchoMetros, int espesor, String ladoP) {
        super(marca, material, largoMetros, anchoMetros);
        this.espesor = espesor;
        this.ladoP = ladoP;
    }

    public int getEspesor() {
        return espesor;
    }

    public String getLadoP() {
        return ladoP;
    }
}
