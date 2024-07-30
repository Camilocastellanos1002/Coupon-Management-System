package riwi.lastfilter.spring.infrastructure.abstrasct_services.interface_services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import riwi.lastfilter.spring.api.dto.request.CouponRequest;
import riwi.lastfilter.spring.api.dto.response.CouponResponse;
import riwi.lastfilter.spring.domain.entities.Coupon;
import riwi.lastfilter.spring.infrastructure.abstrasct_services.ICreate;
import riwi.lastfilter.spring.infrastructure.abstrasct_services.IDelete;
import riwi.lastfilter.spring.infrastructure.abstrasct_services.IFindAll;
import riwi.lastfilter.spring.infrastructure.abstrasct_services.IUpdate;

public interface ICouponService extends IFindAll<PageRequest, Page<Coupon>>,
ICreate<CouponRequest, CouponResponse>,
IDelete<Long,Void >,IUpdate<CouponRequest,CouponResponse, Long>{
    
}
