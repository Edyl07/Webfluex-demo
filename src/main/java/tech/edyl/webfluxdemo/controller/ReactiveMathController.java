package tech.edyl.webfluxdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tech.edyl.webfluxdemo.dto.MultiplyRequestDto;
import tech.edyl.webfluxdemo.dto.Response;
import tech.edyl.webfluxdemo.service.ReactiveMathService;

import java.util.Map;

@RestController
@RequestMapping("reactive-math")
public class ReactiveMathController {


    @Autowired
    private ReactiveMathService reactiveMathService;

    @GetMapping("square/{input}")
    public Mono<Response> findSquare(@PathVariable int input){
        return this.reactiveMathService.findSquare(input);
    }


    @GetMapping(value = "table/{input}/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Response> multiplicationTable(@PathVariable int input){
        return this.reactiveMathService.multiplicationTable(input);
    }

    @PostMapping("multiply")
    public Mono<Response> multiply(@RequestBody Mono<MultiplyRequestDto> requestDtoMono,
                                   @RequestHeader Map<String, String> headers){
        System.out.println(headers);
        return this.reactiveMathService.multiply(requestDtoMono);
    }
}
