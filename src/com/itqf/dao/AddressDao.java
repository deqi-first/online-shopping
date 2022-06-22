package com.itqf.dao;

import com.itqf.entity.Address;

import java.util.List;

public interface AddressDao {
    List<Address> selectAddressByUid(int uid);

    Address selectAddressByAid(int aid);

    void updateAddressByAid(Address address);

    void insertAddress(Address address);

    void deleteAddressByAid(int aid);

    void setAddressToDefault(int aid, int uid);

    void setOuterAddressNotDefault(int aid, int uid);
    Address selectDefaultAddress(int uid);

}
