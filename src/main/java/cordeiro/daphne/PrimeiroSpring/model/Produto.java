package cordeiro.daphne.PrimeiroSpring.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Produto {
    @Id
    private String id;
    private String nome;
    private String marca;
    private Double preco;
    private Double quantidade;

}
