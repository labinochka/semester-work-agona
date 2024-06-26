/*
 * This file is generated by jOOQ.
 */
package com.technokratos.model.jooq.schema.tables.pojos;



import com.technokratos.model.Entity;

import java.io.Serializable;
import java.util.UUID;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CommentEntity extends Entity implements Serializable {

    private static final long serialVersionUID = 1L;

    private UUID uuid;
    private UUID postUuid;
    private UUID accountUuid;
    private String content;

    public CommentEntity() {}

    public CommentEntity(CommentEntity value) {
        this.uuid = value.uuid;
        this.postUuid = value.postUuid;
        this.accountUuid = value.accountUuid;
        this.content = value.content;
    }

    public CommentEntity(
        UUID uuid,
        UUID postUuid,
        UUID accountUuid,
        String content
    ) {
        this.uuid = uuid;
        this.postUuid = postUuid;
        this.accountUuid = accountUuid;
        this.content = content;
    }

    /**
     * Getter for <code>public.comment.uuid</code>.
     */
    public UUID getUuid() {
        return this.uuid;
    }

    /**
     * Setter for <code>public.comment.uuid</code>.
     */
    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    /**
     * Getter for <code>public.comment.post_uuid</code>.
     */
    public UUID getPostUuid() {
        return this.postUuid;
    }

    /**
     * Setter for <code>public.comment.post_uuid</code>.
     */
    public void setPostUuid(UUID postUuid) {
        this.postUuid = postUuid;
    }

    /**
     * Getter for <code>public.comment.account_uuid</code>.
     */
    public UUID getAccountUuid() {
        return this.accountUuid;
    }

    /**
     * Setter for <code>public.comment.account_uuid</code>.
     */
    public void setAccountUuid(UUID accountUuid) {
        this.accountUuid = accountUuid;
    }

    /**
     * Getter for <code>public.comment.content</code>.
     */
    public String getContent() {
        return this.content;
    }

    /**
     * Setter for <code>public.comment.content</code>.
     */
    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final CommentEntity other = (CommentEntity) obj;
        if (this.uuid == null) {
            if (other.uuid != null)
                return false;
        }
        else if (!this.uuid.equals(other.uuid))
            return false;
        if (this.postUuid == null) {
            if (other.postUuid != null)
                return false;
        }
        else if (!this.postUuid.equals(other.postUuid))
            return false;
        if (this.accountUuid == null) {
            if (other.accountUuid != null)
                return false;
        }
        else if (!this.accountUuid.equals(other.accountUuid))
            return false;
        if (this.content == null) {
            if (other.content != null)
                return false;
        }
        else if (!this.content.equals(other.content))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.uuid == null) ? 0 : this.uuid.hashCode());
        result = prime * result + ((this.postUuid == null) ? 0 : this.postUuid.hashCode());
        result = prime * result + ((this.accountUuid == null) ? 0 : this.accountUuid.hashCode());
        result = prime * result + ((this.content == null) ? 0 : this.content.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("CommentEntity (");

        sb.append(uuid);
        sb.append(", ").append(postUuid);
        sb.append(", ").append(accountUuid);
        sb.append(", ").append(content);

        sb.append(")");
        return sb.toString();
    }
}
