package com.technokratos.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.persistence.Entity;

@Getter
@Setter
@Entity
@Table(name = "comment")
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class CommentEntity extends AbstractEntity {

    @Column(nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "uuid", name = "post_uuid")
    PostEntity post;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "uuid", name = "account_uuid")
    UserEntity author;


}
