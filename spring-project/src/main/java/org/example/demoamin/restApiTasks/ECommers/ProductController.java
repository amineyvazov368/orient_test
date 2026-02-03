package org.example.demoamin.restApiTasks.ECommers;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/products")
public class ProductController {

    List<Product> products = new ArrayList<>();

    @GetMapping
    public List<Product> getProducts() {
        return products;
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id) {
        return products.stream().filter(product -> product.getId() == id).findFirst().orElse(null);
    }

    @GetMapping("/category")
    public List<Product> getProductsByCategory(@RequestParam(required = false) String category) {
        List<Product> res = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory().equalsIgnoreCase(category)) {
                res.add(product);
            }
        }
        return res;
    }

    @GetMapping("/price")
    public List<Product> getProductByPrice(
            @RequestParam(required = false) int min,
            @RequestParam(required = false) int max) {
        List<Product> res = new ArrayList<>();
        for (Product product : products) {
            if (product.getPrice() >= min && product.getPrice() <= max) {
                res.add(product);
            }
        }
        return res;
    }

    @PostMapping
    public void addProduct(@RequestBody Product product) {
        products.add(product);
    }

    @PostMapping("/bulk")
    public void addProducts(@RequestBody List<Product> products) {
        this.products.addAll(products);
    }

    @PutMapping("/{id}")
    public void updateProduct(@RequestBody Product product, @PathVariable int id) {
        Product find = getProductById(id);
        find.setName(product.getName());
        find.setCategory(product.getCategory());
        find.setPrice(product.getPrice());

    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable int id) {
        products.removeIf(product -> product.getId() == id);
    }


}
