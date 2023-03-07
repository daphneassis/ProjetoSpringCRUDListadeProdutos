package cordeiro.daphne.PrimeiroSpring.service;

import cordeiro.daphne.PrimeiroSpring.model.Produto;
import cordeiro.daphne.PrimeiroSpring.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public Produto criar(Produto produto) {
        if (produto.getId() != null) {
            throw new IllegalArgumentException();
        }
        produto.setId(UUID.randomUUID().toString());
        return produtoRepository.save(produto);
    }

    public Produto selecionarProduto(String id) {
        return produtoRepository.findById(id).orElse(null);
    }


    public List<Produto> obterTodos() {
        List<Produto> lista = new ArrayList<>();
        produtoRepository.findAll().forEach(produto -> lista.add(produto));
        return lista;
    }

    public Produto atualizar(Produto produto){
            return produtoRepository.save(produto);
        }

    public Produto deletarProduto(String id) { // depois da aula
        Produto produto = produtoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
        produtoRepository.delete(produto);
        return produto;
    }

}

