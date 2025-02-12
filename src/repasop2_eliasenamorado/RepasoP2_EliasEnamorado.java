package repasop2_eliasenamorado;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Elias Enamorado
 */
public class RepasoP2_EliasEnamorado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         String[] opcionesPrincipales = {"Ejercicio #1: Inventario de Vehículos", "Ejercicio #2: Recursividad", "Salir"};

        while (true) {
            String opcionPrincipal = (String) JOptionPane.showInputDialog(null, "Seleccione un ejercicio:", "Menú Principal", JOptionPane.QUESTION_MESSAGE, null, opcionesPrincipales, opcionesPrincipales[0]);
            
            if (opcionPrincipal == null || opcionPrincipal.equals("Salir")) {
                break;
            }
            
            switch (opcionPrincipal) {
                case "Ejercicio #1: Inventario de Vehículos":
                    ejercicioInventarioVehiculos();
                    break;
                case "Ejercicio #2: Recursividad":
                    ejercicioRecursividad();
                    break;
            }
        }
        
    }
    
    private static void ejercicioInventarioVehiculos() {
        Inventario inventario = new Inventario();
        String[] opciones = {"Agregar", "Listar", "Modificar", "Eliminar", "Vehículo más antiguo", "Vehículos de color rojo", "Diferencia de años entre 2 vehículos", "Salir"};

        while (true) {
            String opcion = (String) JOptionPane.showInputDialog(null, "Seleccione una opción:", "Inventario de Vehículos", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
            if (opcion == null || opcion.equals("Salir")) {
                break;
            }
            
            switch (opcion) {
                case "Agregar":
                   
                    if (inventario.listarVehiculos().size() >= 50) {
                        JOptionPane.showMessageDialog(null, "No se puede agregar más vehículos, el inventario está lleno.");
                        break;
                    }
                  
                    String matricula = JOptionPane.showInputDialog("Ingrese la matrícula:");
                    String marca = JOptionPane.showInputDialog("Ingrese la marca:");
                    String modelo = JOptionPane.showInputDialog("Ingrese el modelo:");
                    String color = JOptionPane.showInputDialog("Ingrese el color:");
                    int añoFabricacion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el año de fabricación:"));
                    double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio:"));
                    Vehiculo nuevoVehiculo = new Vehiculo(matricula, marca, modelo, color, añoFabricacion, precio);
                    inventario.agregarVehiculo(nuevoVehiculo);
                    break;
                    
                case "Listar":
                    ArrayList<Vehiculo> vehiculos = inventario.listarVehiculos();
                    String listado = "";
                    if (vehiculos.isEmpty()) {
                        listado = "No hay vehículos en el inventario, añade vehículos desde el menú.";
                    } else {
                        for (Vehiculo v : vehiculos) {
                            listado += v.toString() + "\n";
                        }
                    }
                    JOptionPane.showMessageDialog(null, listado);
                    break;
                    
                case "Modificar":
                    matricula = JOptionPane.showInputDialog("Ingrese la matrícula del vehículo a modificar:");
                    Vehiculo vehiculo = inventario.buscarVehiculoPorMatricula(matricula);
                    if (vehiculo != null) {
                        marca = JOptionPane.showInputDialog("Ingrese la nueva marca:", vehiculo.getMarca());
                        modelo = JOptionPane.showInputDialog("Ingrese el nuevo modelo:", vehiculo.getModelo());
                        color = JOptionPane.showInputDialog("Ingrese el nuevo color:", vehiculo.getColor());
                        añoFabricacion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo año de fabricación:", vehiculo.getAñoFabricacion()));
                        precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el nuevo precio:", vehiculo.getPrecio()));
                        vehiculo.setMarca(marca);
                        vehiculo.setModelo(modelo);
                        vehiculo.setColor(color);
                        vehiculo.setAñoFabricacion(añoFabricacion);
                        vehiculo.setPrecio(precio);
                    } else {
                        JOptionPane.showMessageDialog(null, "Vehículo no encontrado.");
                    }
                    break;
                    
                case "Eliminar":
                    matricula = JOptionPane.showInputDialog("Ingrese la matrícula del vehículo a eliminar:");
                    if (inventario.eliminarVehiculo(matricula)) {
                        JOptionPane.showMessageDialog(null, "Vehículo eliminado.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Vehículo no encontrado.");
                    }
                    break;
                    
                case "Vehículo más antiguo":
                    vehiculo = inventario.obtenerVehiculoMasAntiguo();
                    if (vehiculo != null) {
                        JOptionPane.showMessageDialog(null, vehiculo.toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "No hay vehículos en el inventario.");
                    }
                    break;
                    
                case "Vehículos de color rojo":
                    ArrayList<Vehiculo> vehiculosRojos = inventario.obtenerVehiculosDeColor("rojo");
                    String listadoRojos = "";
                    for (Vehiculo v : vehiculosRojos) {
                        listadoRojos += v.toString() + "\n";
                    }
                    JOptionPane.showMessageDialog(null, listadoRojos);
                    break;
                    
                case "Diferencia de años entre 2 vehículos":
                    String matricula1 = JOptionPane.showInputDialog("Ingrese la matrícula del primer vehículo:");
                    String matricula2 = JOptionPane.showInputDialog("Ingrese la matrícula del segundo vehículo:");
                    int diferencia = inventario.diferenciaAños(matricula1, matricula2);
                    if (diferencia != -1) {
                        JOptionPane.showMessageDialog(null, "La diferencia de años entre los vehículos es: " + diferencia + " años.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Uno o ambos vehículos no fueron encontrados.");
                    }
                    break;
                    
            }
        }
        
    }
    
    private static void ejercicioRecursividad() {
        String[] opcionesRecursividad = {"Decimal a Binario", "Máximo Común Divisor", "Fibonacci", "Búsqueda Binaria", "Volver al menú principal"};

        while (true) {
            String opcion = (String) JOptionPane.showInputDialog(null, "Seleccione una opción:", "Ejercicios de Recursividad", JOptionPane.QUESTION_MESSAGE, null, opcionesRecursividad, opcionesRecursividad[0]);
            
            if (opcion == null || opcion.equals("Volver al menú principal")) {
                break;
            }
            
            switch (opcion) {
                case "Decimal a Binario":
                    int decimal = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un número decimal:"));
                    JOptionPane.showMessageDialog(null, "Binario: " + Recursividad.decimalABinario(decimal));
                    break;
                case "Máximo Común Divisor":
                    int a = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el primer número:"));
                    int b = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el segundo número:"));
                    JOptionPane.showMessageDialog(null, "MCD: " + Recursividad.mcd(a, b));
                    break;
                case "Fibonacci":
                    int n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la posición del término de Fibonacci:"));
                    JOptionPane.showMessageDialog(null, "Término " + n + " de Fibonacci: " + Recursividad.fibonacci(n));
                    break;
                case "Búsqueda Binaria":
                    ArrayList<Integer> listaNumeros = new ArrayList<>();
                    String numerosIngresados = "Números ingresados: ";
                    int numero;
                    do {
                        String input = JOptionPane.showInputDialog("Ingrese un número para el arreglo (o -1 para terminar):\nNúmeros ingresados hasta ahora: " + listaNumeros.size() + "\n" + numerosIngresados);
                        numero = Integer.parseInt(input);
                        if (numero != -1) {
                            listaNumeros.add(numero);
                            numerosIngresados += numero + " ";
                        }
                    } while (numero != -1);

                    if (listaNumeros.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No se ingresaron números.");
                        break;
                    }

                    int[] arreglo = new int[listaNumeros.size()];
                    for (int i = 0; i < listaNumeros.size(); i++) {
                        arreglo[i] = listaNumeros.get(i);
                    }

                    int objetivo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el elemento a buscar:"));
                    int resultado = Recursividad.busquedaBinaria(arreglo, 0, arreglo.length - 1, objetivo);
                    if (resultado == -1) {
                        JOptionPane.showMessageDialog(null, "Elemento no presente en el arreglo");
                    } else {
                        JOptionPane.showMessageDialog(null, "Elemento encontrado en el índice: " + resultado);
                    }
                    
                    break;
            }
        }
    }
            
}
