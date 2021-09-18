package br.com.hirao.lucas.service;

import br.com.hirao.lucas.domain.Movie;
import br.com.hirao.lucas.domain.MovieEvent;
import br.com.hirao.lucas.repositories.MovieRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    @Override
    public Flux<Movie> getAll() {
        return movieRepository.findAll();
    }

    @Override
    public Mono<Movie> getMovieById(String id) {
        return movieRepository.findById(id);
    }

    @Override
    public Flux<MovieEvent> getEventsByMovieId(String id) {
        return Flux.<MovieEvent>generate(movieEventSynchronousSink -> {
            movieEventSynchronousSink.next(new MovieEvent(id, LocalDate.now()));
        }).delayElements(Duration.ofSeconds(1));
    }
}
