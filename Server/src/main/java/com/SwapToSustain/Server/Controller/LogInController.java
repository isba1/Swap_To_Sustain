package com.SwapToSustain.Server.Controller;

import com.SwapToSustain.Server.DTO.UserInterests;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LogInController {

    @GetMapping("/reoccurringUser")
    public void userLogin(@RequestParam(name = "username") String username,
                          @RequestParam(name = "password") String password) {

    }


    @DeleteMapping("/deleteUser")
    public void deleteUser(@RequestParam(name = "username") String username,
                           @RequestParam(name = "password") String password){

    }

}
