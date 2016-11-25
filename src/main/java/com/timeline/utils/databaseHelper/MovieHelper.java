package com.timeline.utils.databaseHelper;

import com.timeline.spring.model.Movie;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Jan on 22.11.2016.
 */
public class MovieHelper {

    public void deleteMovie(int id) {
        try {
            int result;

            Connection connection = DatabaseHelper.connect();

            Statement statement = connection.createStatement();
            result = statement.executeUpdate("DELETE FROM movie WHERE id = '" + id + "'");

            if(result < 1) {
                //TODO
            }

        } catch (SQLException e) {
            e.printStackTrace();
            //TODO
            //Logger.getLogger(UserHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int createMovie(String title, double rating, Date releaseDate, String director, String length, String youtube, String description, String image) {
        int id = -1;
        try {
            int result;
            Connection connection = DatabaseHelper.connect();
            Statement statement = connection.createStatement();

            //TODO format releaseDate?

            result = statement.executeUpdate("INSERT INTO movie"
                    + " (title, rating, releasedate, director, length, youtube, description, image)"
                    + " VALUES ('" + title + "','" + rating + "','" + releaseDate + "','" + director + "','" + length + "','" + youtube + "','" + description + "','" + image + "')", Statement.RETURN_GENERATED_KEYS);

            // get ID of inserted movie
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()){
                id=resultSet.getInt(1);
            }
            resultSet.close();

            // check for error while inserting new movie
            if(result < 1) {
                //TODO
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    public void editMovie(int id, String title, double rating, Date releaseDate, String director, String length, String youtube, String description, String image) {
        try {
            int result;
            Connection connection = DatabaseHelper.connect();
            Statement statement = connection.createStatement();

            //TODO format releaseDate?
            result = statement.executeUpdate("UPDATE movie" +
                    " SET title=' " + title + "',rating='" + rating + "',releasedate='" + releaseDate + "',director='" + director + "',length='" + length + "',youtube='" + youtube + "',description='" + description + "',image='" + image + "'" +
                    " WHERE id='" + id + "'");

            if(result < 1) {
                //TODO
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Movie getMovie(int id) {
        Movie movie = new Movie();
        try {
            Connection connection = DatabaseHelper.connect();
            Statement statement = connection.createStatement();

            ResultSet result = statement.executeQuery("SELECT * FROM movie WHERE id='" + id + "'");

            if(!result.isBeforeFirst()) {
                //TODO no such movie with id
            }
            else {
                result.first();
                movie = new Movie(result.getInt("id"), result.getString("title"), result.getString("picture"), result.getDouble("rating"), result.getDate("releasedate"), result.getString("length"), result.getString("director"), result.getString("youtube"), result.getString("description"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movie;
    }

    public ArrayList<Movie> getMovies() {
        ArrayList<Movie> movies = new ArrayList<Movie>();
        try {
            Connection connection = DatabaseHelper.connect();
            Statement statement = connection.createStatement();

            ResultSet result = statement.executeQuery("SELECT * FROM movie");

            if(!result.isBeforeFirst()) {
                //TODO no movie!
            }
            else {
                while(result.next()){
                    Movie movie = new Movie(result.getInt("id"), result.getString("title"), result.getString("picture"), result.getDouble("rating"), result.getDate("releasedate"), result.getString("length"), result.getString("director"), result.getString("youtube"), result.getString("description"));
                    movies.add(movie);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movies;
    }
}
