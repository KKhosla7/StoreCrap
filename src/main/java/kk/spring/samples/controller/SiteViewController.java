package kk.spring.samples.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by karan.khosla on 3/10/14.
 */

@Controller
@RequestMapping("/")
public class SiteViewController {


    @RequestMapping
    public String getHome() {
        return "index";
    }

    @RequestMapping("partials/employee")
    public String getPartialPage() {
        return "partials/employee";
    }

}
