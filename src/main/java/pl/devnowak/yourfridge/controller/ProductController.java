package pl.devnowak.yourfridge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import pl.devnowak.yourfridge.entity.Product;
import pl.devnowak.yourfridge.entity.ProductCategory;
import pl.devnowak.yourfridge.model.ProductRepository;
import pl.devnowak.yourfridge.model.ProductService;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "")
    public String index(Model model) {
        List<Product> productList = productService.getAllProducts();
        List<Integer> periodList = new ArrayList<>();
        for (Product productFromList : productList) {
            Period periodBetweenDates = Period.between(LocalDate.now(),
                    productFromList.getExpirationDate());
            int daysUntilExpiration = periodBetweenDates.getDays();
            periodList.add(daysUntilExpiration);
        }
        model.addAttribute("products", productList);
        model.addAttribute("period", periodList);

        return "product/index";
    }

    @GetMapping("add")
    public String displayAddProductsPage(Model model) {

        model.addAttribute(new Product());
        model.addAttribute("productCategories", ProductCategory.values());
        return "product/addProduct";
    }

    @PostMapping("add")
    public String addNewProduct(@ModelAttribute @Valid Product newProduct, Errors errors, Model model) {
        if(errors.hasErrors()) {
            model.addAttribute("productCategories", ProductCategory.values());
            return "product/addProduct";
        }
        productService.saveProduct(newProduct);
        return "redirect:";
    }

    @GetMapping("remove")
    public String displayRemoveProductsPage(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "product/removeProduct";
    }

    @PostMapping("remove")
    public String removeProduct(@RequestParam Long[] productIds) {
        for (Long productId : productIds) {
            productService.deleteProductById(productId);
        }
        return "redirect:";
    }
}
