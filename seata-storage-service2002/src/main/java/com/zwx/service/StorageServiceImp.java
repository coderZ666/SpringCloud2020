package com.zwx.service;

import com.zwx.dao.StorageDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author coderZWX
 * @date 2020-12-28 21:17
 */
@Service
public class StorageServiceImp implements StorageService {

    @Resource
    private StorageDao storageDao;

    @Override
    public void decrease(Long productId, Integer count) {
        System.out.println(productId+"\t"+count);
        storageDao.decrease(productId,count);
    }

}
