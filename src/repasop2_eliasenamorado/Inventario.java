package repasop2_eliasenamorado;

import java.util.ArrayList;

/**
 *
 * @author Elias
 */
class Inventario {
    private ArrayList<Vehiculo> vehiculos;

    public Inventario() {
        this.vehiculos = new ArrayList<>();
    }

    public boolean agregarVehiculo(Vehiculo vehiculo) {
        if (this.vehiculos.size() >= 50) {
            return false;
        }
        this.vehiculos.add(vehiculo);
        return true;
    }

    public ArrayList<Vehiculo> listarVehiculos() {
        ArrayList<Vehiculo> vehiculosOrdenados = new ArrayList(vehiculos);

        for (int i = 0; i < vehiculosOrdenados.size() - 1; i++) {
            for (int j = 0; j < vehiculosOrdenados.size() - i - 1; j++) {
                if (vehiculosOrdenados.get(j).getMarca().equalsIgnoreCase(vehiculosOrdenados.get(j + 1).getMarca())) {
                    Vehiculo temp = vehiculosOrdenados.get(j);
                    vehiculosOrdenados.set(j, vehiculosOrdenados.get(j + 1));
                    vehiculosOrdenados.set(j + 1, temp);
                }
            }
        }

        return vehiculosOrdenados;
    }

    public Vehiculo buscarVehiculoPorMatricula(String matricula) {
        for (Vehiculo v : this.vehiculos) {
            if (v.getMatricula().equalsIgnoreCase(matricula)) {
                return v;
            }
        }
        return null;
    }

    public boolean eliminarVehiculo(String matricula) {
        Vehiculo vehiculo = buscarVehiculoPorMatricula(matricula);
        if (vehiculo != null) {
            this.vehiculos.remove(vehiculo);
            return true;
        }
        return false;
    }

    public Vehiculo obtenerVehiculoMasAntiguo() {
        if (this.vehiculos.isEmpty()) {
            return null;
        }
        
        Vehiculo masAntiguo = this.vehiculos.get(0);
        for (int i = 1; i < this.vehiculos.size(); i++) {
            if (this.vehiculos.get(i).getAñoFabricacion() < masAntiguo.getAñoFabricacion()) {
                masAntiguo = this.vehiculos.get(i);
            }
        }
        return masAntiguo;
    }

    public ArrayList<Vehiculo> obtenerVehiculosDeColor(String color) {
        ArrayList<Vehiculo> vehiculosColor = new ArrayList<>();
        for (Vehiculo v : this.vehiculos) {
            if (v.getColor().equalsIgnoreCase(color)) {
                vehiculosColor.add(v);
            }
        }
        return vehiculosColor;
    }

    public int diferenciaAños(String matricula1, String matricula2) {
        Vehiculo vehiculo1 = buscarVehiculoPorMatricula(matricula1);
        Vehiculo vehiculo2 = buscarVehiculoPorMatricula(matricula2);
        if (vehiculo1 != null && vehiculo2 != null) {
            int diferencia = vehiculo1.getAñoFabricacion() - vehiculo2.getAñoFabricacion();
            if (diferencia < 0) {
                diferencia = -diferencia;
            }
            return diferencia;
        }
        return -1;
    }

}