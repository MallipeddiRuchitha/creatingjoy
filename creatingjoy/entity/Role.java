package com.technocrats.creatingjoy.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="role")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Role {

    @Id
    @Column(name="role_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name="role_name")
    @Size(min=1,message = "is required")
    @NotNull(message="is required")
    private String name;




}
