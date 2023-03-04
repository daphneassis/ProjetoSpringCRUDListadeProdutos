package cordeiro.daphne.PrimeiroSpring.service;

import cordeiro.daphne.PrimeiroSpring.model.Produto;
import cordeiro.daphne.PrimeiroSpring.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public Produto criar(Produto produto){
        if (produto.getId()!=null){
            throw new IllegalArgumentException();
        }
        produto.setId(UUID.randomUUID().toString());
        produto.setUltimoPedido(LocalDateTime.now());
        return produtoRepository.save(produto);
    }

    public Produto selecionarProduto(String id){
      return  produtoRepository.findById(id).orElse(null);
    }


}
