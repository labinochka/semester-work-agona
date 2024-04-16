package com.technokratos.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "account")
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity extends AbstractEntity {

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String lastname;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "author")
    private List<PostEntity> authorPosts;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "comment",
            joinColumns = @JoinColumn(name = "account_uuid", referencedColumnName = "uuid"),
            inverseJoinColumns = @JoinColumn(name = "post_uuid", referencedColumnName = "uuid")
    )
    private List<PostEntity> commentPosts;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "author")
    private List<CommentEntity> comments;

}
