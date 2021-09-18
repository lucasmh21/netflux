package br.com.hirao.lucas.bootstrap;

import br.com.hirao.lucas.domain.Movie;
import br.com.hirao.lucas.repositories.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;


@RequiredArgsConstructor
@Component
public class Initializer implements CommandLineRunner {

    private final MovieRepository movieRepository;

    @Override
    public void run(String... args) {
        movieRepository.deleteAll()
                .thenMany(Flux.just("Harry", "Marvel", "DC").map(Movie::new))
                .flatMap(movieRepository::save).subscribe(null, null, () -> movieRepository.findAll().subscribe(System.out::println));
    }
}
