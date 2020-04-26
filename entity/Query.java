package com.technocrats.creatingjoy.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Time;
import java.sql.Timestamp;

@Entity
@Table(name="query")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Query {


    @Id
    @Column(name="query_id")
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
    private Timestamp timestamp;


    @Column(name="likes")
    private int likes;

    @Column(name="dislikes")
    private int dislikes;

    @ToString.Exclude
    //@ManyToOne(cascade = {CascadeType.ALL})
    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

    @ToString.Exclude
    //@ManyToOne(cascade = {CascadeType.ALL})
    @ManyToOne
    @JoinColumn(name="requestor_id")
    private User requestor;

   /* @ToString.Exclude
    @OneToOne(cascade = {CascadeType.ALL})

    @JoinColumn(name="query_id")
    private Address address;*/
    @ToString.Exclude
    @OneToOne(mappedBy = "query",cascade={CascadeType.ALL})
    private Address address;


}
