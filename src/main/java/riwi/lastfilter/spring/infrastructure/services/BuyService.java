package riwi.lastfilter.spring.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import riwi.lastfilter.spring.domain.entities.Buy;
import riwi.lastfilter.spring.domain.repositories.BuyRepository;
import riwi.lastfilter.spring.infrastructure.abstrasct_services.interface_services.IBuyService;

@Service
@Transactional
@AllArgsConstructor
public class BuyService implements IBuyService{
    
    @Autowired
    private final BuyRepository buyRepository;

    // Find All
    @Override
    public Page<Buy> findAll(PageRequest request) {
        return buyRepository.findAll(request);
    }
}
