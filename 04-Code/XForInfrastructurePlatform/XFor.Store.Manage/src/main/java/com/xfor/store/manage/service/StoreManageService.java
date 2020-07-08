package com.xfor.store.manage.service;

import com.xfor.infrastructure.core.common.model.IDateTimeProvider;
import com.xfor.infrastructure.core.common.service.BaseService;
import com.xfor.infrastructure.core.store.repository.IStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class StoreManageService extends BaseService {

    @Autowired
    private IStoreRepository storeRepository;
    @Autowired
    private IDateTimeProvider dateTimeProvider;

    /* Store */
}
