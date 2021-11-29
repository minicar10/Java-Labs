package VideoStore;

import java.util.*;

public class VideoStore {
    ArrayList<Rental> rentals;

    public VideoStore() {
        rentals = new ArrayList<>();

        rentals.add(new Video("Spider Man", 10, Video.PG13, "A maybe somewhat kinda good movie", "Nick Cage",
                new ArrayList<>(Arrays.asList("Matt Cage", "Something Waijing")), 120));

        rentals.add(new Video("X Men", 10, Video.PG13, "A maybe somewhat kinda good movie", "Nick Cage",
                new ArrayList<>(Arrays.asList("Matt Cage", "Luke Cage")), 110));

        rentals.add(new Video("The Avengers", 10, Video.PG13, "A maybe somewhat kinda good movie", "Nick Cage",
                new ArrayList<>(Arrays.asList("Mathew Hoffson", "Vanessa Tulum")), 114));

        rentals.add(new Video("La La Land", 10, Video.PG13, "A maybe somewhat kinda good movie", "Nick Cage",
                new ArrayList<>(Arrays.asList("Fei Jilin", "Mei Zhiao")), 90));

        rentals.add(new Game("Donkey Kong", 10, Game.EVERYONE, "NINTENDO ONLY", 1));
        rentals.add(new Game("Animal Crossing", 60, Game.EVERYONE, "NINTENDO ONLY", 4));
        rentals.add(new Game("Halo Infinite", 50, Game.MATURE, "XBOX AND PC ONLY", 1));
        rentals.add(new Game("Microsoft Flight Simulator", 60, Game.EVERYONE, "XBOX AND PC ONLY", 50));
    }

    public ArrayList<Video> getVideos() {
        ArrayList<Video> returnList = new ArrayList<>();

        for (Rental rental : rentals) {
            if (rental instanceof Video) {
                returnList.add((Video) rental);
            }
        }

        return returnList;
    }

    public ArrayList<Game> getGames() {
        ArrayList<Game> returnList = new ArrayList<>();

        for (Rental rental : rentals) {
            if (rental instanceof Game) {
                returnList.add((Game) rental);
            }
        }

        return returnList;
    }

    public ArrayList<Rental> getRented() {
        ArrayList<Rental> returnArray = new ArrayList<>();

        for (Rental rental : this.rentals) {
            if (rental.getRented()) {
                returnArray.add(rental);
            }
        }

        return returnArray;
    }

    public void addRental(Rental r) {
        this.rentals.add(r);
    }

    public ArrayList<Game> gamesInStock() {
        ArrayList<Game> allGames = getGames();
        ArrayList<Game> returnList = new ArrayList<>();

        for (Game game : allGames) {
            if (!game.getRented()) {
                returnList.add(game);
            }
        }

        return returnList;
    }

    public ArrayList<Video> videosInStock() {
        ArrayList<Video> allVideos = getVideos();
        ArrayList<Video> returnList = new ArrayList<>();

        for (Video video : allVideos) {
            if (!video.getRented()) {
                returnList.add(video);
            }
        }

        return returnList;
    }
}
