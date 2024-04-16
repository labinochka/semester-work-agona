package com.technokratos.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "post")
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class PostEntity extends AbstractEntity {

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(referencedColumnName = "uuid", name = "author_uuid")
    private UserEntity author;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy="post")
    private ImageEntity image;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "commentPosts")
    private List<UserEntity> commentUsers;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "post")
    private List<CommentEntity> comments;

}
