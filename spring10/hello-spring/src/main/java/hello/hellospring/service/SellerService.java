package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.domain.Seller;
import hello.hellospring.repository.SellerRepository;

public class SellerService {

    private final SellerRepository sellerRepository;


    public SellerService(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    public Long save(Seller seller) {
        sellerRepository.save(seller);
        return seller.getId();
    }
}
