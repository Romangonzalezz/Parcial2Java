public class Ventana extends Abertura{
    private String tipoV;

    @Override
    public double calcularResistencia() {
        double resistencia = super.getLargoMetros() * super.getAnchoMetros();

        if (super.getMaterial().equalsIgnoreCase("Madera")) {
            resistencia *= 1.8;
        } else if (super.getMaterial().equalsIgnoreCase("Aluminio")) {
            resistencia *= 1.2;
        } else if (super.getMaterial().equalsIgnoreCase("Chapa")) {
            resistencia *= 2.2;
        }

        return resistencia;
    }

    public Ventana(String marca, String material, double largoMetros, double anchoMetros, String tipoV) {
        super(marca, material, largoMetros, anchoMetros);
        this.tipoV = tipoV;
    }

    public String getTipoV() {
        return tipoV;
    }
}
