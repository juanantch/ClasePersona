/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasepersona;

import java.time.DateTimeException;
import java.time.LocalDate;


/**
 *
 * @author ciclos
 */
public class Persona {
    private String nombre;
    private String apellidos;
    private LocalDate fechaNacimiento;

    public Persona(String nombre, String apellidos) {

        if ("".equals(nombre) || "".equals(apellidos)) {
            throw new IllegalArgumentException();
        } else {
            this.nombre = nombre;
            this.apellidos = apellidos;
        }

    }

    public Persona(String nombre, String apellidos, String fechaNacimiento) throws IllegalArgumentException {

        if ("".equals(nombre) || "".equals(apellidos)) {
            throw new IllegalArgumentException();
        } else {
            this.nombre = nombre;
            this.apellidos = apellidos;
            this.fechaNacimiento = generarFecha(fechaNacimiento);
        }

    }

    private LocalDate generarFecha(String fechaNacimiento) {
        int dia;
        int mes;
        int anyo;

        if (!fechaNacimiento.matches("\\d{2}/\\d{2}/\\d{4}") && !fechaNacimiento.matches("\\d{2}-\\d{2}-\\d{4}")) {
            throw new IllegalArgumentException();

        }

        try {
            dia = Integer.parseInt(fechaNacimiento.subSequence(0, 2).toString());
            mes = Integer.parseInt(fechaNacimiento.subSequence(3, 5).toString());
            anyo = Integer.parseInt(fechaNacimiento.subSequence(6, fechaNacimiento.length()).toString());
            return LocalDate.of(anyo, mes, dia);

        } catch (NumberFormatException | DateTimeException ex1) {
            throw new IllegalArgumentException();
        }

    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getFechaNacimiento(char separador) {
        String fecha = null;

        if (separador != '-' && separador != '/') {
            throw new IllegalArgumentException();
        } else {
            if (this.fechaNacimiento != null) {
                fecha = String.format("%02d%c%02d%c%04d", this.fechaNacimiento.getDayOfMonth(), separador,
                        this.fechaNacimiento.getMonthValue(), separador,
                        this.fechaNacimiento.getYear());
            }
            return fecha;
        }
    }

    public String getFechaNacimiento() {
        return getFechaNacimiento('-');
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = generarFecha(fechaNacimiento);
    }
    public String EJERCICIO5() {
        return nombre;
    }
}
