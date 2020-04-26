package com.technocrats.creatingjoy.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name="category")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Category {

    @Id
    @Column(name="category_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name="category_name")
    @Size(min=1,message = "is required")
    @NotNull(message="is required")
    private String categoryName;


   /* @ToString.Exclude
    @OneToMany(mappedBy = "category",cascade={CascadeType.ALL})
    private List<Query> queries;

*/

}
