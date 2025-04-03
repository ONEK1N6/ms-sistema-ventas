package pe.edu.upeu.mssistemaventas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pe.edu.upeu.mssistemaventas.entity.Pago;
import pe.edu.upeu.mssistemaventas.service.PagoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/pagos")
public class PagoController {

    @Autowired
    private PagoService service;

    // Método para obtener todos los pagos
    @GetMapping
    public ResponseEntity<List<Pago>> readAll() {
        try {
            List<Pago> pagos = service.readAll();
            if (pagos.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(pagos, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Método para crear un nuevo pago
    @PostMapping
    public ResponseEntity<Pago> crear(@Valid @RequestBody Pago pago) {
        try {
            Pago p = service.create(pago);
            return new ResponseEntity<>(p, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Método para obtener un pago por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Pago> getPagoId(@PathVariable("id") Long id) {
        try {
            Optional<Pago> p = service.read(id);
            if (p.isPresent()) {
                return new ResponseEntity<>(p.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Método para eliminar un pago por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletePago(@PathVariable("id") Long id) {
        try {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Método para actualizar un pago por su ID
    @PutMapping("/{id}")
    public ResponseEntity<Pago> updatePago(@PathVariable("id") Long id, @Valid @RequestBody Pago pago) {
        Optional<Pago> p = service.read(id);
        if (p.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                return new ResponseEntity<>(service.update(pago), HttpStatus.OK);
            } catch (Exception ex) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
}
