package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.domain.Seller;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class SellerService {

    private final SellerRepository sellerRepository;

    @Autowired
    public SellerService(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    public Long save(Seller seller) {
        sellerRepository.save(seller);
        return seller.getId();
    }

    public List<Seller> findAll(){
        return sellerRepository.findAll();
    }

    public Optional<Seller> findByMemberid(Long memberid) {
        return sellerRepository.findByMemberid(memberid);
    }


}
