package hello.hellospring.repository;

import hello.hellospring.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SpringDataJpaProductRepository extends JpaRepository<Product, Long>, ProductRepository {

//    @Query("select hello.hellospring.domain.Product(id, userid, name, qty, createdate, updatedate, image) from Product p order by p.name")
    List<Product> findByNameOrderByNameAsc(String name);
}
