package com.xfor.infrastructure.core.order.dao.mybatis;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xfor.infrastructure.core.common.service.ServiceContext;
import com.xfor.infrastructure.core.order.model.SubOrder;
import com.xfor.infrastructure.core.order.dao.SubOrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SubOrderDAOImpl implements SubOrderDAO {

    @Autowired
    private SubOrderRepository subOrderRepository;

    public SubOrderDAOImpl() {
    }

    @Override
    public SubOrder getSubOrderBySid(ServiceContext sctx, String sid) {
        SubOrder result = this.subOrderRepository.selectById(sid);
        return result;
    }

    @Override
    public List<SubOrder> getSubOrdersByOrderSid(ServiceContext sctx, String orderSid) {
        QueryWrapper<SubOrder> wrapper = new QueryWrapper<>();
        wrapper.eq("ORDER_SID", orderSid);
        List<SubOrder> result = this.subOrderRepository.selectList(wrapper);
        return result;
    }

    @Override
    public boolean saveSubOrder(ServiceContext sctx, SubOrder subOrder) {
        int result = this.subOrderRepository.updateById(subOrder);
        if(result <= 0) {
            result = this.subOrderRepository.insert(subOrder);
        }
        return result > 0;
    }

    @Override
    public boolean removeSubOrderBySid(ServiceContext sctx, String sid) {
        int result = this.subOrderRepository.deleteById(sid);
        return result > 0;
    }

    @Override
    public boolean removeSubOrdersByOrderSid(ServiceContext sctx, String orderSid) {
        QueryWrapper<SubOrder> wrapper = new QueryWrapper<>();
        wrapper.eq("ORDER_SID", orderSid);
        int result = this.subOrderRepository.delete(wrapper);
        return result > 0;
    }
}
