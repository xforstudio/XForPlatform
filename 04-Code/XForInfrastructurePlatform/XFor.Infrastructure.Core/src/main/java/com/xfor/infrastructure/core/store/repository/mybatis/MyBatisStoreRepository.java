package com.xfor.infrastructure.core.store.repository.mybatis;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xfor.infrastructure.core.common.service.ServiceContext;
import com.xfor.infrastructure.core.store.model.Store;
import com.xfor.infrastructure.core.store.repository.IStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 */
@Component
public class MyBatisStoreRepository implements IStoreRepository {

    @Autowired
    private IStoreMyBatisDAO storeMyBatisDAO;

    @Override
    public Store getStoreBySid(ServiceContext sctx, String sid) {
        Store result = this.storeMyBatisDAO.selectById(sid);
        return result;
    }

    @Override
    public Store getStoreByCode(ServiceContext sctx, String code) {
        QueryWrapper<Store> wrapper = new QueryWrapper<>();
        wrapper.eq("CODE", code);
        Store result = this.storeMyBatisDAO.selectOne(wrapper);
        return result;
    }

    @Override
    public List<Store> getStoreByFilter(ServiceContext sctx, String filter) {
        QueryWrapper<Store> wrapper = new QueryWrapper<>();
        wrapper.like("CODE", filter).or().like("NAME", filter).or().like("MEMO", filter);
        List<Store> result = this.storeMyBatisDAO.selectList(wrapper);
        return result;
    }

    @Override
    public boolean saveStore(ServiceContext sctx, Store order) {
        int result = this.storeMyBatisDAO.updateById(order);
        if(result <= 0) {
            result = this.storeMyBatisDAO.insert(order);
        }
        return result > 0;
    }

    @Override
    public boolean removeStoreBySid(ServiceContext sctx, String sid) {
        return false;
    }
}
