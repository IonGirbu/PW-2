package com.limbo.julik.Controllers;

import com.limbo.julik.Model.Article;
import com.limbo.julik.Repo.ArticleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

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


    @GetMapping("/News/{id}")

    public String NewsDetails(@PathVariable(value = "id") long id,  Model model){
        Optional<Article> article = articleRepo.findById(id);
        ArrayList<Article> res = new ArrayList<>();
        article.ifPresent(res::add);
        model.addAttribute("article", res);
        return "news-details";
    }

    @GetMapping("/News/{id}/edit")

    public String NewsEdit(@PathVariable(value = "id") long id,  Model model){
        Optional<Article> article = articleRepo.findById(id);
        ArrayList<Article> res = new ArrayList<>();
        article.ifPresent(res::add);
        model.addAttribute("article", res);
        return "news-edit";
    }

    @PostMapping("/News/{id}/edit")
    private String blogPostEdit(@PathVariable(value = "id") long id, @RequestParam String title, @RequestParam String fulltext, @RequestParam int likes, Model model){
        Article article = articleRepo.findById(id).orElseThrow();
        article.setTitle(title);
        article.setFulltext(fulltext);
        article.setLikes(likes);
        articleRepo.save(article);
        return "redirect:/News";
    }

    @PostMapping("/News/{id}/remove")
    private String blogPostDelete(@PathVariable(value = "id") long id, Model model){
        Article article = articleRepo.findById(id).orElseThrow();
        articleRepo.delete(article);
        return "redirect:/News";
    }

}
