package com.example.blogApp.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "posts")
public class PostController {
    
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<Post> getAllPosts(){
        return postService.getAllPosts();
    }

    @GetMapping(path = "{postid}")
    public Post getPost(@PathVariable Long postid){
        return postService.getPost(postid);
    }

    @PostMapping
    public void addPost(@RequestBody Post post){
        postService.addPost(post);
    }

    @PutMapping(path = "{postid}")
    public void updatePost(@RequestBody Post post, @PathVariable Long postid){
        postService.updatePost(post, postid);
    }

    @DeleteMapping(path = "{postid}")
    public void deletePost(@PathVariable("postid") Long postid){
        postService.deletePost(postid);
    }




}
