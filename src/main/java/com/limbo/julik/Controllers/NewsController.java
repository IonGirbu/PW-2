package com.limbo.julik.Controllers;

import com.limbo.julik.Model.Article;
import com.limbo.julik.Repo.ArticleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/News/add")

    public String NewsAdd(Model model){
        return "news-add";
    }

    @PostMapping("/News/add")
    private String blogPostAdd(@RequestParam String title, @RequestParam String fulltext, @RequestParam int likes, Model model){
       Article article = new Article(title, fulltext, likes);
        articleRepo.save(article);
        return "redirect:/News";
    }
}
