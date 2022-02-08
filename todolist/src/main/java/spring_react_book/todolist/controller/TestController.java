package spring_react_book.todolist.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

    @GetMapping
    public String testController(){
        return "Hello test minseok";
    }

    @GetMapping("/testGetMapping")
    public String testControllerWithPath(){
        return "Hello test by minseok url is testGetMapping";
    }
}
