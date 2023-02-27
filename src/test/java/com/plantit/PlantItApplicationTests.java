/*
package com.plantit;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class PlantItApplicationTests {

    @Autowired
    private com.plantit.dal.repositories.AddressRepository addressRepository;

    @Test
    public void testCreateAddress() {
        com.plantit.dal.entities.Address address = new com.plantit.dal.entities.Address(1195, 69280, "Avenue Marcel Mérieux", "Bâtiment A, RDC", "Marcy-l'Etoile");
        addressRepository.save(address);
    }

    @Test
    public void testFindAddress() {
        com.plantit.dal.entities.Address a = addressRepository.findById(1L).get();
        System.out.println(a);
    }

    @Test
    public void testUpdateAddress() {
        com.plantit.dal.entities.Address a = addressRepository.findById(1L).get();
        a.setTown("Noyelles");
        addressRepository.save(a);
    }

    @Test
    public void testDeleteAddress() {
        addressRepository.deleteById(8L);
        ;
    }

    @Test
    public void testListAllAddresses() {
        List<com.plantit.dal.entities.Address> addresses = addressRepository.findAll();
        for (com.plantit.dal.entities.Address a : addresses) {
            System.out.println(a);
        }
    }

}
*/
