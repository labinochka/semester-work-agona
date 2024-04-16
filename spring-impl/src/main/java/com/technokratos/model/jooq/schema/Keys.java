/*
 * This file is generated by jOOQ.
 */
package com.technokratos.model.jooq.schema;


import com.technokratos.model.jooq.schema.tables.Account;
import com.technokratos.model.jooq.schema.tables.Comment;
import com.technokratos.model.jooq.schema.tables.Image;
import com.technokratos.model.jooq.schema.tables.Post;
import com.technokratos.model.jooq.schema.tables.records.AccountRecord;
import com.technokratos.model.jooq.schema.tables.records.CommentRecord;
import com.technokratos.model.jooq.schema.tables.records.ImageRecord;
import com.technokratos.model.jooq.schema.tables.records.PostRecord;

import org.jooq.ForeignKey;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables in
 * public.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<AccountRecord> ACCOUNT_EMAIL_UK = Internal.createUniqueKey(Account.ACCOUNT_ENTITY, DSL.name("account_email_uk"), new TableField[] { Account.ACCOUNT_ENTITY.EMAIL }, true);
    public static final UniqueKey<AccountRecord> ACCOUNT_USERNAME_UK = Internal.createUniqueKey(Account.ACCOUNT_ENTITY, DSL.name("account_username_uk"), new TableField[] { Account.ACCOUNT_ENTITY.USERNAME }, true);
    public static final UniqueKey<AccountRecord> ACCOUNT_UUID_PK = Internal.createUniqueKey(Account.ACCOUNT_ENTITY, DSL.name("account_uuid_pk"), new TableField[] { Account.ACCOUNT_ENTITY.UUID }, true);
    public static final UniqueKey<CommentRecord> COMMENT_UUID_PK = Internal.createUniqueKey(Comment.COMMENT_ENTITY, DSL.name("comment_uuid_pk"), new TableField[] { Comment.COMMENT_ENTITY.UUID }, true);
    public static final UniqueKey<ImageRecord> IMAGE_UUID_PK = Internal.createUniqueKey(Image.IMAGE_ENTITY, DSL.name("image_uuid_pk"), new TableField[] { Image.IMAGE_ENTITY.UUID }, true);
    public static final UniqueKey<PostRecord> POST_UUID_PK = Internal.createUniqueKey(Post.POST_ENTITY, DSL.name("post_uuid_pk"), new TableField[] { Post.POST_ENTITY.UUID }, true);

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<CommentRecord, AccountRecord> COMMENT__COMMENT_ACCOUNT_FK = Internal.createForeignKey(Comment.COMMENT_ENTITY, DSL.name("comment_account_fk"), new TableField[] { Comment.COMMENT_ENTITY.ACCOUNT_UUID }, Keys.ACCOUNT_UUID_PK, new TableField[] { Account.ACCOUNT_ENTITY.UUID }, true);
    public static final ForeignKey<CommentRecord, PostRecord> COMMENT__COMMENT_POST_FK = Internal.createForeignKey(Comment.COMMENT_ENTITY, DSL.name("comment_post_fk"), new TableField[] { Comment.COMMENT_ENTITY.POST_UUID }, Keys.POST_UUID_PK, new TableField[] { Post.POST_ENTITY.UUID }, true);
    public static final ForeignKey<ImageRecord, PostRecord> IMAGE__IMAGE_POST_FK = Internal.createForeignKey(Image.IMAGE_ENTITY, DSL.name("image_post_fk"), new TableField[] { Image.IMAGE_ENTITY.POST_UUID }, Keys.POST_UUID_PK, new TableField[] { Post.POST_ENTITY.UUID }, true);
    public static final ForeignKey<PostRecord, AccountRecord> POST__POST_ACCOUNT_FK = Internal.createForeignKey(Post.POST_ENTITY, DSL.name("post_account_fk"), new TableField[] { Post.POST_ENTITY.AUTHOR_UUID }, Keys.ACCOUNT_UUID_PK, new TableField[] { Account.ACCOUNT_ENTITY.UUID }, true);
}