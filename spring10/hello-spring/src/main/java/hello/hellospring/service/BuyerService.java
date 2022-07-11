package hello.hellospring.service;

import hello.hellospring.domain.Buyer;
import hello.hellospring.repository.BuyerRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class BuyerService {

    private final BuyerRepository buyerRepository;

    @Autowired
    public BuyerService(BuyerRepository buyerRepository) {
        this.buyerRepository = buyerRepository;
    }

    public Long save(Buyer buyer) {
        buyerRepository.save(buyer);
        return buyer.getId();
    }

}
