
import java.util.*;
import java.time.LocalDateTime;

public class SistemaCompleto {

    // ===================== UTILIDAD ===========================
    public static double distanciaEuclidiana(double[] a, double[] b) {
        double dx = a[0] - b[0];
        double dy = a[1] - b[1];
        return Math.sqrt(dx*dx + dy*dy);
    }

    // ====================== MODELOS ============================

    // -------- Usuario y subtipos --------
    static class Usuario {
        protected String id;
        protected String nombre;
        protected String telefono;
        protected String correo;

        public Usuario(String nombre, String telefono, String correo) {
            this.id = UUID.randomUUID().toString();
            this.nombre = nombre;
            this.telefono = telefono;
            this.correo = correo;
        }
    }

    static class Cliente extends Usuario {
        public Cliente(String nombre, String telefono, String correo) {
            super(nombre, telefono, correo);
        }
    }

    static class Recolector extends Usuario {
        public Recolector(String nombre, String telefono, String correo) {
            super(nombre, telefono, correo);
        }
    }

    static class JefeDeZona extends Usuario {
        public JefeDeZona(String nombre, String telefono, String correo) {
            super(nombre, telefono, correo);
        }
    }

    // -------- Ubicación --------
    static class Ubicacion {
        private String direccionTexto;
        private double[] coordenadas;
        private boolean esValida;

        public Ubicacion(String direccionTexto, double[] coordenadas, boolean esValida) {
            this.direccionTexto = direccionTexto;
            this.coordenadas = coordenadas;
            this.esValida = esValida;
        }

        public double[] getCoordenadas() {
            return coordenadas;
        }

        public boolean esValida() {
            return esValida;
        }
    }

    // -------- Notificación --------
    static class Notificacion {
        private String tipo;
        private String mensaje;
        private LocalDateTime fecha;

        public Notificacion(String tipo, String mensaje) {
            this.tipo = tipo;
            this.mensaje = mensaje;
            this.fecha = LocalDateTime.now();
        }
    }

    // -------- Comprobante --------
    static class Comprobante {
        private String id;
        private LocalDateTime fechaEmision;
        private String contenido;

        public Comprobante(String contenido) {
            this.id = UUID.randomUUID().toString();
            this.fechaEmision = LocalDateTime.now();
            this.contenido = contenido;
        }
    }

    // -------- Pedido --------
    static class Pedido {
        private String id;
        private Cliente cliente;
        private String tipoMaterial;
        private double cantidadEstimada;
        private String horaPreferida;
        private int prioridad;

        private String estado;
        private Ubicacion ubicacion;
        private List<Notificacion> notificaciones;
        private Comprobante comprobante;

        public Pedido(Cliente cliente, String tipoMaterial, double cantidadEstimada,
                      String horaPreferida, int prioridad) {

            this.id = UUID.randomUUID().toString();
            this.cliente = cliente;
            this.tipoMaterial = tipoMaterial;
            this.cantidadEstimada = cantidadEstimada;
            this.horaPreferida = horaPreferida;
            this.prioridad = prioridad;

            this.estado = "pendiente";
            this.notificaciones = new ArrayList<>();
        }

        public Ubicacion getUbicacionAsociada() {
            return ubicacion;
        }

        public int getPrioridad() {
            return prioridad;
        }

        public void agregarNotificacion(String tipo, String mensaje) {
            notificaciones.add(new Notificacion(tipo, mensaje));
        }

        public void asociarUbicacion(Ubicacion ubicacion) {
            this.ubicacion = ubicacion;
        }

        public void setEstado(String estado) {
            this.estado = estado;
        }

        public void setComprobante(Comprobante comprobante) {
            this.comprobante = comprobante;
        }
    }

    // ======================= LÓGICA ===============================

    // -------- Ruta --------
    static class Ruta {
        private String id;
        private List<Pedido> pedidos;

