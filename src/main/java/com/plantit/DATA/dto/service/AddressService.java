package com.plantit.DATA.dto.service;

import com.plantit.DATA.dal.entities.Address;

import java.util.List;

public interface AddressService {

    Address createAddress(Address a);

    Address saveAddress(Address a);

    Address updateAddress(Address a);

    void deleteAddress(Address a);

    void deleteAddressById(Long id);

    Address getAddress(Long id);

    List<Address> getAllAddresses();

}
