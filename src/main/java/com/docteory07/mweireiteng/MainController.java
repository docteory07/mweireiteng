package com.docteory07.mweireiteng;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class MainController {
    @GetMapping("/")
    public ResponseEntity<String> index() {

        return ResponseEntity.ok("뭬이레이텡 API 정상작동중");
    }
}
