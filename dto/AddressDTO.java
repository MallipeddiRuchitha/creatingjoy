package com.technocrats.creatingjoy.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class AddressDTO {


    private int id;

    private String houseNumber;

    private String street;

    private String city;

    private String landmark;

    private String ZIP;

    private String state;

    private String country;

    @ToString.Exclude
    private UserDTO userDTO;


    @ToString.Exclude
    private QueryDTO queryDTO;




}
