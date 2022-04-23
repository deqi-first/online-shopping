package com.itqf.dao.impl;

import com.itqf.dao.AddressDao;
import com.itqf.entity.Address;
import com.itqf.utils.C3p0Utils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AddressDaoImpl implements AddressDao {
    private QueryRunner queryRunner = new QueryRunner(C3p0Utils.getDataSource());

    @Override
    public List<Address> selectAddressByUid(int uid) {
        List<Address> addressList = new ArrayList<>();
        String sql = "select a_id as aid,u_id as uid,a_name as aname,a_phone as aphone,a_detail as adetail,a_state as astate from address where u_id =?";
        try {
            addressList = queryRunner.query(sql, new BeanListHandler<>(Address.class), uid);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return addressList;
    }

    @Override
    public Address selectAddressByAid(int aid) {
        Address address = null;
        String sql = "select a_id as aid,u_id as uid,a_name as aname,a_phone as aphone,a_detail as adetail,a_state as astate from address where a_id =?";
        try {
            address = queryRunner.query(sql, new BeanHandler<>(Address.class), aid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return address;
    }

    @Override
    public void updateAddressByAid(Address address) {
        String sql = "update address set a_name=?,a_phone=?,a_detail=? where a_id = ?";
        try {
            queryRunner.update(sql, address.getAname(), address.getAphone(), address.getAdetail(), address.getAid());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void insertAddress(Address address) {
        String sql = "insert into address(u_id,a_name,a_phone,a_detail,a_state) values(?,?,?,?,?);";
        try {
            queryRunner.update(sql, address.getUid(), address.getAname(), address.getAphone(), address.getAdetail(), address.getAstate());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAddressByAid(int aid) {
        String sql = "delete from address where a_id =?";
        try {
            queryRunner.update(sql, aid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setAddressToDefault(int aid, int uid) {
        String sql = "update address set a_state =? where a_id =? and u_id = ?;";
        try {
            queryRunner.update(sql, 1, aid, uid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setOuterAddressNotDefault(int aid, int uid) {
        String sql = "update address set a_state =? where a_id !=? and u_id = ?;";
        try {
            queryRunner.update(sql, 0, aid, uid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
