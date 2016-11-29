package com.timeline.spring.dao.movie;

import com.timeline.spring.model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by damma on 22.11.2016.
 */

public class MovieDAOImpl implements MovieDAO {

    private JdbcTemplate jdbcTemplateObject;

  /*  public MovieDAOImpl() {
    }*/

    public MovieDAOImpl(DataSource dataSource) {
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    public List<Movie> getAllMovies() {
        String sql = "select * from movie order by releasedate asc";
        List<Movie> movies = jdbcTemplateObject.query(sql, new RowMapper<Movie>() {

            public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
                Movie movie = new Movie();
                movie.setId(rs.getLong("id"));
                movie.setTitle(rs.getString("title"));
                movie.setDescription(rs.getString("description"));
                movie.setDirector(rs.getString("director"));
                movie.setLength(rs.getString("length"));
                movie.setImage(rs.getString("image"));
                movie.setRating(rs.getDouble("rating"));
                movie.setReleasedate(rs.getDate("releasedate"));
                movie.setYoutube(rs.getString("youtube"));
                return movie;
            }
        });

        return movies;
    }

    public void deleteMovie(long id) {
        String sql = "delete from movie where id = ?";
        jdbcTemplateObject.update(sql, id);
        System.out.println("Deleted Movie with ID = " + id);
        return;
    }

    public void createMovie(Movie movie) {
        String sql = "insert into movie " +
                "(title" +
                ", description" +
                ", rating" +
                ", releasedate" +
                ", director" +
                ", length" +
                ", youtube" +
                ", image) " +
                "values (?, ?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplateObject.update(sql
                , movie.getTitle()
                , movie.getDescription()
                , movie.getRating()
                , movie.getReleasedate()
                , movie.getDirector()
                , movie.getLength()
                , movie.getYoutube()
                , movie.getImage());
        System.out.println("Created Movie = " + movie.toString());
        return;
    }

    public void editMovie(Movie movieUpdate) {
        String sql = "update movie" +
                " set title = ?" +
                ", description = ?" +
                ", rating = ?" +
                ", releasedate = ?" +
                ", director = ?" +
                ", length = ?" +
                ", youtube = ?" +
                ", image = ?" +
                " where id = ?";
        jdbcTemplateObject.update(sql
                , movieUpdate.getTitle()
                , movieUpdate.getDescription()
                , movieUpdate.getRating()
                , movieUpdate.getReleasedate()
                , movieUpdate.getDirector()
                , movieUpdate.getLength()
                , movieUpdate.getYoutube()
                , movieUpdate.getImage()
                , movieUpdate.getId());
        System.out.println("Updated Movie with ID = " + movieUpdate.getId());
        return;
    }
}
