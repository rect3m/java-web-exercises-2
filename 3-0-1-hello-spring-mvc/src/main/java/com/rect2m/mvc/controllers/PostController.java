package com.rect2m.mvc.controllers;

import com.rect2m.mvc.model.Posts;
import com.rect2m.mvc.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostController {

    private final Posts posts;

    public PostController(Posts posts) {
        this.posts = posts;
    }
    // Показати всі пости
    @GetMapping
    public String getPosts(Model model) {
        List<Post> postList = posts.getAll();
        model.addAttribute("postList", postList);
        return "allposts"; // Повертаємо вигляд для всіх постів
    }

    @GetMapping("/viewPost")
    public String viewPostForm(Model model) {
        return "postInput"; // Використовуємо постійний файл для вводу ID
    }@GetMapping("/{id}")

    public String getPostByIdViaUrl(@PathVariable int id, Model model) {
        Post post = posts.getById(id);
        if (post != null) {
            model.addAttribute("post", post);
            return "post"; // Назва HTML-файлу для відображення поста
        } else {
            model.addAttribute("error", "Пост з ID " + id + " не знайдено."); // Повідомлення про помилку
            return "postInput"; // Повертаємо назад на форму з повідомленням
        }
    }

    @PostMapping("/getPostById") // Метод для отримання поста за ID
    public String getPostById(@RequestParam("id") int id, Model model) {
        Post post = posts.getById(id);
        if (post != null) {
            model.addAttribute("post", post);
            return "post"; // Назва HTML-файлу для відображення поста
        } else {
            model.addAttribute("error", "Пост з ID " + id + " не знайдено."); // Повідомлення про помилку
            return "postInput"; // Повертаємо назад на форму з повідомленням
        }
    }

    // Показати форму для додавання нового поста
    @GetMapping("/new")
    public String showAddPostForm(Model model) {
        model.addAttribute("post", new Post()); // Додаємо новий пост до моделі
        return "addPost"; // Повертаємо вигляд для додавання поста
    }

    @GetMapping("/main")
    public String showMainForm(Model model) {
        return "Main";
    }

    // Додати новий пост
    @PostMapping
    public String addPost(@Validated @ModelAttribute Post post) {
        posts.add(post);
        return "redirect:/posts"; // Редирект після додавання
    }
}
