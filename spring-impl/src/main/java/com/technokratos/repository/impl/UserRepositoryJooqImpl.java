package com.technokratos.repository.impl;

import com.technokratos.model.jooq.schema.tables.pojos.AccountEntity;
import com.technokratos.model.jooq.schema.tables.records.AccountRecord;
import com.technokratos.repository.UserJooqRepository;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.technokratos.model.jooq.schema.Tables.ACCOUNT_ENTITY;
import static com.technokratos.model.jooq.schema.Tables.POST_ENTITY;

@RequiredArgsConstructor
@Repository
public class UserRepositoryJooqImpl implements UserJooqRepository {

    private final DSLContext dsl;

    @Override
    public UUID save(AccountEntity account) {
        UUID uuid = UUID.randomUUID();
        dsl.insertInto(ACCOUNT_ENTITY)
                .columns(ACCOUNT_ENTITY.UUID, ACCOUNT_ENTITY.USERNAME, ACCOUNT_ENTITY.NAME, ACCOUNT_ENTITY.LASTNAME,
                        ACCOUNT_ENTITY.EMAIL, ACCOUNT_ENTITY.PASSWORD)
                .values(uuid, account.getUsername(), account.getName(), account.getLastname(), account.getEmail(),
                        account.getPassword())
                .execute();
        return uuid;
    }

    @Override
    public void saveList(List<AccountEntity> list) {
        dsl.batchInsert(list
                .stream()
                .map(user -> {
                    AccountRecord account = new AccountRecord();
                    account.setUsername(user.getUsername());
                    account.setName(user.getName());
                    account.setLastname(user.getLastname());
                    account.setEmail(user.getEmail());
                    account.setPassword(user.getPassword());
                    return account;
                })
                .collect(Collectors.toList()))
                .execute();
    }

    @Override
    public Optional<AccountEntity> findById(final UUID uuid) {
        return dsl.select(ACCOUNT_ENTITY.fields())
                .from(ACCOUNT_ENTITY)
                .where(ACCOUNT_ENTITY.UUID.eq(uuid))
                .fetchOptionalInto(AccountEntity.class);
    }

    @Override
    public List<AccountEntity> getAll(int pageSize, int pageNumber) {
        return dsl.selectFrom(ACCOUNT_ENTITY)
                .orderBy(ACCOUNT_ENTITY.USERNAME.asc())
                .limit(pageSize)
                .offset(pageNumber - 1)
                .fetchStreamInto(AccountEntity.class).toList();
    }

    @Override
    public Result<Record> getAllWithPosts(int pageSize, int pageNumber) {
        return dsl.select()
                .from(ACCOUNT_ENTITY)
                .join(POST_ENTITY).on(ACCOUNT_ENTITY.UUID.eq(POST_ENTITY.AUTHOR_UUID))
                .orderBy(ACCOUNT_ENTITY.USERNAME.asc())
                .limit(pageSize)
                .offset(pageNumber - 1)
                .fetch();
    }

    @Override
    public void update(UUID uuid, AccountEntity account) {
        dsl.update(ACCOUNT_ENTITY)
                .set(dsl.newRecord(ACCOUNT_ENTITY, account))
                .where(ACCOUNT_ENTITY.UUID.eq(uuid))
                .execute();
    }

    @Override
    public void deleteById(UUID uuid) {
        dsl.deleteFrom(ACCOUNT_ENTITY)
                .where(ACCOUNT_ENTITY.UUID.eq(uuid))
                .execute();
    }

}
