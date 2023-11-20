package com.SwapToSustain.Server.Controller;

import com.SwapToSustain.Server.DTO.FeedUserPost;
import com.SwapToSustain.Server.Service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    HomeService homeService;

    @GetMapping
    @CrossOrigin("http://localhost:3000")
    public List<FeedUserPost> getRecommendedFeed(@RequestParam(name = "userID") String userName) {
        return homeService.getRecommendedFeed(userName);
    }

}