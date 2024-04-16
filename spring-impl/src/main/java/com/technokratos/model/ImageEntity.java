package com.technokratos.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.persistence.Entity;

@Getter
@Entity
@Table(name = "image")
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ImageEntity extends AbstractEntity {

    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    @OneToOne
    @JoinColumn(name = "post_uuid")
    private PostEntity post;
}
