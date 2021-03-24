package com.example.familyexpenses.controllers;

import com.example.familyexpenses.repository.OrderRepository;
import com.example.familyexpenses.utils.WeatherConditions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {
    private final OrderRepository orderRepository;

    public MainController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        List posts = orderRepository.findAll();
        model.addAttribute("posts", posts);
        model.addAttribute("title", "Main fpaige");
        new WeatherConditions();
        return "home";
    }

    @GetMapping("/news")
    public String news() {
        return "news";
    }

    @GetMapping("/pagePrice")
    public String pagePrace() {
        return "pagePrace";
    }
}

