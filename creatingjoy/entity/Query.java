package com.technocrats.creatingjoy.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Time;

@Entity
@Table(name="query")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Query {


    @Id
    @Column(name="user_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name="query_text")
    @Size(min=1,message="is required")
    @NotNull(message="is required")
    private String queryText;

    @ToString.Exclude
    @Lob
    @Column(name="query_image")
    @NotNull(message = "is required")
    private byte[] queryImage;

    @Column(name="timestamp")
    @NotNull(message="is required")
    private Time timestamp;


    @Column(name="likes")
    private int likes;

    @Column(name="dislikes")
    private int dislikes;

    @ToString.Exclude
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="category_id")
    private Category category;

    @ToString.Exclude
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="requestor_id")
    private User user;

    @ToString.Exclude
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="address_id")
    private Address address;






}
