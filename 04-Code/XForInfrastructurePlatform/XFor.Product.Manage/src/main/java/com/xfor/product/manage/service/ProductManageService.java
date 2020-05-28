package com.xfor.product.manage.service;

import com.xfor.infrastructure.core.common.model.IDateTimeProvider;
import com.xfor.infrastructure.core.common.service.BaseService;
import com.xfor.infrastructure.core.common.service.ServiceContext;
import com.xfor.infrastructure.core.common.util.StringUtil;
import com.xfor.infrastructure.core.product.model.Product;
import com.xfor.infrastructure.core.product.model.ProductException;
import com.xfor.infrastructure.core.product.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManageService extends BaseService {

    @Autowired
    private IProductRepository productRepository;
    @Autowired
    private IDateTimeProvider dateTimeProvider;

    public ProductManageService() {
        super();
        //throw new UnsupportedOperationException();
    }

    protected boolean doExistsProductByCode(ServiceContext sctx, Product product) {
        int count = this.productRepository.getProductCountByCode(sctx, product.getProductStoreSid(), product.getCode());
        return count > 0;
    }

    protected boolean doExistsProductByName(ServiceContext sctx, Product product) {
        int count = this.productRepository.getProductCountByCode(sctx, product.getProductStoreSid(), product.getName());
        return count > 0;
    }

    /* Product */

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
        result = this.productRepository.saveProduct(sctx, product);
        if (!result) {
            throw new ProductException("保存商品信息失败");
        }
        return product;
    }

    public Product saveProduct(Product fields) throws ProductException {
        ServiceContext sctx = this.doGetServiceContext();
        Product product = this.productRepository.getProductBySid(sctx, fields.getSid());
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
        boolean result = this.productRepository.saveProduct(sctx, product);
        if (!result) {
            throw new ProductException("保存商品信息失败");
        }
        return product;
    }

    public boolean removeProductBySid(String productSid) {
        ServiceContext sctx = this.doGetServiceContext();
        boolean result = this.productRepository.deleteProductBySid(sctx, productSid);
        return result;
    }

    public Product getProductBySid(String productSid) {
        ServiceContext sctx = this.doGetServiceContext();
        Product result = this.productRepository.getProductBySid(sctx, productSid);
        return result;
    }

    public List<Product> getProductsByFilter(String productStoreSid, String filter) {
        ServiceContext sctx = this.doGetServiceContext();
        List<Product> result = this.productRepository.getProductsByFilter(sctx, productStoreSid, filter);
        return result;
    }

    /* ProductStore */


    /* ProductCategory */

    /* ProductCategoryRela */

    /* ProductTag */
}
