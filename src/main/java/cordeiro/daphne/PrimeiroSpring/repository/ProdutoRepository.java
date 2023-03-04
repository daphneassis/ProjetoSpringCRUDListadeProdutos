package cordeiro.daphne.PrimeiroSpring.repository;

import cordeiro.daphne.PrimeiroSpring.model.Produto;
import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepository extends CrudRepository<Produto, String> {
}
