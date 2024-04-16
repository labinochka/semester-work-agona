package com.technokratos.repository.impl;

import com.technokratos.model.UserEntity;
import com.technokratos.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class UserRepositoryJdbcImpl implements UserRepository {

    private final JdbcTemplate jdbcTemplate;

    //language=sql
    private final static String SQL_GET_BY_ID = "select * from account where uuid = cast(? as uuid)";

    //language=sql
    private final static String SQL_GET_ALL = "select * from account";

    //language=sql
    private final static String SQL_CREATE = "insert into account (uuid, username, name, lastname, email, password) " +
            "values (?, ?, ?, ?, ?, ?)";

    //language=sql
    private final static String SQL_DELETE_BY_ID = "delete from account where uuid = cast(? as uuid)";

    //language=sql
    private final static String SQL_UPDATE = "update account set username = ?, name = ?, lastname = ?, email = ?, " +
            "password = ? where uuid = cast(? as uuid)";

    private final RowMapper<UserEntity> rowMapper = (rs, rowNum) -> UserEntity.builder()
            .username(rs.getString("username"))
            .name(rs.getString("name"))
            .lastname(rs.getString("lastname"))
            .email(rs.getString("email"))
            .password(rs.getString("password"))
            .uuid(rs.getObject("uuid", UUID.class))
            .build();


    @Override
    public Optional<UserEntity> findById(UUID uuid) {
        try (val stream = jdbcTemplate.queryForStream(SQL_GET_BY_ID, rowMapper, uuid)) {
            return stream.findAny();
        }
    }

    @Override
    public List<UserEntity> getAll() {
        return jdbcTemplate.query(SQL_GET_ALL, rowMapper);
    }

    @Override
    public UUID create(UserEntity userEntity) {
        UUID uuid = UUID.randomUUID();
        jdbcTemplate.update(SQL_CREATE, uuid, userEntity.getUsername(), userEntity.getName(),
                userEntity.getLastname(), userEntity.getEmail(), userEntity.getPassword());
        return uuid;
    }

    @Override
    public void deleteById(UUID uuid) {
        jdbcTemplate.update(SQL_DELETE_BY_ID, uuid);
    }

    @Override
    public UUID update(UUID uuid, UserEntity userEntity) {
        jdbcTemplate.update(SQL_UPDATE, userEntity.getUsername(), userEntity.getName(), userEntity.getLastname(),
                userEntity.getEmail(), userEntity.getPassword(), uuid);
        return uuid;
    }

    @Override
    public UUID updatePartial(UUID uuid, UserEntity userEntity) {
        String firstPart = "update account set ";
        String lastPart = "where uuid = cast('" + uuid + "' as uuid);";

        StringBuilder values = new StringBuilder();

        if (userEntity.getUsername() != null) {
            values.append("username = " + "'" + userEntity.getUsername() + "'" + ", ");
        } if (userEntity.getName() != null) {
            values.append("name = " + "'" + userEntity.getName()+ "'" + ", ");
        } if (userEntity.getLastname() != null) {
            values.append("username = " + "'" + userEntity.getLastname() + "'" + ", ");
        } if (userEntity.getEmail() != null) {
            values.append("email = " + "'" + userEntity.getEmail()+ "'" + ", ");
        } if (userEntity.getPassword() != null) {
            values.append("password = " + "'" + userEntity.getEmail()+ "'" + ", ");
        }
        values.delete(values.length() - 2, values.length() - 1);
        jdbcTemplate.update(firstPart + values + lastPart);
        return uuid;
    }
}
