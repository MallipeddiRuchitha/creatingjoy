package com.technocrats.creatingjoy.dto;

import com.technocrats.creatingjoy.entity.Address;
import com.technocrats.creatingjoy.entity.Category;
import com.technocrats.creatingjoy.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QueryDTO {

    private int id;

    private String queryText;

    private byte[] queryImage;

    private Timestamp timestamp;

    private int likes;

    private int dislikes;

    private CategoryDTO categoryDTO;

    private UserDTO requestor;

    private UserDTO acceptor;

    private AddressDTO addressDTO;

}
