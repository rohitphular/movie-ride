package com.movie.ride.dummy;

import com.movie.ride.enums.Status;
import com.movie.ride.model.*;
import com.movie.ride.service.*;
import lombok.Data;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Data
@Component
@Profile("local")
public class DummyDataGenerator implements CommandLineRunner {

    private final TheaterService theaterService;
    private final RegionService regionService;
    private final ScreenService screenService;
    private final SeatService seatService;
    private final LanguageService languageService;
    private final GenreService genreService;
    private final MovieService movieService;

    @Override
    public void run(String... args) throws Exception {

        createDummyRegion();
        createDummyTheatre();
        createDummyScreen();
        createDummyLanguage();
        createDummyGenre();
        createDummyMovies();
    }

    private void createDummyMovies() {
        final Movie avatar = Movie.builder()
                .name("Avatar")
                .description("Avatar is a 2009 American epic science fiction film directed, written, produced, and co-edited by James Cameron and starring Sam Worthington")
                .durationMins(124)
                .releaseDate(getDate(24, 2, 2022))
                .build();
        movieService.save(avatar);

        final Movie titanic = Movie.builder()
                .name("Titanic")
                .description("Titanic is a 1997 American epic romance and disaster film directed, written, produced, and co-edited by James Cameron")
                .durationMins(143)
                .releaseDate(getDate(24, 2, 2022))
                .build();
        movieService.save(titanic);

        final Movie bucketList = Movie.builder()
                .name("The Bucket List")
                .description("The Bucket List is a 2007 American buddy adventure comedy-drama film directed and produced by Rob Reiner, written by Justin Zackham, and starring Jack Nicholson")
                .durationMins(113)
                .releaseDate(getDate(3, 3, 2002))
                .build();
        movieService.save(bucketList);

        final Movie godfather = Movie.builder()
                .name("The Godfather")
                .description("The Godfather is a 1972 American epic crime film directed by Francis Ford Coppola, who co-wrote the screenplay with Mario Puzo")
                .durationMins(127)
                .releaseDate(getDate(3, 3, 2022))
                .build();
        movieService.save(godfather);

        final Movie castaway = Movie.builder()
                .name("Cast Away")
                .description("After a deadly plane crash, Chuck Nolan finds himself marooned on a desolate island. With no way to escape, Chuck must find ways to survive in his new home.")
                .durationMins(145)
                .releaseDate(getDate(24, 3, 2022))
                .build();
        movieService.save(castaway);
    }

    private void createDummyGenre() {
        final Genre action = Genre.builder().name("Action").build();
        genreService.save(action);
        final Genre adventure = Genre.builder().name("Adventure").build();
        genreService.save(adventure);
        final Genre comedy = Genre.builder().name("Comdey").build();
        genreService.save(comedy);
        final Genre drama = Genre.builder().name("Drama").build();
        genreService.save(drama);
        final Genre horror = Genre.builder().name("Horror").build();
        genreService.save(horror);
    }

    private void createDummyLanguage() {
        final Language english = Language.builder().name("English").build();
        languageService.save(english);
        final Language hindi = Language.builder().name("Hindi").build();
        languageService.save(hindi);
        final Language punjabi = Language.builder().name("Punjabi").build();
        languageService.save(punjabi);
        final Language kannada = Language.builder().name("Kannada").build();
        languageService.save(kannada);
        final Language tamil = Language.builder().name("Tamil").build();
        languageService.save(tamil);
        final Language telugu = Language.builder().name("Telugu").build();
        languageService.save(telugu);
    }

    private void createDummyScreen() {
        final Screen screen1 = Screen.builder()
                .theaterId(1)
                .name("SCREEN 1")
                .status(Status.ACTIVE)
                .build();

        final Screen screen2 = Screen.builder()
                .theaterId(1)
                .name("SCREEN 2")
                .status(Status.ACTIVE)
                .build();

        final Screen savedScreen1 = screenService.save(screen1);
        screenService.save(screen2);

        final Seat seat1 = Seat.builder()
                .screenId(savedScreen1.getId())
                .tierName("GOLD")
                .rowNo(50)
                .seatNo(120)
                .basePrice(150.0)
                .build();

        final Seat seat2 = Seat.builder()
                .screenId(savedScreen1.getId())
                .tierName("GOLD")
                .rowNo(51)
                .seatNo(140)
                .basePrice(150.0)
                .build();

        seatService.save(seat1);
        seatService.save(seat2);
    }

    private void createDummyTheatre() {
        final Theater theater1 = Theater.builder()
                .theaterCode("ABCDEF")
                .name("THEATRE_1")
                .address("DS/3, ASDASW, FXCA, 54532")
                .regionId(1)
                .build();
        theaterService.save(theater1);

        final Theater theater = Theater.builder()
                .theaterCode("PQRSTU")
                .name("THEATRE_2")
                .address("XZ/3, DFASED, BFDS, 34865")
                .regionId(2)
                .build();
        theaterService.save(theater);
    }

    private void createDummyRegion() {
        final Region region1 = Region.builder()
                .name("North Mumbai")
                .town("Mulund")
                .city("Mumbai")
                .state("Maharashtra")
                .country("India")
                .build();
        regionService.save(region1);

        final Region region2 = Region.builder()
                .name("South Mumbai")
                .town("Churchgate")
                .city("Mumbai")
                .state("Maharashtra")
                .country("India")
                .build();
        regionService.save(region2);
    }

    public Date getDate(final int day, final int month, final int year) {
        return Date.from(LocalDate.of(year, month, day).atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
}
