package product_management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import product_management.model.Product;
import product_management.service.IProductService;
import product_management.service.ProductService;

import java.util.List;

@Controller
@RequestMapping(value = "/product")
public class ProductController {
    private final IProductService productService = new ProductService();

    @GetMapping(value = "")
    public String showList(Model model) {
        model.addAttribute("productList", productService.showListProduct());
        return "list";
    }

    @GetMapping(value = "/{id}/edit")
    public String showEdit(@PathVariable String id, Model model) {
        model.addAttribute("product", productService.showDetailProduct(id));
        return "edit";
    }

    @PostMapping(value = "/edit")
    public String edit(@ModelAttribute Product product, Model model, RedirectAttributes redirect) {
        productService.editProduct(product);
        redirect.addFlashAttribute("success", "Edit product successfully!");
        return "redirect:/product";
    }

    @GetMapping(value = "/create")
    public String showCreateForm(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping(value = "/create")
    public String create(@ModelAttribute Product product, Model model, RedirectAttributes redirect) {
        productService.addProduct(product);
        redirect.addFlashAttribute("success", "Create product successfully!");
        return "redirect:/product";
    }
    @GetMapping(value = "/{id}/delete")
    public String showDelete(@PathVariable String id, Model model) {
        model.addAttribute("product", productService.showDetailProduct(id));
        return "delete";
    }
    @PostMapping(value = "/delete")
    public String delete(@RequestParam String id, Model model, RedirectAttributes redirect) {
        productService.delete(id);
        redirect.addFlashAttribute("success", "Delete product successfully!");
        return "redirect:/product";
    }
    @PostMapping(value = "/search")
    public String search(@RequestParam String productName, Model model) {
        List<Product> productList = productService.searchName(productName);
        model.addAttribute("productList",productList);
        return "list";
    }
}
