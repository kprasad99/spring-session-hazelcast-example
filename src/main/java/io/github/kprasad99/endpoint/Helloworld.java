package io.github.kprasad99.endpoint;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class Helloworld {

    @GetMapping(value = "//hello", produces = MediaType.TEXT_PLAIN_VALUE)
    public String hello(){
        return "Hello from Spring Session";
    }
}
