package spring_react_book.todolist.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring_react_book.todolist.dto.ResponseDTO;
import spring_react_book.todolist.dto.TestRequestBodyDTO;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("testd")
public class TestController {

    @GetMapping
    public String testController(){
        return "Hello test minseok";
    }

    @GetMapping("/testGetMapping")
    public String testControllerWithPath(){
        return "Hello test by minseok url is testGetMapping";
    }

    @GetMapping("/{id}")
    public String testControllerwithPathvariables(@PathVariable(required = false) int id){
        return "Hello KMS! ID" + id;
    }

    @GetMapping("/testRequestParam")
    public String testControllerRequestParam(@RequestParam(required = false) int id){
        return "Hello KMS ! ID requestParam" + id;
    }

    @GetMapping("/testRequestBody")
    public String testControllerRequestbody(@RequestBody TestRequestBodyDTO testRequestBodyDTO){
        return "Hello KMS ! ID" + testRequestBodyDTO.getId() + "Message : " + testRequestBodyDTO.getMessage();
    }

    @GetMapping("/testResponseBody")
    public ResponseDTO<String> testControllerResponseBody(){
        List<String> list = new ArrayList<>();
        list.add("Hello KMS! Im ResponseDTO");
        ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
        return response;
    }

    @GetMapping("/testResponseEntity")
    public ResponseEntity<?> testControllerResponseEntity(){
        List<String> list = new ArrayList<>();
        list.add("hello world ! im ResponseEntity. and you got 400");
        ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
        return ResponseEntity.badRequest().body(response);
    }
}
