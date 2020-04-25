package com.technocrats.creatingjoy.objectmapper;

import com.technocrats.creatingjoy.dto.AddressDTO;
import com.technocrats.creatingjoy.entity.Address;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {


    @Autowired
    private ModelMapper mapper;

    public AddressDTO convertToDto(Address theAddress){

        AddressDTO theAddressDto=mapper.map(theAddress,AddressDTO.class);
        return theAddressDto;

    }


    public Address convertToEntity(AddressDTO theAddressDto){

       Address theAddress=mapper.map(theAddressDto,Address.class);
        return theAddress;

    }

}
