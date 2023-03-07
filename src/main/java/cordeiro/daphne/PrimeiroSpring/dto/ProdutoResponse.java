package cordeiro.daphne.PrimeiroSpring.dto;

import lombok.Data;

@Data
public class ProdutoResponse {

    private String id;
    private String nome;
    private String marca;
    private double preco;
    private double quantidade;

}
