package org.example.demoamin.restApiTasks.ECommers;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    private Cart cart = new Cart();

    @GetMapping
    public Cart getCart() {
        return cart;
    }

    @PostMapping("/add")
    public String addToCart(@RequestBody Product product) {
        cart.addCart(product);
        return product.getName() + " səbətə əlavə edildi";
    }

    @PostMapping("/remove")
    public String removeFromCart(@RequestBody Product product) {
        cart.removeCart(product);
        return product.getName() + " səbətdən silindi.";
    }

    @PostMapping("/clear")
    public String deleteCart() {
        cart.cleanCart();
        return "Səbət təmizləndi.";
    }

}
