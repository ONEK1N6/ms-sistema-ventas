package pe.edu.upeu.mssistemaventas.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "pagos")
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "metodoPago")
    private String metodoPago;

    @Column(name = "monto")
    private BigDecimal monto;

    @OneToOne(mappedBy = "pago")
    @JsonIgnore // Añade esta anotación
    private Pedido pedido;
}