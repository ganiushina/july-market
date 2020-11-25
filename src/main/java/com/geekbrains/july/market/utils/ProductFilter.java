package com.geekbrains.july.market.utils;

import com.geekbrains.july.market.entities.Category;
import com.geekbrains.july.market.entities.Product;
import com.geekbrains.july.market.repositories.specifications.ProductSpecifications;
import lombok.Getter;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Map;

@Getter
public class ProductFilter {
    private Specification<Product> spec;
    private StringBuilder filterDefinition;

    public ProductFilter(Map<String, String> map, List<Category> categories
    ) {
        this.spec = Specification.where(null);
        this.filterDefinition = new StringBuilder();
        if (map.containsKey("min_price") && !map.get("min_price").isEmpty()) {
            int minPrice = Integer.parseInt(map.get("min_price"));
            spec = spec.and(ProductSpecifications.priceGreaterOrEqualsThan(minPrice));
            filterDefinition.append("&min_price=").append(minPrice);
        }
        if (map.containsKey("max_price") && !map.get("max_price").isEmpty()) {
            int maxPrice = Integer.parseInt(map.get("max_price"));
            spec = spec.and(ProductSpecifications.priceLesserOrEqualsThan(maxPrice));
            filterDefinition.append("&max_price=").append(maxPrice);
        }

        if (map.containsKey("title") && !map.get("title").isEmpty()) {
            String title = map.get("title");
            spec = spec.and(ProductSpecifications.titleLike(title));
            filterDefinition.append("&title like").append(title);
        }

        if (map.containsKey("price") && !map.get("price").isEmpty()) {
            int price = Integer.parseInt(map.get("price"));
            spec = spec.and(ProductSpecifications.priceIsEmpty());
            filterDefinition.append("&price= null").append(price);
        }
        if (categories != null && !categories.isEmpty()) {
            Specification specCategories = null;
            for (Category c : categories) {
                if (specCategories == null) {
                    specCategories = ProductSpecifications.productCategory(c);
                } else {
                    specCategories = specCategories.or(ProductSpecifications.productCategory(c));
                }
            }
            spec = spec.and(specCategories);
        }

//        if (map.containsKey("category") && !map.get("category").isEmpty()) {
//            String category = map.get("category");
//            spec = spec.and(ProductSpecifications.productCategory(category));
//            filterDefinition.append("&category= ").append(category);
//        }



    }
}
