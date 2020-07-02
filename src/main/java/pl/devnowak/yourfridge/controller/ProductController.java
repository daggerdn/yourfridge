package pl.devnowak.yourfridge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.devnowak.yourfridge.model.ProductRepository;

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
}
