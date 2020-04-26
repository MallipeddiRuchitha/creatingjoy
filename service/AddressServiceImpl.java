package com.technocrats.creatingjoy.service;

import com.technocrats.creatingjoy.dao.AddressRepository;
import com.technocrats.creatingjoy.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {



    private AddressRepository addressRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository){
        this.addressRepository=addressRepository;
    }

    @Override
    @Transactional
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    @Transactional
    public Address findById(int id) {

        Optional<Address> result=addressRepository.findById(id);

        if(result.isPresent()){
            return result.get();
        }
        else{
            throw new RuntimeException("Did not found Address with id "+id);
        }

    }

    @Override
    @Transactional
    public void save(Address address) {

        addressRepository.save(address);
    }

    @Override
    @Transactional
    public void deleteById(int id) {

        addressRepository.deleteById(id);

    }








}
