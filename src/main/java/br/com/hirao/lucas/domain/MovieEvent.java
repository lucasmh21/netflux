package br.com.hirao.lucas.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class MovieEvent {
    private String movieId;
    private LocalDate movieDate;
}
