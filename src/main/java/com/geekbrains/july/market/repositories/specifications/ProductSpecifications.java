package com.geekbrains.july.market.repositories.specifications;

import com.geekbrains.july.market.entities.Product;
import org.apache.catalina.valves.rewrite.InternalRewriteMap;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.beans.Expression;

public class ProductSpecifications {
    public static Specification<Product> priceGreaterOrEqualsThan(int minPrice) {
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("price"), minPrice);
    }

    public static Specification<Product> priceLesserOrEqualsThan(int maxPrice) {
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("price"), maxPrice);
    }

    public static Specification<Product> titleLike(String title) {
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get("title")), '%' + title.toLowerCase() + '%');
        }

    public static Specification<Product> priceIsEmpty() {
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.isEmpty(root.get("price"));
    }

}

