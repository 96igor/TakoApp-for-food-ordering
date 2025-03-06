package com.example.springinaction.takoapp.data;

import com.example.springinaction.takoapp.Ingredient;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@Repository
public class JdbcIngredientRepository implements IngredientRepository{

    private JdbcTemplate jdbcTemplate;

    public JdbcIngredientRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Iterable<Ingredient> findAll() {
        String sql="SELECT id,name,type FROM Ingredient";
        return jdbcTemplate.query(sql, this::mapRowToIngredient);
    }


    @Override
    public Optional<Ingredient> findById(String id) {
        return Optional.empty();
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        return null;
    }

    private Ingredient mapRowToIngredient(ResultSet row, int numRow)
            throws SQLException {
        return new Ingredient(
                row.getString("id"),
                row.getString("name"),
                Ingredient.Type.valueOf(row.getString("type")));
    }
}
