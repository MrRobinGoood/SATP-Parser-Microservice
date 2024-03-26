package ru.algor.parser.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Table(name = "company")
@Entity
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Setter(AccessLevel.PRIVATE)
    private Long id;

    @Column(nullable = false)
    private String title;
    @Column(name = "web_link")
    private String link;

    private String fullName;

    private String shortName;

    private String businessAddress;

    private Long numberINN;

    private Long numberKPP;

    private String typeOKVD;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "company")
    private List<TradeCard> tradeCards;


}
