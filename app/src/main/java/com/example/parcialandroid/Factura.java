package com.example.parcialandroid;

public class Factura {

    interface Pagable {
        double calcularTotal();
    }

    abstract class ElementoFacturable implements Pagable {
        protected String descripcion;
        protected double precioUnitario;
        protected int cantidad;

        public ElementoFacturable(String descripcion, double precioUnitario, int cantidad) {
            this.descripcion = descripcion;
            this.precioUnitario = precioUnitario;
            this.cantidad = cantidad;
        }

        public double calcularSubtotal() {
            return precioUnitario * cantidad;
        }

        public abstract String getDescripcion();
    }

    class Servicio extends ElementoFacturable {
        public Servicio(String descripcion, double precioUnitario, int cantidad) {
            super(descripcion, precioUnitario, cantidad);
        }

        public String getDescripcion() {
            return descripcion;
        }

        public double calcularTotal() {
            return calcularSubtotal();
        }
    }

    class Producto extends ElementoFacturable {
        // Constructor
        public Producto(String descripcion, double precioUnitario, int cantidad) {
            super(descripcion, precioUnitario, cantidad);
        }

        public String getDescripcion() {
            return descripcion;
        }
        public double calcularTotal() {
            return calcularSubtotal();
        }
    }

    class Factura implements Pagable {
        private ElementoFacturable[] elementos;
        private int cantidadElementos;

        public Factura(int capacidadMaxima) {
            elementos = new ElementoFacturable[capacidadMaxima];
            cantidadElementos = 0;
        }
        public void agregarElemento(ElementoFacturable elemento) {
            if (cantidadElementos < elementos.length) {
                elementos[cantidadElementos] = elemento;
                cantidadElementos++;
            } else {
                System.out.println("La factura esta llena no se pueden agregar mas elementos.");
            }
        }

        public double calcularTotal() {
            double total = 0;
            for (ElementoFacturable elemento : elementos) {
                if (elemento != null) {
                    total += elemento.calcularTotal();
                }
            }
            return total;
        }
    }

    public class Main {
        public static void main(String[] args) {
            // Crear algunos elementos facturables
            Servicio servicio1 = new Servicio("Mantenimiento", 500, 2);
            Producto producto1 = new Producto("Laptop", 8000, 1);
            Factura factura = new Factura(10);
            factura.agregarElemento(servicio1);
            factura.agregarElemento(producto1);

            double totalFactura = factura.calcularTotal();
            System.out.println("Total de la factura: " + totalFactura);
        }
    }
}
