package com.example.familyexpenses.controllers;

import com.example.familyexpenses.repository.OrdersRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {
    private final OrdersRepository ordersRepository;

    public MainController(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        List posts = ordersRepository.findAll();
        model.addAttribute("posts", posts);
        model.addAttribute("title", "Main fpaige");
        return "home";
    }

    @GetMapping("/news")
    public String news() {
        return "news";
    }

}

