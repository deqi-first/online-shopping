package com.itqf.service;

import com.itqf.entity.Address;

import java.util.List;

public interface AddressService {

    List<Address> findAddressByUid(int uid);

    Address findAddressByAid(int aid);

    void updateAddressByAid(Address address);

    void addAddress(Address address);

    void deleteAddressByAid(int aid);

    void setAddressToDefault(int aid, int uid);

    Address findDefaultAddressByUid(int uid);

}
