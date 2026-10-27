package co.edu.uniquindio.poo.empresajfx.controller;

import co.edu.uniquindio.poo.empresajfx.model.Cliente;
import co.edu.uniquindio.poo.empresajfx.model.Empresa;
import co.edu.uniquindio.poo.empresajfx.model.Trabajador;

import java.util.Collection;
import java.util.List;


public class TrabajadorController {
    static Empresa empresa;

    public TrabajadorController(Empresa empresa) {
        this.empresa = empresa;
    }

    public boolean crearTrabajador(Trabajador trabajador) {
        return empresa.agregarTrabajador(trabajador);
    }

    public static List<Trabajador> obtenerListaTrabajadores() {
        return empresa.getListaTrabajadores();
    }

    public boolean eliminarTrabajador(String cedula) {
        return empresa.eliminarTrabajador(cedula);
    }

    public static boolean actualizarTrabajador(String cedula, Trabajador trabajador) {
        return empresa.actualizarTrabajador(cedula, trabajador);
    }
}
