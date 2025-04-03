package pe.edu.upeu.mssistemaventas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pe.edu.upeu.mssistemaventas.entity.Envio;
import pe.edu.upeu.mssistemaventas.service.EnvioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/envios")
public class EnvioController {

    @Autowired
    private EnvioService service;

    // Método para obtener todos los envíos
    @GetMapping
    public ResponseEntity<List<Envio>> readAll() {
        try {
            List<Envio> envios = service.readAll();
            if (envios.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(envios, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Método para crear un nuevo envío
    @PostMapping
    public ResponseEntity<Envio> crear(@Valid @RequestBody Envio envio) {
        try {
            Envio e = service.create(envio);
            return new ResponseEntity<>(e, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Método para obtener un envío por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Envio> getEnvioId(@PathVariable("id") Long id) {
        try {
            Optional<Envio> e = service.read(id);
            if (e.isPresent()) {
                return new ResponseEntity<>(e.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Método para eliminar un envío por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteEnvio(@PathVariable("id") Long id) {
        try {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Método para actualizar un envío por su ID
    @PutMapping("/{id}")
    public ResponseEntity<Envio> updateEnvio(@PathVariable("id") Long id, @Valid @RequestBody Envio envio) {
        Optional<Envio> e = service.read(id);
        if (e.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                return new ResponseEntity<>(service.update(envio), HttpStatus.OK);
            } catch (Exception ex) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
}
