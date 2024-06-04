package med.voll.api.medico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.direccion.Direccion;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    private String documento;
    private String telefono;
    @Enumerated(EnumType.STRING)
    private Especialidad especialidad;
    @Embedded
    private Direccion direccion;

    public Medico(Datosregistromedico datosregistromedico) {
        this.nombre = datosregistromedico.nombre();
        this.email = datosregistromedico.email();
        this.documento = datosregistromedico.documento();
        this.telefono = datosregistromedico.telefono();
        this.especialidad = datosregistromedico.especialidad();
        this.direccion = new Direccion(datosregistromedico.direccion());
    }
}
