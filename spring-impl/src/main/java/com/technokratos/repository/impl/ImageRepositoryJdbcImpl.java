package com.technokratos.repository.impl;

import com.technokratos.model.ImageEntity;
import com.technokratos.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class ImageRepositoryJdbcImpl implements ImageRepository {

    private final JdbcTemplate jdbcTemplate;

    //language=sql
    private final static String SQL_GET_BY_POST_ID = "select * from image where post_uuid = cast(? as uuid)";

    //language=sql
    private final static String SQL_GET_BY_ID = "select * from image where uuid = cast(? as uuid)";

    //language=sql
    private final static String SQL_CREATE = "insert into image (uuid, post_uuid, image_url) " +
            "values (?, ?, ?)";

    //language=sql
    private final static String SQL_DELETE_BY_ID = "delete from image where uuid = cast(? as uuid)";

    private final RowMapper<ImageEntity> rowMapper = (rs, rowNum) -> ImageEntity.builder()
            .uuid(rs.getObject("uuid", UUID.class))
            .imageUrl(rs.getString("image_url"))
            .build();

    @Override
    public Optional<ImageEntity> getByPostId(UUID uuid) {
        try (val stream = jdbcTemplate.queryForStream(SQL_GET_BY_POST_ID, rowMapper, uuid)) {
            return stream.findAny();
        }
    }

    @Override
    public UUID create(UUID postUuid, ImageEntity entity) {
        UUID uuid = UUID.randomUUID();
        jdbcTemplate.update(SQL_CREATE, uuid, postUuid, entity.getImageUrl());
        return uuid;
    }

    @Override
    public Optional<ImageEntity> getById(UUID uuid) {
        try (val stream = jdbcTemplate.queryForStream(SQL_GET_BY_ID, rowMapper, uuid)) {
            return stream.findAny();
        }
    }

    @Override
    public void deleteById(UUID uuid) {
        jdbcTemplate.update(SQL_DELETE_BY_ID, uuid);
    }
}
