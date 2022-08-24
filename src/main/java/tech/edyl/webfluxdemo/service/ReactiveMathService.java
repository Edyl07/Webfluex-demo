package tech.edyl.webfluxdemo.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tech.edyl.webfluxdemo.dto.MultiplyRequestDto;
import tech.edyl.webfluxdemo.dto.Response;

import java.time.Duration;

@Service
public class ReactiveMathService {

    public Mono<Response> findSquare(int input){
        return Mono.fromSupplier(() -> input * input)
                .map(Response::new);
    }


    public Flux<Response> multiplicationTable(int input){

//        List<Response> list = IntStream.rangeClosed(1, 10)
//                .peek(i -> SleepUtil.sleepSeconds(1))
//                .peek(i -> System.out.println("react-math-service processing : " + i))
//                .mapToObj(i -> new Response(i * input))
//                .collect(Collectors.toList());
//        return Flux.fromIterable(list);
        return Flux.range(1, 10)
                .delayElements(Duration.ofSeconds(1))
//                .doOnNext(i -> SleepUtil.sleepSeconds(1))
                .doOnNext(i -> System.out.println("react-math-service processing : " + i))
                .map(i -> new Response(i * input));
    }

    public Mono<Response> multiply(Mono<MultiplyRequestDto> dtoMono){
        return  dtoMono
                .map(dto -> dto.getFirst() * dto.getSecond())
                .map(Response::new);
    }
}
