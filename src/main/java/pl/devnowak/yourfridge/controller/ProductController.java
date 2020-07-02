package pl.devnowak.yourfridge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
    public String addNewProduct() {
        Product newProduct = new Product();
        newProduct.setName("Milk");
        newProduct.setExpirationDate(LocalDate.of(2020, 7, 10));
        newProduct.setDayOfPurchase(LocalDate.of(2020, 7, 4));
        newProduct.setCategory(ProductCategory.DAIRY);
        newProduct.setShop("Tesco");

        productRepository.save(newProduct);
        return "redirect:";
    }

}
