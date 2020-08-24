package com.example.demo;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ClientRepository {
    private final JdbcTemplate jdbcTemplate;

    public ClientRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Client findByName(String name) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM CLIENTS WHERE name = ?", new String[] {name}, Client.class);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}
