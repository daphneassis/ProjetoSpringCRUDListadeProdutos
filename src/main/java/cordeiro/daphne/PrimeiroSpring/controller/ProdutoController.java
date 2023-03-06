package cordeiro.daphne.PrimeiroSpring.controller;

import cordeiro.daphne.PrimeiroSpring.dto.ProdutoRequest;
import cordeiro.daphne.PrimeiroSpring.dto.ProdutoResponse;
import cordeiro.daphne.PrimeiroSpring.model.Produto;
import cordeiro.daphne.PrimeiroSpring.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
        produto = produtoService.criar(produto);
        return produto.getId();
    }

    @GetMapping
    public List<ProdutoResponse> readAll() {
        return produtoService.obterTodos().stream().map(produto -> {
            ProdutoResponse produtoResponse = new ProdutoResponse();
            BeanUtils.copyProperties(produto, produtoService);
            return produtoResponse;
        }).collect(Collectors.toList());
    }
    @GetMapping("{id}")
    public ProdutoResponse read(@PathVariable String id) {
        Produto produto = produtoService.selecionarProduto(id);
        ProdutoResponse produtoResponse = new ProdutoResponse();
        produtoResponse.setNome(produto.getNome());
        produtoResponse.setMarca(produto.getMarca());
        produtoResponse.setPreco(produto.getPreco());
        produtoResponse.setQuantidade(produto.getQuantidade());
        return produtoResponse;
    }

    @PutMapping
    public ProdutoResponse update(@PathVariable String id, @RequestBody ProdutoRequest produtoRequest) {
        Produto produto = produtoService.obter(id);
        BeanUtils.copyProperties(produtoRequest, produto);
        produto = produtoService.atualizar(produto);
        ProdutoResponse produtoResponse = new ProdutoResponse();
        BeanUtils.copyProperties(produto, produtoResponse);
        return produtoResponse;
    }

    @DeleteMapping
    public void delete(@PathVariable String id) {
        produtoService.deletarProduto(id);
    }

}


