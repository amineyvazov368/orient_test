package org.example.demoamin.restApiTasks.ECommers;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<Product> carts= new ArrayList<>();

    public Cart() {
    }

    public List<Product> getCarts() {
        return carts;
    }

    public void addCart(Product cart) {
        this.carts.add(cart);
    }

    public void removeCart(Product products) {
        carts.remove(products);
    }

    public void cleanCart(){
        carts.clear();
    }
}
