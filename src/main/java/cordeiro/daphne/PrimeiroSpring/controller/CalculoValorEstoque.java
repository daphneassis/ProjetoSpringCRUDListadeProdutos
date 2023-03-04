package cordeiro.daphne.PrimeiroSpring.controller;

import cordeiro.daphne.PrimeiroSpring.dto.ProdutoRequest;
import cordeiro.daphne.PrimeiroSpring.dto.ValorTotalEstoque;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("calculo")
public class CalculoValorEstoque {
    //@GetMapping
    //getCalculoPreco(@RequestBody ProdutoRequest produtoRequest) pra pegar pelo body
    @RequestMapping(method = RequestMethod.POST)
    public ValorTotalEstoque getCalculoPreco(ProdutoRequest produtoRequest){
            ValorTotalEstoque valorTotalEstoque = new ValorTotalEstoque();
        valorTotalEstoque.setProdutoRequest(produtoRequest);
                return valorTotalEstoque;
    }


}
