package br.com.hirao.lucas.repositories;

import br.com.hirao.lucas.domain.Movie;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface MovieRepository extends ReactiveMongoRepository<Movie, String> {
}
