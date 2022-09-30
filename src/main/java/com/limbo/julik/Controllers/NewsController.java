package com.limbo.julik.Controllers;

import com.limbo.julik.Model.Article;
import com.limbo.julik.Repo.ArticleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller

public class NewsController {

    @Autowired
    private ArticleRepo articleRepo;
    @GetMapping("/News")

    public String NewsMain(Model model){
        Iterable<Article> articles = articleRepo.findAll();
        model.addAttribute("articles", articles);
        return "news";
    }

}
