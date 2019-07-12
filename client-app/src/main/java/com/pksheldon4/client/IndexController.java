package com.pksheldon4.client;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.logging.Logger;

@Controller
public class IndexController {
    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }
}