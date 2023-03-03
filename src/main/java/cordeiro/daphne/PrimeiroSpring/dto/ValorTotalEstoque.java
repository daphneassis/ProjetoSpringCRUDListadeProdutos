package cordeiro.daphne.PrimeiroSpring.dto;

import lombok.Data;

@Data
public class ValorTotalEstoque {

    private ProdutoRequest produtoRequest;

    public double getValorTotalEstoque(){
        return this.produtoRequest.getPreco()* this.produtoRequest.getQuantidade();

    }

}
