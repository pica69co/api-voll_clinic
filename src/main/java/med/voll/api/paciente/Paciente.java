package med.voll.api.paciente;

import jakarta.persistence.*;
import med.voll.api.direccion.Direccion;

@Entity(name = "Paciente")
@Table(name = "pacientes")
public class Paciente {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String email;
    private String documentoIdentidad;
    private String telefono;
    @Embedded
    private Direccion direccion;

    public Paciente(DatosRegistroPaciente datos) {
        this.nombre = datos.nombre();
        this.email = datos.email();
        this.documentoIdentidad = datos.documentoIdentidad();
        this.telefono = datos.telefono();
        this.direccion = new Direccion(datos.direccion());
    }
}