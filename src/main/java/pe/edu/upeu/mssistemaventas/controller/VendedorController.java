package pe.edu.upeu.mssistemaventas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.upeu.mssistemaventas.entity.Vendedor;
import pe.edu.upeu.mssistemaventas.service.VendedorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/vendedores")
public class VendedorController {

    @Autowired
    private VendedorService service;

    // Método para obtener todos los vendedores
    @GetMapping
    public ResponseEntity<List<Vendedor>> readAll() {
        try {
            List<Vendedor> vendedores = service.readAll();
            if (vendedores.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(vendedores, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Método para crear un nuevo vendedor
    @PostMapping
    public ResponseEntity<Vendedor> crear(@Valid @RequestBody Vendedor vendedor) {
        try {
            Vendedor v = service.create(vendedor);
            return new ResponseEntity<>(v, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Método para obtener un vendedor por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Vendedor> getVendedorId(@PathVariable("id") Long id) {
        try {
            Optional<Vendedor> v = service.read(id);
            if (v.isPresent()) {
                return new ResponseEntity<>(v.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Método para eliminar un vendedor por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteVendedor(@PathVariable("id") Long id) {
        try {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Método para actualizar un vendedor por su ID
    @PutMapping("/{id}")
    public ResponseEntity<Vendedor> updateVendedor(@PathVariable("id") Long id, @Valid @RequestBody Vendedor vendedor) {
        Optional<Vendedor> v = service.read(id);
        if (v.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                return new ResponseEntity<>(service.update(vendedor), HttpStatus.OK);
            } catch (Exception ex) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
}
