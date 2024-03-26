package ru.algor.parser.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "documents")
@Entity
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Setter(AccessLevel.PRIVATE)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(name = "web_link", nullable = false)
    private String link;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trade_card_id")
    private TradeCard tradeCard;

}
