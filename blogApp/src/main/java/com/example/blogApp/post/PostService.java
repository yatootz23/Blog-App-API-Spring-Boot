package com.example.blogApp.post;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getAllPosts(){
        return postRepository.findAll();
    }

     public Post getPost(Long postid) {
        boolean postExists = postRepository.existsById(postid);
        if (!postExists){
            throw new IllegalStateException("Post does not exist");
        }

        return postRepository.findById(postid).get();
    }

    void addPost(Post post) {
        post.setDate_posted(LocalDate.now());
        postRepository.save(post);
    }

    @Transactional
    public void updatePost(Post post, Long postid) {
        Optional<Post> postPresent = postRepository.findById(postid);
        if (postPresent.isPresent()) {
            Post oldPost = postPresent.get();
            if (post.getPost_title() != null && post.getPost_title().length() > 0 && !Objects.equals(post.getPost_title(), oldPost.getPost_title())) {
                oldPost.setPost_title(post.getPost_title());
           }
           if (post.getContent() != null && post.getContent().length() > 0 && !Objects.equals(post.getContent(), oldPost.getContent())) {
                oldPost.setContent(post.getContent());
           }
            postRepository.save(oldPost);
        } else {
            throw new IllegalStateException("Post does not exist");
        }

    }

    public void deletePost(Long postid) {
        boolean postExists = postRepository.existsById(postid);
        if (!postExists){
            throw new IllegalStateException("Post does not exist");
        }

        postRepository.deleteById(postid);
    }

    
}
