package com.xfor.infrastructure.core.product.dao.mybatis;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xfor.infrastructure.core.common.service.ServiceContext;
import com.xfor.infrastructure.core.product.model.ProductStore;
import com.xfor.infrastructure.core.product.dao.ProductStoreDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 */
@Component
public class ProductStoreDAOImpl implements ProductStoreDAO {

    @Autowired
    private ProductStoreRepository productStoreRepository;

    @Override
    public ProductStore getProductStoreBySid(ServiceContext sctx, String sid) {
        ProductStore result = this.productStoreRepository.selectById(sid);
        return result;
    }

    @Override
    public List<ProductStore> getProductStoresByOwner(ServiceContext sctx, String owner) {
        QueryWrapper<ProductStore> wrapper = new QueryWrapper<>();
        wrapper.eq("OWNER", owner);
        List<ProductStore> result = this.productStoreRepository.selectList(wrapper);
        return result;
    }

    @Override
    public List<ProductStore> getProductStoresByFilter(ServiceContext sctx, String owner, String filter) {
        QueryWrapper<ProductStore> wrapper = new QueryWrapper<>();
        wrapper.eq("OWNER", owner)
                .and(w -> w.like("NAME", filter).or().like("DESC", filter));
        List<ProductStore> result = this.productStoreRepository.selectList(wrapper);
        return result;
    }

    @Override
    public boolean saveProductStore(ServiceContext sctx, ProductStore productStore) {
        int result = this.productStoreRepository.updateById(productStore);
        if(result <= 0) {
            result = this.productStoreRepository.insert(productStore);
        }
        return result > 0;
    }

    @Override
    public boolean deleteProductStoreBySid(ServiceContext sctx, String sid) {
        int result = this.productStoreRepository.deleteById(sid);
        return result > 0;
    }
}
