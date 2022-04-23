package com.itqf.service.impl;

import com.itqf.dao.TypeDao;
import com.itqf.dao.impl.TypeDaoImpl;
import com.itqf.entity.Type;
import com.itqf.service.TypeService;

import java.util.List;

public class TypeServiceImpl implements TypeService {

    @Override
    public List<Type> findAll() {
        List<Type> list = null;
        TypeDao typeDao = new TypeDaoImpl();
        list = typeDao.selectAll();
        return list;
    }
}
