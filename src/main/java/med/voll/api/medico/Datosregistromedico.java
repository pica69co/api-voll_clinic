package med.voll.api.medico;

import med.voll.api.direccion.DatosDireccion;

public record Datosregistromedico(
        String nombre,
        String email,
        Especialidad especialidad,
        DatosDireccion direccion) {

}
