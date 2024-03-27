package ru.algor.parser.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "trade_card")
@Entity
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class TradeCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Setter(AccessLevel.PRIVATE)
    @Column(name = "id")
    private Long id;

    @Column(name = "web_link", nullable = false)
    private String link;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String stage;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private LocalDateTime publicationDateTime;

    @Column(nullable = false)
    private LocalDateTime deadlineDateTime;

    private Double startPrice;

    private String currencyType;

    private String regionName;

    @Column(nullable = false)
    private String sourceName;

    private Boolean inFavorites = false;

    private String termsContract;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "tradeCard")
    private List<ProductItem> productItems;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "tradeCard")
    private List<Document> documents;


}
