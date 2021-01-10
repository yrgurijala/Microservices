package io.yash.movieInfoservice.resources;

import io.yash.movieInfoservice.models.Movie;
import io.yash.movieInfoservice.models.MovieSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/movies")
public class MovieInfoResource {

    private String apiKey = "032a5e686d0755143c058e7c4cb439a4";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{movieId}")
    public Movie getCatalog(@PathVariable("movieId") String movieID) {

        MovieSummary movieSummary = restTemplate.getForObject(
                "https://api.themoviedb.org/3/movie/" + movieID + "?api_key=" + apiKey,
                MovieSummary.class
        );

        return new Movie(movieID, movieSummary.getTitle(), movieSummary.getOverview());
    }
}
