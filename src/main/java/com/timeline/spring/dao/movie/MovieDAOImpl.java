package com.timeline.spring.dao.movie;

import com.timeline.spring.model.Movie;
import com.timeline.spring.util.MovieRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by damma on 22.11.2016.
 */

public class MovieDAOImpl implements MovieDAO {

    private JdbcTemplate jdbcTemplateObject;

    public MovieDAOImpl(DataSource dataSource) {
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    public List<Movie> getAllMovies() {
        String sql = "select * from movie order by releasedate asc";
        List<Movie> movies = jdbcTemplateObject.query(sql, new MovieRowMapper());

        return movies;
    }

    public Movie getMovie(long id) {
        String sql = "select * from movie where id = ?";
        Movie movie = (Movie) jdbcTemplateObject.queryForObject(sql, new Object[]{id}, new MovieRowMapper());
        return movie;
    }

    public void deleteMovie(long id) {
        String sql = "delete from movie where id = ?";
        jdbcTemplateObject.update(sql, id);
        System.out.println("Deleted Movie with ID = " + id);
        return;
    }

    public Movie createOrUpdateMovie(final Movie movie) {

        if (movie.getId() == null) {
            final String sql = "insert into movie " +
                    "(title" +
                    ", description" +
                    ", rating" +
                    ", releasedate" +
                    ", director" +
                    ", length" +
                    ", youtube" +
                    ", image) " +
                    "values (?, ?, ?, ?, ?, ?, ?, ?)";

            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplateObject.update(new PreparedStatementCreator() {
                                          public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                                              PreparedStatement ps =
                                                      connection.prepareStatement(sql, new String[]{"id"});
                                              ps.setString(1, movie.getTitle());
                                              ps.setString(2, movie.getDescription());
                                              ps.setDouble(3, movie.getRating());
                                              ps.setDate(4, movie.getReleasedate());
                                              ps.setString(5, movie.getDirector());
                                              ps.setString(6, movie.getLength());
                                              ps.setString(7, movie.getYoutube());
                                              ps.setString(8, movie.getImage());
                                              return ps;
                                          }
                                      },
                    keyHolder);

            Long newId = keyHolder.getKey().longValue();
            System.out.println("Insert Movie with ID = " + newId);
            return this.getMovie(newId);

        } else {
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
                    , movie.getTitle()
                    , movie.getDescription()
                    , movie.getRating()
                    , movie.getReleasedate()
                    , movie.getDirector()
                    , movie.getLength()
                    , movie.getYoutube()
                    , movie.getImage()
                    , movie.getId());
            System.out.println("Updated Movie with ID = " + movie.getId());
            return movie;
        }
    }
}
