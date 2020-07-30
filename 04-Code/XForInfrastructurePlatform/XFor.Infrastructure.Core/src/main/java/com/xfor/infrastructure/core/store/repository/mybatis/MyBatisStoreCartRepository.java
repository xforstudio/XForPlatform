package com.xfor.infrastructure.core.store.repository.mybatis;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xfor.infrastructure.core.common.service.ServiceContext;
import com.xfor.infrastructure.core.store.model.Store;
import com.xfor.infrastructure.core.store.model.StoreCart;
import com.xfor.infrastructure.core.store.repository.IStoreCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public class MyBatisStoreCartRepository implements IStoreCartRepository {

    @Autowired
    private IStoreCartMyBatisDAO storeCartMyBatisDAO;

    @Override
    public StoreCart findStoreCartBySid(ServiceContext sctx, String sid) {
        StoreCart result = this.storeCartMyBatisDAO.selectById(sid);
        result.ConvertFromEntity();
        return result;
    }

    @Override
    public StoreCart findStoreCartByAccountSid(ServiceContext sctx, String accountSid) {
        QueryWrapper<StoreCart> wrapper = new QueryWrapper<>();
        wrapper.eq("ACCOUNT_SID", accountSid);
        StoreCart result = this.storeCartMyBatisDAO.selectOne(wrapper);
        result.ConvertFromEntity();
        return result;
    }

    @Override
    public boolean saveStoreCart(ServiceContext sctx, StoreCart storeCart) {
        storeCart.ConvertToEntity();
        int result = this.storeCartMyBatisDAO.updateById(storeCart);
        if(result <= 0) {
            result = this.storeCartMyBatisDAO.insert(storeCart);
        }
        return result > 0;
    }

    @Override
    public boolean removeStoreCartBySid(ServiceContext sctx, String sid) {
        int result = this.storeCartMyBatisDAO.deleteById(sid);
        return result > 0;
    }

    @Override
    public boolean removeStoreCartByAccountSid(ServiceContext sctx, String accountSid) {
        QueryWrapper<StoreCart> wrapper = new QueryWrapper<>();
        wrapper.eq("ACCOUNT_SID", accountSid);
        int result = this.storeCartMyBatisDAO.delete(wrapper);
        return result > 0;
    }
}
