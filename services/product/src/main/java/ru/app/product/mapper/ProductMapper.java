package ru.app.product.mapper;

import org.springframework.stereotype.Service;
import jakarta.validation.constraints.NotNull;
import ru.app.product.dto.ProductPurchaseResponse;
import ru.app.product.dto.ProductRequest;
import ru.app.product.dto.ProductResponse;
import ru.app.product.entity.Category;
import ru.app.product.entity.Product;

@Service
public class ProductMapper {

    public Product toProduct(ProductRequest request) {
        return Product.builder()
            .id(request.id())
            .name(request.name())
            .description(request.description())
            .price(request.price())
            .availableQuantity(request.availableQuantity())
            .category(
                Category.builder()
                    .id(request.categoryId())
                    .build())
            .build();
    }

    public ProductResponse toProductResponse(Product product) {
        return new ProductResponse(
            product.getId(),
            product.getName(),
            product.getDescription(),
            product.getAvailableQuantity(),
            product.getPrice(),
            product.getCategory().getId(),
            product.getCategory().getName(),
            product.getCategory().getDescription()
        );
    }

    public ProductPurchaseResponse toProductPurchaseResponse(Product product, double quantity) {
        return new ProductPurchaseResponse(
            product.getId(),
            product.getName(),
            product.getDescription(),
            product.getPrice(),
            quantity
        );
    }
}
