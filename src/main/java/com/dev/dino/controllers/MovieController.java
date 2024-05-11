package com.dev.dino.controllers;

import com.dev.dino.models.dto.request.MovieRequestDto;
import com.dev.dino.models.dto.request.MovieRequestUpdateDto;
import com.dev.dino.models.dto.response.MovieResponseDto;
import com.dev.dino.services.MovieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

@RestController
@RequestMapping(value = "/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @PostMapping
    public ResponseEntity<Void> createMovie(@RequestBody @Valid MovieRequestDto movie, UriComponentsBuilder builder) {
        var response = movieService.createMovie(movie);
        var uri = builder.path("/movies/{id}").buildAndExpand(response.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<Page<MovieResponseDto>> getMovies(Pageable page){
        var response = movieService.getMovies(page);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieResponseDto> getMovieById(@PathVariable UUID id) {
        var response = movieService.getMovieById(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateMovie(@PathVariable UUID id, @RequestBody MovieRequestUpdateDto movie, UriComponentsBuilder builder){
        movieService.updateMovie(id, movie);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie (@PathVariable UUID id){
        movieService.deleteMovie(id);
        return ResponseEntity.noContent().build();
    }


}
