package br.com.hirao.lucas.controller;

import br.com.hirao.lucas.domain.Movie;
import br.com.hirao.lucas.domain.MovieEvent;
import br.com.hirao.lucas.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping
    public Flux<Movie> getAll(){
        return movieService.getAll();
    }

    @GetMapping("/{id}")
    public Mono<Movie> getMovieById(@PathVariable String id){
        return movieService.getMovieById(id);
    }

    @GetMapping(value = "/{id}/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<MovieEvent> getEventsById(@PathVariable String id){
        return movieService.getEventsByMovieId(id);
    }
}
