package pl.devnowak.yourfridge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.devnowak.yourfridge.entity.Product;
import pl.devnowak.yourfridge.entity.ProductCategory;
import pl.devnowak.yourfridge.model.ProductRepository;

import java.time.LocalDate;

@Controller
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("products", productRepository.findAll());

        return "product/index";
    }

    @GetMapping("add")
    public String displayAddProductsPage(Model model) {

        model.addAttribute(new Product());
        model.addAttribute("productCategories", ProductCategory.values());
        return "product/addProduct";
    }

    @PostMapping("add")
    public String addNewProduct(@ModelAttribute Product newProduct) {

        productRepository.save(newProduct);
        return "redirect:";
    }

}
