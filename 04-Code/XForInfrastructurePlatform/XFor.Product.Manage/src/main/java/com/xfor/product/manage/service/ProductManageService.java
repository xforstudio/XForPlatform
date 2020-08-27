package com.xfor.product.manage.service;

import com.xfor.infrastructure.core.common.model.IDateTimeProvider;
import com.xfor.infrastructure.core.common.service.BaseService;
import com.xfor.infrastructure.core.common.service.ServiceContext;
import com.xfor.infrastructure.core.common.util.StringUtil;
import com.xfor.infrastructure.core.product.model.Product;
import com.xfor.infrastructure.core.product.model.ProductException;
import com.xfor.infrastructure.core.product.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public interface ProductManageService {

    /* Product */

    Product createProduct(Product fields) throws ProductException;

    Product saveProduct(Product fields) throws ProductException;

    boolean removeProductBySid(String productSid);

    Product getProductBySid(String productSid);

    List<Product> getProductsByFilter(String productStoreSid, String filter);

    /* ProductStore */

    /* ProductCategory */

    /* ProductCategoryRela */

    /* ProductTag */
}
