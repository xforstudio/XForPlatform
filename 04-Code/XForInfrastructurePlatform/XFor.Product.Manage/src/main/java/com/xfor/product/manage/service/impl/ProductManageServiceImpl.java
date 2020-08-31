package com.xfor.product.manage.service.impl;

import com.xfor.infrastructure.core.common.model.IDateTimeProvider;
import com.xfor.infrastructure.core.common.service.BaseService;
import com.xfor.infrastructure.core.common.service.ServiceContext;
import com.xfor.infrastructure.core.product.model.Product;
import com.xfor.infrastructure.core.product.model.ProductException;
import com.xfor.infrastructure.core.product.dao.ProductDAO;
import com.xfor.product.manage.service.ProductManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManageServiceImpl extends BaseService implements ProductManageService {

    @Autowired
    private ProductDAO productDAO;
    @Autowired
    private IDateTimeProvider dateTimeProvider;

    /* Product */

    @Override
    public Product createProduct(Product fields) throws ProductException {
        ServiceContext sctx = this.doGetServiceContext();
        Product product = Product._create(
                fields.getProductStoreSid(),
                fields.getCode(),
                fields.getName(),
                fields.getMemo(),
                fields.getPrice(),
                fields.getSaleState(),
                this.dateTimeProvider);
        product.validate();
        boolean result = false;
        result = this.doExistsProductByCode(sctx, product);
        if (result) {
            throw new ProductException("商品代码【" + product.getCode() + "】已存在");
        }
        result = this.doExistsProductByName(sctx, product);
        if (result) {
            throw new ProductException("商品名称【" + product.getName() + "】已存在");
        }
        result = this.productDAO.saveProduct(sctx, product);
        if (!result) {
            throw new ProductException("保存商品信息失败");
        }
        return product;
    }

    @Override
    public Product saveProduct(Product fields) throws ProductException {
        ServiceContext sctx = this.doGetServiceContext();
        Product product = this.productDAO.getProductBySid(sctx, fields.getSid());
        if (product == null) {
            throw new ProductException("商品信息不存在");
        }
        //设置&验证
        product.setCode(fields.getCode());
        product.setName(fields.getName());
        product.setMemo(fields.getMemo());
        product.setPrice(fields.getPrice());
        product.setSaleState(fields.getSaleState());
        product.validate();
        //保存
        boolean result = this.productDAO.saveProduct(sctx, product);
        if (!result) {
            throw new ProductException("保存商品信息失败");
        }
        return product;
    }

    @Override
    public boolean removeProductBySid(String productSid) {
        ServiceContext sctx = this.doGetServiceContext();
        boolean result = this.productDAO.deleteProductBySid(sctx, productSid);
        return result;
    }

    @Override
    public Product getProductBySid(String productSid) {
        ServiceContext sctx = this.doGetServiceContext();
        Product result = this.productDAO.getProductBySid(sctx, productSid);
        return result;
    }

    @Override
    public List<Product> getProductsByFilter(String productStoreSid, String filter) {
        ServiceContext sctx = this.doGetServiceContext();
        List<Product> result = this.productDAO.getProductsByFilter(sctx, productStoreSid, filter);
        return result;
    }

    /* ProductStore */

    /* ProductCategory */

    /* ProductCategoryRela */

    /* ProductTag */


    protected boolean doExistsProductByCode(ServiceContext sctx, Product product) {
        int count = this.productDAO.getProductCountByCode(sctx, product.getProductStoreSid(), product.getCode());
        return count > 0;
    }

    protected boolean doExistsProductByName(ServiceContext sctx, Product product) {
        int count = this.productDAO.getProductCountByName(sctx, product.getProductStoreSid(), product.getName());
        return count > 0;
    }
}
