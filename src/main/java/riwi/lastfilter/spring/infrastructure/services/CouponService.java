package riwi.lastfilter.spring.infrastructure.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Data;
import riwi.lastfilter.spring.api.dto.request.CouponRequest;
import riwi.lastfilter.spring.api.dto.response.CouponResponse;
import riwi.lastfilter.spring.domain.entities.Coupon;
import riwi.lastfilter.spring.domain.repositories.CoupontRepository;
import riwi.lastfilter.spring.infrastructure.abstrasct_services.interface_services.ICouponService;
import riwi.lastfilter.spring.utils.mappers.CouponMapper;

@Service
@Data
@AllArgsConstructor
public class CouponService implements ICouponService{

    @Autowired
    private final CoupontRepository couponRepository;

    @Autowired
    private final CouponMapper couponMapper;

    @Override
    public CouponResponse create(CouponRequest request) {
        
        Coupon coupon = this.couponMapper.toGetEntity((CouponRequest) request);
        coupon.setBuys(new ArrayList<>());

        return this.couponMapper.toGetResp(this.couponRepository.save(coupon));
    }

    @Override
    public Page<Coupon> findAll(PageRequest request) {
        return this.couponRepository.findAll(request);
    }

    

    @Override
    public Void delete(Long request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

 
    
    private Coupon find(Long id){
        return this.couponRepository.findById(id).orElseThrow();
    }

    @Override
    public CouponResponse update(CouponRequest request, Long id) {
        Coupon couponUpdte = find(id);
        return null;
    }


    
}