        private double distanciaTotal;
        private double duracionEstimada;
        private String estado;

        public Ruta(String id) {
            this.id = id;
            this.pedidos = new ArrayList<>();
            this.estado = "planificada";
        }

        public void incluirPedido(Pedido pedido) {
            if (!pedidos.contains(pedido)) pedidos.add(pedido);
        }

        public void actualizarMetricas(double[] coords, int prioridad) {
            // Lógica interna
        }

        public double calcularEficiencia() {
            List<double[]> coords = new ArrayList<>();

            for (Pedido p : pedidos) {
                if (p.getUbicacionAsociada() != null)
                    coords.add(p.getUbicacionAsociada().getCoordenadas());
            }

            if (coords.size() < 2) return 0;

            double dist = 0;
            for (int i = 0; i < coords.size() - 1; i++) {
                dist += SistemaCompleto.distanciaEuclidiana(coords.get(i), coords.get(i + 1));

                int prio = pedidos.get(i).getPrioridad();
                actualizarMetricas(coords.get(i), prio);
            }

            this.distanciaTotal = dist;
            this.duracionEstimada = dist * 10;

            return dist > 0 ? 1 / dist : Double.POSITIVE_INFINITY;
        }
    }

    // -------- Controlador Zona --------
    static class ControladorZona {
        private String idZona;

        public ControladorZona(String idZona) {
            this.idZona = idZona;
        }

        public double calcularEficiencia(Ruta ruta) {
            return ruta.calcularEficiencia();
        }
    }

    // -------- Sistema --------
    static class Sistema {
        private Map<String, Pedido> pedidos = new HashMap<>();

        public Pedido solicitarRetiro(Cliente cliente, String tipoMaterial, double cantidad,
                                      String horaPreferida, int prioridad) {

            Pedido pedido = new Pedido(cliente, tipoMaterial, cantidad, horaPreferida, prioridad);
            pedidos.put(pedido.toString(), pedido);

            pedido.agregarNotificacion("confirmacion", "Pedido creado correctamente");
            return pedido;
        }

        public void asociarUbicacion(Pedido pedido, Ubicacion ubicacion) {
            pedido.asociarUbicacion(ubicacion);

            if (ubicacion.esValida()) {
                pedido.setEstado("ubicacion_validada");
                pedido.agregarNotificacion("ubicacion", "Ubicación validada");
            } else {
                pedido.setEstado("ubicacion_invalida");
                pedido.agregarNotificacion("ubicacion", "Ubicación inválida");
            }
        }

        public Comprobante finalizarRecoleccion(Pedido pedido, String contenido) {
            pedido.setEstado("finalizado");

            Comprobante comp = new Comprobante(contenido);
            pedido.setComprobante(comp);

            pedido.agregarNotificacion("finalizacion", "Recolección finalizada");

            return comp;
        }
    }

    // ========================== MAIN =============================
    public static void main(String[] args) {

        Sistema sistema = new Sistema();

        Cliente cliente = new Cliente("Ana", "+5691111", "ana@example.com");

        Pedido p1 = sistema.solicitarRetiro(cliente, "papel", 5, "09:00", 1);
        Pedido p2 = sistema.solicitarRetiro(cliente, "plástico", 3, "10:00", 2);

        Ubicacion u1 = new Ubicacion("Calle A 123", new double[]{-37.0, -72.0}, true);
        Ubicacion u2 = new Ubicacion("Calle B 456", new double[]{-37.01, -72.02}, true);

        sistema.asociarUbicacion(p1, u1);
        sistema.asociarUbicacion(p2, u2);

        Ruta ruta = new Ruta("ruta-1");
        ruta.incluirPedido(p1);
        ruta.incluirPedido(p2);

        ControladorZona cz = new ControladorZona("zona-1");
        double eficiencia = cz.calcularEficiencia(ruta);

        System.out.println("Eficiencia calculada = " + eficiencia);
    }
}
