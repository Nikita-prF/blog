package com.example.blog.controllers;

import com.example.blog.models.Post;
import com.example.blog.models.User;
import com.example.blog.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@Controller
public class BlogController {


    @Autowired
    PostRepository postRepository;

    @GetMapping("/community")
    public String blog(Model model) {
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "community";
    }

    @PostMapping("/community")
    public String blogAddPost(@RequestParam String title, String full_text, int rate) {
        Post post = new Post(title, full_text, rate);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setAuthor(user.getName());

        post.setAuthorImg("null");
        postRepository.save(post);
        return "redirect:/community";
    }

    @GetMapping("/{postId}/like")
    public String like(
            @PathVariable("postId") String id,
            RedirectAttributes redirectAttributes,
            @RequestHeader(required = false) String referer
    ) {
        Optional<Post> currentPost = postRepository.findById(id);
        Post post = currentPost.orElse(null);
        assert post != null;
        post.setLikes();

        postRepository.save(post);
        UriComponents components = UriComponentsBuilder.fromHttpUrl(referer).build();

        components.getQueryParams()
                .entrySet()
                .forEach(pair -> redirectAttributes.addAttribute(pair.getKey(), pair.getValue()));

        return "redirect:" + components.getPath();
    }

}
