package hello.hellospring.service;

import hello.hellospring.domain.Product;
import hello.hellospring.domain.WishProduct;
import hello.hellospring.repository.WishProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class WishProductService {
    private final WishProductRepository wishProductRepository;

    @Autowired
    public WishProductService(WishProductRepository wishProductRepository) {
        this.wishProductRepository = wishProductRepository;
    }

    public List<WishProduct> findAll() {
        return wishProductRepository.findAll();
    }
}
