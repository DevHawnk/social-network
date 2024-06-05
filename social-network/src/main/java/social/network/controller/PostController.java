package social.network.controller;

import social.network.model.Post;
import social.network.model.User;
import social.network.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping
    public Post createPost(@RequestBody Post post, Principal principal) {
        User user = new User();
        user.setUsername(principal.getName());
        return postService.createPost(post, user);
    }

    @GetMapping
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }
}
