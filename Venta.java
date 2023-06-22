import java.util.ArrayList;
import java.util.Scanner;

public class Venta {
    private static ArrayList<Venta> listaVentas = new ArrayList<>();
    private Abertura abertura;
    private Cliente cliente;

    private double precioVenta;

    public void ingresarDatosAbertura() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Tipo de abertura (puerta, ventana, puertaVentana): ");
        String tipoAbertura = scanner.next();

        if (!tipoAbertura.equalsIgnoreCase("puertaVentana") && !tipoAbertura.equalsIgnoreCase("ventana") && !tipoAbertura.equalsIgnoreCase("puerta")) {
            System.out.println("Error, no se puede continuar chequea los datos ingresados!");
            return;
        }

        System.out.print("Marca: (Esteban, Oblack)");
        String marca = scanner.next();

        if (!marca.equalsIgnoreCase("Esteban") && !marca.equalsIgnoreCase("Oblack")) {
            System.out.println("Error, no se puede continuar chequea los datos ingresados!");
            return;
        }

        System.out.println("Material: (Madera, Aluminio, Chapa)");
        String material = scanner.next();

        if (!material.equalsIgnoreCase("Madera") && !material.equalsIgnoreCase("Aluminio") && !material.equalsIgnoreCase("Chapa")) {
            System.out.println("Error, no se puede continuar chequea los datos ingresados!");
            return;
        }

        System.out.println("Largo: (metros)");
        double largoMetros = scanner.nextDouble();

        System.out.println("Ancho: (metros)");
        double anchoMetros = scanner.nextDouble();

        if (tipoAbertura.equalsIgnoreCase("puerta")) {
            System.out.print("Lado de la puerta (derecha, izquierda): ");
            String lado = scanner.next();

            if (!lado.equalsIgnoreCase("derecha") && !lado.equalsIgnoreCase("izquierda")) {
                System.out.println("Dato inválido, no se puede continuar.");
                return;
            }

            System.out.print("Espesor: ");
            int espesor = scanner.nextInt();

            System.out.print("Apellido: ");
            String apellido = scanner.next();

            System.out.print("Email: ");
            String email = scanner.next();

            System.out.print("DNI: ");
            String dni = scanner.next();

            System.out.print("Precio total: ");
            double precioTotal = scanner.nextDouble();

            Cliente clienteNuevo = new Cliente(apellido, email, dni);

            Puerta puerta = new Puerta(marca, material, largoMetros, anchoMetros, espesor, lado);
            Venta venta = new Venta(puerta, clienteNuevo, precioTotal);
            listaVentas.add(venta);

        } else if (tipoAbertura.equalsIgnoreCase("ventana")) {
            System.out.print("Tipo de vidrio (esmerilado, comun): ");
            String tipoVidrio = scanner.next();

            System.out.print("Apellido: ");
            String apellido = scanner.next();

            System.out.print("Email: ");
            String email = scanner.next();

            System.out.print("DNI: ");
            String dni = scanner.next();

            System.out.print("Precio total: ");
            double precioTotal = scanner.nextDouble();

            Cliente clienteNuevo = new Cliente(apellido, email, dni);

            Ventana ventana = new Ventana(marca, material, largoMetros, anchoMetros, tipoVidrio);
            Venta venta = new Venta(ventana, clienteNuevo, precioTotal);
            listaVentas.add(venta);

        } else if (tipoAbertura.equalsIgnoreCase("puertaVentana")) {
            System.out.print("Tipo de apertura (corrediza, abrir): ");
            String tipoPV = scanner.next();

            System.out.print("Cantidad de hojas: ");
            int cantidadHojas = scanner.nextInt();

            System.out.print("Apellido: ");
            String apellido = scanner.next();

            System.out.print("Email: ");
            String email = scanner.next();

            System.out.print("DNI: ");
            String dni = scanner.next();

            System.out.print("Precio total: ");
            double precioTotal = scanner.nextDouble();

            Cliente clienteNuevo = new Cliente(apellido, email, dni);

            PuertaVentana puertaVentana = new PuertaVentana(marca, material, largoMetros, anchoMetros, cantidadHojas, tipoPV);
            Venta venta = new Venta(puertaVentana, clienteNuevo, precioTotal);
            listaVentas.add(venta);

        }
    }

    public void listarAberturasVendidas(){
        if (listaVentas.size() == 0){
            System.out.println("Error no hay ventas registradas..");
            return;
        }

        for (Venta venta : listaVentas) {
            Abertura abertura = venta.getAbertura();

            if (abertura instanceof Puerta) {
                Puerta puerta = (Puerta) abertura;
                System.out.println("Abertura: Puerta");
                System.out.println("Largo: " + puerta.getLargoMetros());
                System.out.println("Ancho: " + puerta.getAnchoMetros());
                System.out.println("Lado de la puerta: " + puerta.getLadoP());
                System.out.println("Espesor: " + puerta.getEspesor());
                System.out.println("Resistencia: " + puerta.calcularResistencia());
                System.out.println("-------------------------");

            } else if (abertura instanceof Ventana) {
                Ventana ventana = (Ventana) abertura;
                System.out.println("Abertura: Ventana");
                System.out.println("Largo: " + ventana.getLargoMetros());
                System.out.println("Ancho: " + ventana.getAnchoMetros());
                System.out.println("Tipo de vidrio: " + ventana.getTipoV());
                System.out.println("Resistencia: " + ventana.calcularResistencia());
                System.out.println("-------------------------");

            } else if (abertura instanceof PuertaVentana) {
                PuertaVentana puertaVentana = (PuertaVentana) abertura;
                System.out.println("Abertura: Puerta Ventana");
                System.out.println("Largo: " + puertaVentana.getLargoMetros());
                System.out.println("Ancho: " + puertaVentana.getAnchoMetros());
                System.out.println("Tipo de apertura: " + puertaVentana.getTipoPV());
                System.out.println("Cantidad de hojas: " + puertaVentana.getCantidadHojas());
                System.out.println("Resistencia: " + puertaVentana.calcularResistencia());
                System.out.println("-------------------------");

            }

            System.out.println("Cliente: ");
            Cliente cliente = venta.getCliente();

            System.out.println("Apellido: " + cliente.getApellido());
            System.out.println("Email: " + cliente.getEmail());
            System.out.println("DNI: " + cliente.getDNI());

            System.out.println("-------------------------");
            System.out.println("Precio Venta: ");
            System.out.println(venta.getPrecioVenta());

        }

    }

    public void calcularPromedio(){
        if (listaVentas.size() == 0){
            System.out.println("Error no hay ventas registradas..");
            return;
        }

        int contadorPrecio = 0;

        for (Venta venta : listaVentas) {
            contadorPrecio += venta.getPrecioVenta();
        }

        int promedio = contadorPrecio / listaVentas.size();
        System.out.println("El promedio es de: " + promedio);
    }

    public Venta() {

    }

    public Venta(Abertura abertura, Cliente cliente, double precioVenta) {
        this.abertura = abertura;
        this.cliente = cliente;
        this.precioVenta = precioVenta;
    }


    public Abertura getAbertura() {
        return abertura;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }
}
