package org.example.demoamin.restApiTest1;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final List<User> users = new ArrayList<>();


    @PostMapping
    public void addUser(@RequestBody User user) {
        this.users.add(user);
    }

    @PostMapping("/bulk")
    public void addUsers(@RequestBody List<User> users) {
        this.users.addAll(users);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable int id) {
        return users.stream().filter(user -> user.getId() == id)
                .findFirst()
                .orElse(null);
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        this.users.removeIf(user -> user.getId() == id);
    }
    @PutMapping("/{id}")
    public void updateUser(@RequestBody User user, @PathVariable int id) {
        int index = getUser(id).getId();
        user.setId(id);
        users.add(index, user);

    }

    @GetMapping
    public List<User> getAllUsers() {
        return users;
    }

}
