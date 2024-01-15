package info.amytan.springbootpractice.controllers;

import info.amytan.springbootpractice.CatsApiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KittyController {

    @GetMapping("/cat")
    public String cat() {
        return CatsApiService.getCatImage();
    }
}
