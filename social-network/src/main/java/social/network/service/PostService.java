package social.network.service;



import social.network.model.Post;
import social.network.model.User;
import social.network.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post createPost(Post post, User user) {
        post.setUser(user);
        post.setTimestamp(LocalDateTime.now());
        return postRepository.save(post);
    }

    public List<Post> getAllPosts() {
        return postRepository.findAllByOrderByTimestampDesc();
    }
}
