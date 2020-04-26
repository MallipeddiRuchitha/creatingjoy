package com.technocrats.creatingjoy.dto;


import com.technocrats.creatingjoy.entity.Query;
import com.technocrats.creatingjoy.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {

    private int id;

    private String categoryName;

   /* private List<User> users;

    private List<Query> queries;*/

}
