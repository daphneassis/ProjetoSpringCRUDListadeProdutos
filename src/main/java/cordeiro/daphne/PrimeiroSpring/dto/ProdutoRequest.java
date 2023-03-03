package cordeiro.daphne.PrimeiroSpring.dto;

import lombok.Data;

@Data
public class ProdutoRequest {

    private String nome;
    private String marca;
    private double preco;
    private double quantidade;

}
