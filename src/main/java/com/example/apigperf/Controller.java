package com.example.apigperf;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.Duration;

/**
 * @author roman
 * @since 02.09.21
 */
@RestController
@RequestMapping("/test")
public class Controller {


    @GetMapping("/object")
    public Mono<Response> getEmployeeById(@RequestParam String id) {
        return Mono.just(id)
                .delayElement(Duration.ofSeconds(2L))
                .map(f -> Response.builder().value(f).build());
    }

}
