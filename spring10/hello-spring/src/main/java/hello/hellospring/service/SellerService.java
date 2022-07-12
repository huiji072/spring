package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.domain.Seller;
import hello.hellospring.repository.SellerRepository;

import java.util.Optional;

public class SellerService {

    private final SellerRepository sellerRepository;


    public SellerService(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    public Long save(Seller seller) {
        sellerRepository.save(seller);
        return seller.getId();
    }

    public Optional<Seller> findByMemberid(Long memberid) {
        return sellerRepository.findByMemberid(memberid);
    }

    public boolean existsMemberid(Seller seller) {
        if(sellerRepository.findById(seller.getMemberid()).isPresent()) {
            return true;
        }
        return false;
    }

}
