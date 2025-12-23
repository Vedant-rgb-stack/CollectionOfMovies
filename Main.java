package CollectionFramework.Movies;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Movie movie1 = new Movie("Chhaava", "Hindi", 2025, 7.3);
        Movie movie2 = new Movie("Saiyaara", "Hindi", 2025, 7.0);
        Movie movie3 = new Movie("Jewel Thief", "Hindi", 2025, 4.2);
        Movie movie4 = new Movie("Dragon", "Tamil", 2025, 7.8);
        Movie movie5 = new Movie("Tourist Family", "Tamil", 2025, 8.2);

        MovieStore movieStore = new MovieStore();
        movieStore.addMovies(movie1);
        movieStore.addMovies(movie2);
        movieStore.addMovies(movie3);
        movieStore.addMovies(movie4);
        movieStore.addMovies(movie5);

        for(Movie movie : movieStore.displayAllMovies()){
            System.out.println(movie.getName());
            System.out.println(movie.getLanguage());
            System.out.println(movie.getYear());
            System.out.println(movie.getRating());
            System.out.println(movie.getGenre());
        }

        while(true){
            System.out.println("Menu: " +
                    "1.Add Movies" +
                    "2.Display All Movies" +
                    "3.Search Movie" +
                    "4.Filter Movies" +
                    "5.Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {
                case 1:
                    System.out.print("Enter movie name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter language: ");
                    String language = sc.nextLine();
                    System.out.print("Enter year: ");
                    int year = sc.nextInt();
                    System.out.print("Enter rating: ");
                    double rating = sc.nextDouble();
                    sc.nextLine();

                    Movie newMovie = new Movie(name, language, year, rating);

                    System.out.print("Enter number of genres: ");
                    int numGenres = sc.nextInt();
                    sc.nextLine();
                    for (int i = 0; i < numGenres; i++) {
                        System.out.print("Enter genre " + (i + 1) + ": ");
                        String genre = sc.nextLine();
                        newMovie.setGenre(genre);
                    }

                    movieStore.addMovies(newMovie);
                    System.out.println("Movie added successfully!");
                    break;

                case 2:
                    List<Movie> movies = movieStore.displayAllMovies();
                    if (movies.isEmpty()) {
                        System.out.println("No movies to display.");
                    } else {
                        for (Movie movie : movies) {
                            System.out.println("\nName: " + movie.getName());
                            System.out.println("Language: " + movie.getLanguage());
                            System.out.println("Year: " + movie.getYear());
                            System.out.println("Rating: " + movie.getRating());
                            System.out.println("Genres: " + movie.getGenre());
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter movie name to search: ");
                    String searchName = sc.nextLine();
                    Movie foundMovie = movieStore.search(searchName);
                    if (foundMovie != null) {
                        System.out.println("\nMovie Found!");
                        System.out.println("Name: " + foundMovie.getName());
                        System.out.println("Language: " + foundMovie.getLanguage());
                        System.out.println("Year: " + foundMovie.getYear());
                        System.out.println("Rating: " + foundMovie.getRating());
                        System.out.println("Genres: " + foundMovie.getGenre());
                    } else {
                        System.out.println("Movie not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter year to filter (or 0 to skip): ");
                    int filterYear = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter language to filter (or press Enter to skip): ");
                    String filterLanguage = sc.nextLine();

                    List<Movie> filtered = movieStore.filter(filterYear, filterLanguage.isEmpty() ? null : filterLanguage);
                    if (filtered == null || filtered.isEmpty()) {
                        System.out.println("No movies found for given criteria.");
                    } else {
                        System.out.println("Filtered Movies:");
                        for (Movie movie : filtered) {
                            System.out.println("Name: " + movie.getName());
                            System.out.println("Language: " + movie.getLanguage());
                            System.out.println("Year: " + movie.getYear());
                            System.out.println("Rating: " + movie.getRating());
                            System.out.println("Genres: " + movie.getGenre());
                        }
                    }
                    break;

                case 5:
                    System.out.println("Exiting program. Thank you!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice! Please enter 1-5.");
            }
        }


    }
}
