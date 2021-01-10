package io.yash.ratingsdataservice.resource;

import io.yash.ratingsdataservice.model.Rating;
import io.yash.ratingsdataservice.model.UserRatings;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingResource {

    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId){
        return new Rating(movieId, 4);
    }

    @RequestMapping("/users/{userId}")
    public UserRatings getUserRating(@PathVariable("userId") String userId) {
        List<Rating> ratings = Arrays.asList(
                new Rating("550", 4),
                new Rating("100", 3)
        );

        UserRatings userRatings = new UserRatings();
        userRatings.setUserRatings(ratings);

        return userRatings;
    }
}
