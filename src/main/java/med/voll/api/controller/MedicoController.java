package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;
import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    // En testing puede causar problemas usar autowired
    @Autowired
    private MedicoRepository medicoRepository;
    @PostMapping
    public void registraMedico(@RequestBody @Valid Datosregistromedico datosregistromedico) {
        medicoRepository.save(new Medico(datosregistromedico));
    }

    @GetMapping
    public Page<DatosListadoMedico> ListaMedicos(@PageableDefault(size=10) Pageable paginacion) {
        return medicoRepository.findByActivoTrue(paginacion).map(DatosListadoMedico::new);
        //    return medicoRepository.findAll(paginacion).map(DatosListadoMedico::new);
    }

    @PutMapping
    @Transactional
    public void actualizaMedico(@RequestBody @Valid DatosActualizarMedico datosActualizarMedico) {
        Medico medico = medicoRepository.getReferenceById(datosActualizarMedico.id());
        medico.actualizarDatos(datosActualizarMedico);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void eliminaMedico(@PathVariable Long id) {
        Medico medico = medicoRepository.getReferenceById(id);
        medico.desactivarMedico();
        //        medicoRepository.delete(medico);
    }
}