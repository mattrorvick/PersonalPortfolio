package com.tts.portfolio.controller;

import java.util.ArrayList;
import java.util.List;

import com.tts.portfolio.model.Comments;
import com.tts.portfolio.repository.CommentsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {


    @Autowired
    private CommentsRepository commentsRepository;

    private List<Comments> posts = new ArrayList<>();


    @GetMapping(value = "/")
    public String greeting() {

        return "greeting";
    }

    @GetMapping(value = "/index")
    public String index() {

        return "index";
    }

    @GetMapping(value = "/design")
    public String designPage() {

        return "design";
    }

    @GetMapping(value = "/codingprojects")
    public String softwareDevPage() {

        return "codingprojects";
    }



    @GetMapping(value = "/comments")
    public String commentsPage(Comments comments, Model model) {
        // keeps posts from duplicating every time comments page is refreshed
        posts.removeAll(posts);

        for (Comments postFromDB : commentsRepository.findAll()) {
            posts.add(postFromDB);
        }

        model.addAttribute("posts", posts);

        return "comments";
    } 

       

    @PostMapping(value = "/result")
    public String addNewComment(Comments comments, Model model) {

        commentsRepository.save(comments);

        model.addAttribute("title", comments.getTitle());
        model.addAttribute("author", comments.getAuthor());
        model.addAttribute("entry", comments.getEntry());

        return "result";
    }

}