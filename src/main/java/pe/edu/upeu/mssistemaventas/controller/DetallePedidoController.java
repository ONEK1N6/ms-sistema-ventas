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

import pe.edu.upeu.mssistemaventas.entity.DetallePedido;
import pe.edu.upeu.mssistemaventas.service.DetallePedidoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/detallepedidos")
public class DetallePedidoController {

    @Autowired
    private DetallePedidoService service;

    // Método para obtener todos los detalles de pedidos
    @GetMapping
    public ResponseEntity<List<DetallePedido>> readAll() {
        try {
            List<DetallePedido> detallePedidos = service.readAll();
            if (detallePedidos.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(detallePedidos, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Método para crear un nuevo detalle de pedido
    @PostMapping
    public ResponseEntity<DetallePedido> crear(@Valid @RequestBody DetallePedido detallePedido) {
        try {
            DetallePedido dp = service.create(detallePedido);
            return new ResponseEntity<>(dp, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Método para obtener un detalle de pedido por su ID
    @GetMapping("/{id}")
    public ResponseEntity<DetallePedido> getDetallePedidoId(@PathVariable("id") Long id) {
        try {
            Optional<DetallePedido> dp = service.read(id);
            if (dp.isPresent()) {
                return new ResponseEntity<>(dp.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Método para eliminar un detalle de pedido por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteDetallePedido(@PathVariable("id") Long id) {
        try {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Método para actualizar un detalle de pedido por su ID
    @PutMapping("/{id}")
    public ResponseEntity<DetallePedido> updateDetallePedido(@PathVariable("id") Long id, @Valid @RequestBody DetallePedido detallePedido) {
        Optional<DetallePedido> dp = service.read(id);
        if (dp.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                return new ResponseEntity<>(service.update(detallePedido), HttpStatus.OK);
            } catch (Exception ex) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
}
