package io.yash.moviecatalogservice.resources;

import io.yash.moviecatalogservice.model.CatalogItem;
import io.yash.moviecatalogservice.model.Movie;
import io.yash.moviecatalogservice.model.UserRatings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userID) {

        UserRatings userRatings = restTemplate.getForObject("http://ratings-data-service/rating/users/" + userID , UserRatings.class);

        return userRatings.getUserRatings().stream().map( rating -> {

            //For each movie ID, call movie info service and get details
            Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);

            //Put them all together
            return new CatalogItem(movie.getName(), movie.getMovieDiscription(), rating.getRating());

        }).collect(Collectors.toList());
    }

}
