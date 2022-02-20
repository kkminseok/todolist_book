package spring_react_book.todolist.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring_react_book.todolist.dto.ResponseDTO;
import spring_react_book.todolist.dto.UserDTO;
import spring_react_book.todolist.model.UserEntity;
import spring_react_book.todolist.security.TokenProvider;
import spring_react_book.todolist.service.UserService;

@Slf4j
@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenProvider tokenProvider;



    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody UserDTO userDTO){
        try{
            UserEntity user = UserEntity.builder()
                    .email(userDTO.getEmail())
                    .username(userDTO.getUsername())
                    .password(userDTO.getPassword())
                    .build();

            UserEntity registerdUser = userService.create(user);
            UserDTO responseUserDTO = UserDTO.builder()
                    .email(registerdUser.getEmail())
                    .id(registerdUser.getId())
                    .username(registerdUser.getUsername())
                    .build();
            return ResponseEntity.ok(responseUserDTO);
        }catch(Exception e){
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return ResponseEntity.badRequest().body(responseDTO);
        }
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticate(@RequestBody UserDTO userDTO){
        UserEntity user = userService.getByCredentials(userDTO.getEmail(), userDTO.getPassword());

        if(user != null){
            String token = tokenProvider.create(user);

            final UserDTO responseUserDTO = UserDTO.builder()
                    .email(user.getEmail())
                    .id(user.getId())
                    .token(token)
                    .build();

            return ResponseEntity.ok().body(responseUserDTO);
        }else{
            ResponseDTO responseDTO = ResponseDTO.builder()
                    .error("Login failed.")
                    .build();

            return ResponseEntity.badRequest().body(responseDTO);
        }
    }
}
