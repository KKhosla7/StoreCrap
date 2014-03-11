package kk.spring.samples.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by karan.khosla on 3/10/14.
 */

@Controller
@RequestMapping("/")
public class IndexPageController {


    @RequestMapping
    public String getHome() {
        return "index";
    }
}
