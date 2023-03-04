package cordeiro.daphne.PrimeiroSpring.controller;

import cordeiro.daphne.PrimeiroSpring.dto.ProdutoRequest;
import cordeiro.daphne.PrimeiroSpring.dto.ProdutoResponse;
import cordeiro.daphne.PrimeiroSpring.model.Produto;
import cordeiro.daphne.PrimeiroSpring.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("produto")
@RequiredArgsConstructor // recebe o service no construtor
public class ProdutoController {
    private final ProdutoService produtoService;

    @PostMapping
    public String create(ProdutoRequest produtoRequest) {
        Produto produto = new Produto();
        produto.setNome(produtoRequest.getNome());
        produto.setMarca(produtoRequest.getMarca());
        produto.setPreco(produtoRequest.getPreco());
        produto.setQuantidade(produtoRequest.getQuantidade());
        produto= produtoService.criar(produto);
        return produto.getId();
    }

    @GetMapping("{id}")
    public ProdutoResponse read(@PathVariable String id) {
       Produto produto = produtoService.selecionarProduto(id);
       ProdutoResponse produtoResponse = new ProdutoResponse();
        produtoResponse.setNome(produto.getNome());
        produtoResponse.setMarca(produto.getMarca());
        produtoResponse.setPreco(produto.getPreco());
        produtoResponse.setQuantidade(produto.getQuantidade());
        return  produtoResponse;
    }

    @PutMapping
    public ProdutoResponse update(String id, ProdutoRequest produtoRequest) {
        return new ProdutoResponse();
    }

    @DeleteMapping
    public void delete(String id) {
    }


}
