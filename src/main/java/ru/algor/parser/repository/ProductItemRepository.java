package ru.algor.parser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.algor.parser.entity.ProductItem;
import ru.algor.parser.entity.TradeCard;
@Repository
public interface ProductItemRepository extends JpaRepository<ProductItem, Long> {
}
