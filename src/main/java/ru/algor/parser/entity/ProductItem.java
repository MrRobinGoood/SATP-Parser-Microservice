package ru.algor.parser.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "product_item")
@Entity
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class ProductItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Setter(AccessLevel.PRIVATE)
    private Long id;

    @Column(nullable = false)
    private String title;
    @Column(name="count_of",nullable = false)
    private Long count;
    @Column(nullable = false)
    private String measureUnit;

    private String description;

    private String deliveryAddress;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trade_card_id")
    private TradeCard tradeCard;
}
