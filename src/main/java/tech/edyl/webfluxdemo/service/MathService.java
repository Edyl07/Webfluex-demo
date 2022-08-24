package tech.edyl.webfluxdemo.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

import tech.edyl.webfluxdemo.dto.Response;

@Service
public class MathService {

    public Response findSquare(int input){
        return new Response(input * input);
    }
    

    public List<Response> multiplicationTable(int input){
        return IntStream.rangeClosed(1, 10)
        .peek(i -> SleepUtil.sleepSeconds(1))
        .peek(i -> System.out.println("math-service processing " + i))
        .mapToObj(i -> new Response(i * input))
        .collect(Collectors.toList());
    }
}
