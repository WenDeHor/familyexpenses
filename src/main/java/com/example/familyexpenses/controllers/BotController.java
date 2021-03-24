package com.example.familyexpenses.controllers;

import com.example.familyexpenses.model.Bot;
import com.example.familyexpenses.telegram.BotService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class BotController {

    private final BotService botService;

    public BotController(BotService botService) {
        this.botService = botService;
    }

    @GetMapping("/botMessage")
    public String getBotMessagePage(Authentication authentication, ModelMap model, HttpServletRequest request) {
        model.addAttribute("title", "Message");
        return "botMessage";
    }

    @PostMapping("/botMessage")
    public String sendMessage(Bot bot) {
        botService.setBotRepository(bot);
        return "redirect:/";
    }
}
