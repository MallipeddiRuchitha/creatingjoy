package com.technocrats.creatingjoy.dto;

import com.technocrats.creatingjoy.entity.Address;
import com.technocrats.creatingjoy.entity.Category;
import com.technocrats.creatingjoy.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QueryDTO {

    private int id;

    private String queryText;

    private byte[] queryImage;

    private Time timestamp;

    private int likes;

    private int dislikes;

    private Category category;

    private UserDTO requestor;

    private UserDTO acceptor;

    private AddressDTO address;

}
