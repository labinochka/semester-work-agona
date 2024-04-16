package com.technokratos.repository;

import com.technokratos.model.jooq.schema.tables.pojos.AccountEntity;
import org.jooq.Record;
import org.jooq.Result;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserJooqRepository {

    UUID save(AccountEntity account);

    void saveList(List<AccountEntity> list);

    Optional<AccountEntity> findById(UUID id);

    List<AccountEntity> getAll(int pageSize, int pageNumber);

    Result<Record> getAllWithPosts(int pageSize, int pageNumber);

    void update(UUID uuid, AccountEntity account);

    void deleteById(UUID uuid);
}
