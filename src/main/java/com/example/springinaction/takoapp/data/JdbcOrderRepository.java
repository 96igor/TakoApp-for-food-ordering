package com.example.springinaction.takoapp.data;

import com.example.springinaction.takoapp.TacoOrder;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Types;
import java.util.Arrays;
import java.util.Date;

@Repository
public class JdbcOrderRepository implements OrderRepository{

    private final JdbcOperations jdbcOperations;

    public JdbcOrderRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    @Transactional
    public TacoOrder save(TacoOrder order) {
        String sql=
                "INSERT INTO Taco_order" +
                        "(delivery_name, delivery_street, delivery_city, +" +
                        "delivery_state, delivery_zip, cc_number, +" +
                        "cc_expiration, cc_cvv, placed_at) +" +
                        "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatementCreatorFactory pscf=
                new PreparedStatementCreatorFactory(
                        sql, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
                        Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
                        Types.VARCHAR, Types.VARCHAR, Types.TIMESTAMP);

        pscf.setReturnGeneratedKeys(true);
        order.setPlacedAt(new Date());

        PreparedStatementCreator psc=pscf.newPreparedStatementCreator(
                Arrays.asList(
                        order.getDileveryName(),
                        order.getDileveryStreet(),
                        order.getDileveryCity(),
                        order.getDileveryState(),
                        order.getDileveryZip(),
                        order.getCcNumber(),
                        order.getCcExpiration(),
                        order.getCcCvv(),
                        order.getPlacedAt()));
    }
}
