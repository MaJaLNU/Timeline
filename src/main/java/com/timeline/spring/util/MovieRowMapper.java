package com.timeline.spring.util;

import com.timeline.spring.model.Movie;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by damma on 01.12.2016.
 */
public class MovieRowMapper implements RowMapper {

    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Movie movie = new Movie();
        movie.setId(rs.getLong("id"));
        movie.setTitle(rs.getString("title"));
        movie.setDescription(rs.getString("description"));
        movie.setDirector(rs.getString("director"));
        movie.setLength(rs.getString("length"));
        movie.setImage(rs.getString("image"));
        movie.setRating(rs.getDouble("rating"));
        movie.setReleasedate(rs.getString("releasedate"));
        movie.setYoutube(rs.getString("youtube"));
        return movie;
    }
}
