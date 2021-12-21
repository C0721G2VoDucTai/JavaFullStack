package upload_file.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import upload_file.model.Product;
import upload_file.service.IProductService;
import upload_file.service.impl.ProductService;

import java.util.List;
@Controller
public class ProductController {
    private final IProductService productService = new ProductService();

    @GetMapping("")
    public String index(Model model) {
        List< Product > products = productService.findAll();
        model.addAttribute("products", products);
        return "/index";
    }
}
