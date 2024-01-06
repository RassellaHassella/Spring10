package ru.kata.spring.boot_security.demo.controller;


import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.dao.RoleRepository;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.service.UserService;


import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;
    private final RoleRepository roleRepository;

    public AdminController(UserService userService, RoleRepository roleRepository) {
        this.userService = userService;
        this.roleRepository = roleRepository;
    }
    @GetMapping()
    public String index(Model model, @AuthenticationPrincipal User user){
        model.addAttribute("user", user);
        model.addAttribute("users", userService.index());
        model.addAttribute("allRoles", roleRepository.findAll());
        return "admin";
    }
    @PostMapping("/users")
    public String save(User user, String rawPassword){
        user.setPassword(rawPassword);
        userService.save(user);
        return "redirect:/admin";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        userService.delete(id);
        return "redirect:/admin";
    }
    @PostMapping("/edit/{id}")
    public String update(User user, String rawPassword){
        if (rawPassword.length()>0){
            user.setPassword(rawPassword);
        }
        userService.update(user);
        return "redirect:/admin";
    }

}
