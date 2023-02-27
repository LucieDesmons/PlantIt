package com.plantit.dto.service.impl;

import com.plantit.dal.entities.Address;
import com.plantit.dal.repositories.AddressRepository;
import com.plantit.dto.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressRepository addressRepository;

    public Address createAddress(Address a) {
        return addressRepository.save(a);
    }
    public Address saveAddress(Address a) { return addressRepository.save(a); };
    public Address updateAddress(Address a) { return addressRepository.save(a); };
    public void deleteAddress(Address a) { addressRepository.delete(a); };
    public void deleteAddressById(Long id) { addressRepository.deleteById(id); };
    public Address getAddress(Long id) { return addressRepository.findById(id).get(); };
    public List<Address> getAllAddresses() { return addressRepository.findAll(); };

}
