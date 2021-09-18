package br.com.hirao.lucas.service;

import br.com.hirao.lucas.domain.Movie;
import br.com.hirao.lucas.domain.MovieEvent;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MovieService {
    Flux<Movie> getAll();
    Mono<Movie> getMovieById(String id);
    Flux<MovieEvent> getEventsByMovieId(String id);
}
