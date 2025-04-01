package pe.edu.upeu.mssistemaventas.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "fecha")
    private String fecha;

    // Relación muchos a uno con Cliente
    @ManyToOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    private Cliente cliente;

    // Relación muchos a uno con Vendedor (CORREGIDO)
    @ManyToOne
    @JoinColumn(name = "vendedor_id") // Clave foránea en Pedido
    private Vendedor vendedor;

    // Relación muchos a muchos con Producto (a través de Detalle_Pedido)
    @ManyToMany
    @JoinTable(
            name = "detalle_pedido",
            joinColumns = @JoinColumn(name = "pedido_id"),
            inverseJoinColumns = @JoinColumn(name = "producto_id")
    )
    private Set<Producto> productos;
}
