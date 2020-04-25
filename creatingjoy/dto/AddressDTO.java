package com.technocrats.creatingjoy.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {


    private int id;

    private String houseNumber;

    private String street;

    private String city;

    private String landmark;

    private String ZIP;

    private String state;

    private String country;

    private UserDTO userDTO;






}
