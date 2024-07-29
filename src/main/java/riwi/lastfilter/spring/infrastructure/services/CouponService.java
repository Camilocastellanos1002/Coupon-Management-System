package riwi.lastfilter.spring.infrastructure.services;

import java.util.ArrayList;
import java.util.Optional;

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
import riwi.lastfilter.spring.utils.enums.StateType;
import riwi.lastfilter.spring.utils.exceptions.CouponUsedException;
import riwi.lastfilter.spring.utils.exceptions.IdNotFoundException;
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
    public void delete(Long id) {
        Coupon couponDisable = this.find(id);
        if (couponDisable.getState() == StateType.EXPIRED) {
            throw new CouponUsedException();
        }
        couponDisable.setState(StateType.INACTIVE);
        this.couponRepository.save(couponDisable);
       
    }


    @Override
    public CouponResponse update(CouponRequest request, Long id) {

        Optional<Coupon>existingCoupon = this.couponRepository.findById(id);
        if (existingCoupon.isPresent()) {
            throw new CouponUsedException();
        }else{
            Coupon coupon = find(id);
            Coupon couponUpdate = this.couponMapper.toGetEntity(request);
            couponUpdate.setBuys(coupon.getBuys());
            couponUpdate.setState(coupon.getState());
            couponUpdate.setExpirationDate(coupon.getExpirationDate());

            return this.couponMapper.toGetResp(this.couponRepository.save(couponUpdate));
        }

        
    }

    
    private Coupon find(Long id){
        return this.couponRepository.findById(id).orElseThrow(()->new IdNotFoundException("Coupon"));
    }

    
}
