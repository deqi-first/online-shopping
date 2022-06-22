package com.itqf.service.impl;

import com.itqf.dao.AddressDao;
import com.itqf.dao.impl.AddressDaoImpl;
import com.itqf.entity.Address;
import com.itqf.service.AddressService;

import java.util.ArrayList;
import java.util.List;

public class AddressServiceImpl implements AddressService {
    private AddressDao addressDao = new AddressDaoImpl();

    @Override
    public List<Address> findAddressByUid(int uid) {
        List<Address> addressList = new ArrayList<>();
        addressList = addressDao.selectAddressByUid(uid);
        return addressList;
    }

    @Override
    public Address findAddressByAid(int aid) {
        Address address = null;
        address = addressDao.selectAddressByAid(aid);
        return address;
    }

    @Override
    public void updateAddressByAid(Address address) {
        addressDao.updateAddressByAid(address);
    }

    @Override
    public void addAddress(Address address) {
        addressDao.insertAddress(address);
    }

    @Override
    public void deleteAddressByAid(int aid) {
        addressDao.deleteAddressByAid(aid);
    }

    @Override
    public void setAddressToDefault(int aid, int uid) {
        addressDao.setAddressToDefault(aid,uid);
        addressDao.setOuterAddressNotDefault(aid,uid);
    }

    @Override
    public Address findDefaultAddressByUid(int uid) {
        return addressDao.selectDefaultAddress(uid);
    }


}
