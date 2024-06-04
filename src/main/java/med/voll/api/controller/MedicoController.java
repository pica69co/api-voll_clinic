package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.Datosregistromedico;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}