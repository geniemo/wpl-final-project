package wpl.server.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import wpl.server.api.service.UserService;
import wpl.server.payload.Message;
import wpl.server.payload.request.JoinRequest;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v0/member")
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserController {

    private final UserService userService;

    @PostMapping("/join")
    @Transactional
    public ResponseEntity<Message> join(@RequestBody @Valid JoinRequest joinRequest) {
        System.out.println("joinRequest = " + joinRequest);
        return ResponseEntity.ok(userService.join(joinRequest));
    }

    @GetMapping("")
    public ResponseEntity<Message> allUsers() {
        return ResponseEntity.ok(userService.allUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Message> userInfo(@PathVariable Long id) {
        return ResponseEntity.ok(userService.userInfo(id));
    }
}
