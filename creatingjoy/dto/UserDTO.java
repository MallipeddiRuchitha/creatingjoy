package com.technocrats.creatingjoy.dto;

import lombok.*;

import org.springframework.stereotype.Component;


@NoArgsConstructor
@AllArgsConstructor
@Component
@Getter
@Setter
@ToString
public class UserDTO {


        private String firstName;
        private String lastName;
        private String userName;
        private String phoneNumber;
        private String password;
        private String website;
        private int rating;

        @ToString.Exclude
        private AddressDTO addressDTO;



}

