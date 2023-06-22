public class PuertaVentana extends Abertura {
    private int cantidadHojas;
    private String tipoPV;

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
    public PuertaVentana(String marca, String material, double largoMetros, double anchoMetros, int cantidadHojas, String tipoPV) {
        super(marca, material, largoMetros, anchoMetros);
        this.cantidadHojas = cantidadHojas;
        this.tipoPV = tipoPV;
    }

    public int getCantidadHojas() {
        return cantidadHojas;
    }

    public String getTipoPV() {
        return tipoPV;
    }
}
