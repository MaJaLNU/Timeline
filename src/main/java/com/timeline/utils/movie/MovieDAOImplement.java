package com.timeline.utils.movie;

import com.timeline.interfaces.MovieDAO;
import com.timeline.model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by damma on 22.11.2016.
 */

@Service("movieService")
public class MovieDAOImplement implements MovieDAO {

    private JdbcTemplate jdbcTemplateObject;

    public MovieDAOImplement() {
    }

    public MovieDAOImplement(DataSource dataSource) {
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    public List<Movie> getAllMovies() {
        String SQL = "select * from movie";
        List<Movie> movies = jdbcTemplateObject.query(SQL, new RowMapper<Movie>() {

            public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
                Movie movie = new Movie();
                movie.setId(rs.getInt("id"));
                movie.setTitle(rs.getString("title"));
                movie.setDescription(rs.getString("description"));
                movie.setDirector(rs.getString("director"));
                movie.setLength(rs.getString("length"));
                movie.setPicture(rs.getString("image"));
                movie.setRating(rs.getDouble("rating"));
                movie.setRelease(rs.getDate("releasedate"));
                movie.setYoutube(rs.getString("youtube"));
                return movie;
            }
        });

        return movies;
    }

    public void deleteMovie(int id) {
        String SQL = "delete from movie where id = ?";
        jdbcTemplateObject.update(SQL, id);
        System.out.println("Deleted Movie with ID = " + id);
        return;
    }

    public void createMovie(Movie movie) {
        String SQL = "insert into movie (title, description, rating, releasedate, director, length, youtube, image) values (?, ?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplateObject.update(SQL
                , movie.getTitle()
                , movie.getDescription()
                , movie.getRating()
                , movie.getRelease()
                , movie.getDirector()
                , movie.getLength()
                , movie.getYoutube()
                , movie.getPicture());
        System.out.println("Created Movie = " + movie.toString());
        return;
    }

    public void editMovie(int id, Movie movieUpdate) {
        String SQL = "update movie" +
                " set title = ?" +
                ", description = ?" +
                ", rating = ?" +
                ", releasedate = ?" +
                ", director = ?" +
                ", length = ?" +
                ", youtube = ?" +
                ", image = ?" +
                " where id = ?";
        jdbcTemplateObject.update(SQL
                , movieUpdate.getTitle()
                , movieUpdate.getDescription()
                , movieUpdate.getRating()
                , movieUpdate.getRelease()
                , movieUpdate.getDirector()
                , movieUpdate.getLength()
                , movieUpdate.getYoutube()
                , movieUpdate.getPicture()
                , id);
        System.out.println("Updated Movie with ID = " + id);
        return;
    }
}
