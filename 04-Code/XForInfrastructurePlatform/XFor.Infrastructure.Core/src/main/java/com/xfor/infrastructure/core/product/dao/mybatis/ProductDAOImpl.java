package com.xfor.infrastructure.core.product.dao.mybatis;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xfor.infrastructure.core.common.service.ServiceContext;
import com.xfor.infrastructure.core.product.model.Product;
import com.xfor.infrastructure.core.product.dao.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 */
@Component
public class ProductDAOImpl implements ProductDAO {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product getProductBySid(ServiceContext sctx, String sid) {
        Product result = this.productRepository.selectById(sid);
        return result;
    }

    @Override
    public List<Product> getProductsByFilter(ServiceContext sctx, String productStoreSid, String filter) {
        QueryWrapper<Product> wrapper = new QueryWrapper<>();
        wrapper.eq("PRODUCT_STORE_SID", productStoreSid)
                .and(w -> w.like("CODE", filter).or().like("NAME", filter).or().like("MEMO", filter));
        List<Product> result = this.productRepository.selectList(wrapper);
        return result;
    }

    @Override
    public boolean saveProduct(ServiceContext sctx, Product product) {
        int result = this.productRepository.updateById(product);
        if(result <= 0) {
            result = this.productRepository.insert(product);
        }
        return result > 0;
    }

    @Override
    public boolean deleteProductBySid(ServiceContext sctx, String sid) {
        int result = this.productRepository.deleteById(sid);
        return result > 0;
    }

    @Override
    public int getProductCountByCode(ServiceContext sctx, String productStoreSid, String code) {
        QueryWrapper<Product> wrapper = new QueryWrapper<>();
        wrapper.eq("PRODUCT_STORE_SID", productStoreSid).eq("CODE", code);
        int result = this.productRepository.selectCount(wrapper);
        return result;
    }

    @Override
    public int getProductCountByName(ServiceContext sctx, String productStoreSid, String name) {
        QueryWrapper<Product> wrapper = new QueryWrapper<>();
        wrapper.eq("PRODUCT_STORE_SID", productStoreSid).eq("NAME", name);
        int result = this.productRepository.selectCount(wrapper);
        return result;
    }

    @Override
    public boolean saveProductPicturesContent(ServiceContext sctx, String sid, String picturesContent) {
        Product product = this.productRepository.selectById(sid);
        if (product == null) {
            return false;
        }
        product.setPicturesContent(picturesContent);
        int result = this.productRepository.updateById(product);
        return result > 0;
    }
}
