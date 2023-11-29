package com.SwapToSustain.Server.Controller;

import com.SwapToSustain.Server.DTO.NewUserPost;
import com.SwapToSustain.Server.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping(value = "/newPost")
    @CrossOrigin(origins = "http://localhost:3000")
    public void newPost(@RequestBody NewUserPost newUserPost,
                        @RequestParam(name = "userID") String userName) {
        postService.saveUserPost(newUserPost, userName);
    }

    @PostMapping(value = "/removePost")
    @CrossOrigin(origins = "http://localhost:3000")
    public void removePost(@RequestParam(name = "postID") String postID) {
        postService.removeUserPost(postID);
    }

}
