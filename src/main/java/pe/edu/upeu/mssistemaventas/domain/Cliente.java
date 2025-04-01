package pe.edu.upeu.mssistemaventas.domain;


import java.util.Set;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name="clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="Nombre")
    private String nombre;
    @Column(name="direccion")
    private String direccion;
    @Column(name="estado")
    private char estado;

    @OneToMany(mappedBy = "cliente")

    private Set<Pedido> pedidos;
}
