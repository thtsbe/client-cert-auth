package ch.demo.backend;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class BackendEndpoint {

    @GetMapping(value = "/demo", produces = MediaType.TEXT_PLAIN_VALUE)
    public String get() {
        return "Demo Response";
    }

}
