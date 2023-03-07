package cordeiro.daphne.PrimeiroSpring.view;

import cordeiro.daphne.PrimeiroSpring.controller.ProdutoController;
import cordeiro.daphne.PrimeiroSpring.dto.ProdutoRequest;
import cordeiro.daphne.PrimeiroSpring.dto.ProdutoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class ProdutoViewController {

    private final ProdutoController produtoController;

    @RequestMapping(value={"/produtos"})
    public String visualizarProdutos(Model model){
        model.addAttribute("produtos", produtoController.readAll());
        return "produto-list";
    }

    @GetMapping("/produto-new")
    public String visualizarNovoProduto(Model model, ProdutoResponse produtoResponse) {
        model.addAttribute("produto", produtoResponse);
        return "produto-create";
    }

    @GetMapping("/produto-edit/{id}")
    public String editarProduto(@PathVariable("id") String id, Model model) {
        ProdutoResponse produtoResponse = produtoController.read(id);
        model.addAttribute("produto", produtoResponse);
        return "produto-update";
    }

    @GetMapping("/produto-delete/{id}")
    public String selecaoDeletarProduto(@PathVariable("id") String id, Model model) {
        ProdutoResponse produtoResponse = produtoController.read(id);
        model.addAttribute("produto", produtoResponse);
        return "produto-excluir";
    }
    @PostMapping("/excluir/{id}")
    public String excluirProduto(@PathVariable("id") String id) {
        produtoController.delete(id);
        return "redirect:/produtos";
    }
    @PostMapping("/produto-add")
    public String adicionarProduto(ProdutoResponse produtoResponse, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "produto-create";
        }
        ProdutoRequest produtoRequest = new ProdutoRequest();
        BeanUtils.copyProperties(produtoResponse, produtoRequest);
        produtoController.create(produtoRequest);
        return "redirect:/produtos";
    }
    @PostMapping("/produto-save/{id}")
    public String updateProduto(@PathVariable("id") String id, ProdutoResponse produtoResponse,
                               BindingResult result, Model model) {
        if (result.hasErrors()) {
            produtoResponse.setId(id);
            return "produto-update";
        }
        ProdutoRequest produtoRequest = new ProdutoRequest();
        BeanUtils.copyProperties(produtoResponse, produtoRequest);
        produtoController.update(produtoResponse.getId(), produtoRequest);
        return "redirect:/produtos";
    }


}
