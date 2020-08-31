package com.xfor.infrastructure.core.store.dao.mybatis;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xfor.infrastructure.core.common.service.ServiceContext;
import com.xfor.infrastructure.core.store.model.Store;
import com.xfor.infrastructure.core.store.dao.StoreDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 */
@Component
public class StoreDAOImpl implements StoreDAO {

    @Autowired
    private StoreRepository storeRepository;

    @Override
    public Store findStoreBySid(ServiceContext sctx, String sid) {
        Store result = this.storeRepository.selectById(sid);
        return result;
    }

    @Override
    public Store findStoreByCode(ServiceContext sctx, String code) {
        QueryWrapper<Store> wrapper = new QueryWrapper<>();
        wrapper.eq("CODE", code);
        Store result = this.storeRepository.selectOne(wrapper);
        return result;
    }

    @Override
    public List<Store> findStoreByFilter(ServiceContext sctx, String filter) {
        QueryWrapper<Store> wrapper = new QueryWrapper<>();
        wrapper.like("CODE", filter).or().like("NAME", filter).or().like("MEMO", filter);
        List<Store> result = this.storeRepository.selectList(wrapper);
        return result;
    }

    @Override
    public int findStoreCountBySid(ServiceContext sctx, String sid) {
        QueryWrapper<Store> wrapper = new QueryWrapper<>();
        wrapper.eq("SID", sid);
        int result = this.storeRepository.selectCount(wrapper);
        return result;
    }

    @Override
    public int findStoreCountByCode(ServiceContext sctx, String code) {
        QueryWrapper<Store> wrapper = new QueryWrapper<>();
        wrapper.eq("CODE", code);
        int result = this.storeRepository.selectCount(wrapper);
        return result;
    }

    @Override
    public int findStoreCountByName(ServiceContext sctx, String name) {
        QueryWrapper<Store> wrapper = new QueryWrapper<>();
        wrapper.eq("NAME", name);
        int result = this.storeRepository.selectCount(wrapper);
        return result;
    }

    @Override
    public boolean saveStore(ServiceContext sctx, Store order) {
        int result = this.storeRepository.updateById(order);
        if(result <= 0) {
            result = this.storeRepository.insert(order);
        }
        return result > 0;
    }

    @Override
    public boolean removeStoreBySid(ServiceContext sctx, String sid) {
        int result = this.storeRepository.deleteById(sid);
        return result > 0;
    }
}
