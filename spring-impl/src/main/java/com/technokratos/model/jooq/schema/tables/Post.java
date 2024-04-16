/*
 * This file is generated by jOOQ.
 */
package com.technokratos.model.jooq.schema.tables;


import com.technokratos.model.jooq.schema.Keys;
import com.technokratos.model.jooq.schema.Public;
import com.technokratos.model.jooq.schema.tables.records.PostRecord;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function4;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row4;
import org.jooq.Schema;
import org.jooq.SelectField;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Post extends TableImpl<PostRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.post</code>
     */
    public static final Post POST_ENTITY = new Post();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<PostRecord> getRecordType() {
        return PostRecord.class;
    }

    /**
     * The column <code>public.post.uuid</code>.
     */
    public final TableField<PostRecord, java.util.UUID> UUID = createField(DSL.name("uuid"), SQLDataType.UUID.nullable(false).defaultValue(DSL.field("uuid_generate_v4()", SQLDataType.UUID)), this, "");

    /**
     * The column <code>public.post.author_uuid</code>.
     */
    public final TableField<PostRecord, java.util.UUID> AUTHOR_UUID = createField(DSL.name("author_uuid"), SQLDataType.UUID.nullable(false), this, "");

    /**
     * The column <code>public.post.title</code>.
     */
    public final TableField<PostRecord, String> TITLE = createField(DSL.name("title"), SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * The column <code>public.post.content</code>.
     */
    public final TableField<PostRecord, String> CONTENT = createField(DSL.name("content"), SQLDataType.VARCHAR.nullable(false), this, "");

    private Post(Name alias, Table<PostRecord> aliased) {
        this(alias, aliased, null);
    }

    private Post(Name alias, Table<PostRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.post</code> table reference
     */
    public Post(String alias) {
        this(DSL.name(alias), POST_ENTITY);
    }

    /**
     * Create an aliased <code>public.post</code> table reference
     */
    public Post(Name alias) {
        this(alias, POST_ENTITY);
    }

    /**
     * Create a <code>public.post</code> table reference
     */
    public Post() {
        this(DSL.name("post"), null);
    }

    public <O extends Record> Post(Table<O> child, ForeignKey<O, PostRecord> key) {
        super(child, key, POST_ENTITY);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public UniqueKey<PostRecord> getPrimaryKey() {
        return Keys.POST_UUID_PK;
    }

    @Override
    public List<ForeignKey<PostRecord, ?>> getReferences() {
        return Arrays.asList(Keys.POST__POST_ACCOUNT_FK);
    }

    private transient Account _account;

    /**
     * Get the implicit join path to the <code>public.account</code> table.
     */
    public Account account() {
        if (_account == null)
            _account = new Account(this, Keys.POST__POST_ACCOUNT_FK);

        return _account;
    }

    @Override
    public Post as(String alias) {
        return new Post(DSL.name(alias), this);
    }

    @Override
    public Post as(Name alias) {
        return new Post(alias, this);
    }

    @Override
    public Post as(Table<?> alias) {
        return new Post(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Post rename(String name) {
        return new Post(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Post rename(Name name) {
        return new Post(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Post rename(Table<?> name) {
        return new Post(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row4 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row4<java.util.UUID, java.util.UUID, String, String> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function4<? super java.util.UUID, ? super java.util.UUID, ? super String, ? super String, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function4<? super java.util.UUID, ? super java.util.UUID, ? super String, ? super String, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}