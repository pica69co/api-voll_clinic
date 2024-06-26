package med.voll.api.direccion;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Direccion {

    private String calle;
    private String numero;
    private String ciudad;
    private String complemento;
    private String distrito;

    public Direccion(DatosDireccion direccion) {
        this.calle = direccion.calle();
        this.numero = direccion.numero();
        this.ciudad = direccion.ciudad();
        this.complemento = direccion.complemento();
        this.distrito = direccion.distrito();
    }

    public Direccion actualizarDatos(DatosDireccion direccion) {
        this.calle = direccion.calle();
        this.numero = direccion.numero();
        this.ciudad = direccion.ciudad();
        this.complemento = direccion.complemento();
        this.distrito = direccion.distrito();
        return this;
    }
}
