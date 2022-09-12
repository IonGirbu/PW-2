package com.limbo.julik.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class NewsController {

    @GetMapping("/News")
    public String NewsMain(Model model){
        return "News-Main";
    }

}
