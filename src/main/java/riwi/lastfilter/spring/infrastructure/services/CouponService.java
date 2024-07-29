package riwi.lastfilter.spring.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Data;
import riwi.lastfilter.spring.infrastructure.abstrasct_services.ICreate;
import riwi.lastfilter.spring.infrastructure.abstrasct_services.IDelete;
import riwi.lastfilter.spring.infrastructure.abstrasct_services.IFindAll;
import riwi.lastfilter.spring.infrastructure.abstrasct_services.IUpdate;

@SuppressWarnings("rawtypes")
@Service
@Data
@AllArgsConstructor
public class CouponService implements ICreate,IDelete,IFindAll,IUpdate{

    @Autowired
    private final CouponService couponService;

    
    @Override
    public Object create(Object request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }
    @Override
    public Object findAll(Object request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Object update(Object request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Object delete(Object request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    
}
