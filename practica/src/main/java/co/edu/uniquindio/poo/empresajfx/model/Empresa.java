package co.edu.uniquindio.poo.empresajfx.model;

import java.util.*;

public class Empresa {
    private String nombre;
    private Collection<Cliente> clientes;
    private List<Trabajador> listaTrabajadores= new ArrayList<>();

    public Empresa(String nombre) {
        this.nombre = nombre;
        clientes = new LinkedList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Collection<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(Collection<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Trabajador> getListaTrabajadores() {
        return listaTrabajadores;
    }

    public void setListaTrabajadores(List<Trabajador> listaTrabajadores) {
        this.listaTrabajadores = listaTrabajadores;
    }

    public boolean agregarCliente(Cliente cliente) {
        boolean centinela = false;
        if (!verificarCliente(cliente.getCedula())) {
            clientes.add(cliente);
            centinela = true;
        }
        return centinela;
    }

    public boolean eliminarCliente(String cedula) {
        boolean centinela = false;
        for (Cliente cliente : clientes) {
            if (cliente.getCedula().equals(cedula)) {
                clientes.remove(cliente);
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean actualizarCliente(String cedula, Cliente actualizado) {
        boolean centinela = false;
        for (Cliente cliente : clientes) {
            if (cliente.getCedula().equals(cedula)) {
                cliente.setCedula(actualizado.getCedula());
                cliente.setNombre(actualizado.getNombre());
                cliente.setApellido(actualizado.getApellido());
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean verificarCliente(String cedula) {
        boolean centinela = false;
        for (Cliente cliente : clientes) {
            if (cliente.getCedula().equals(cedula)) {
                centinela = true;
            }
        }
        return centinela;
    }

    public boolean agregarTrabajador(Trabajador trabajador) {
        boolean centinela = false;
        if (!verificarTrabajador(trabajador.getCedula())) {
            listaTrabajadores.add(trabajador);
            centinela = true;
        }
        return centinela;
    }

    public boolean eliminarTrabajador(String cedula) {
        boolean centinela = false;
        for (Trabajador trabajador: listaTrabajadores) {
            if (trabajador.getCedula().equals(cedula)) {
                listaTrabajadores.remove(trabajador);
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean actualizarTrabajador(String cedula, Trabajador actualizado) {
        boolean centinela = false;
        for (Trabajador trabajador: listaTrabajadores) {
            if (trabajador.getCedula().equals(cedula)) {
                trabajador.setCedula(actualizado.getCedula());
                trabajador.setNombre(actualizado.getNombre());
                trabajador.setApellido(actualizado.getApellido());
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean verificarTrabajador(String cedula) {
        boolean centinela = false;
        for (Trabajador trabajador: listaTrabajadores) {
            if (trabajador.getCedula().equals(cedula)) {
                centinela = true;
            }
        }
        return centinela;
    }


}

