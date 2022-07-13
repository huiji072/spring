package hello.hellospring.repository;

import hello.hellospring.domain.Product;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

public interface ProductOrderRepository {

    List<Product> findAll();

}
