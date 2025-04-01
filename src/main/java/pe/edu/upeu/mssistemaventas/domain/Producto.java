package pe.edu.upeu.mssistemaventas.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name="producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="Nombre")
    private String nombre;
    @Column(name="categoria")
    private String categoria;
    @Column(name="Precio")
    private double precio;
    @Column(name="Stock")
    private String stock;
    @Column(name="estado")
    private char estado;
}
