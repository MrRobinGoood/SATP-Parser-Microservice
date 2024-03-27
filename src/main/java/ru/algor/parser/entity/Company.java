package ru.algor.parser.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Column(name = "id")
    private Long id;

    @Column(nullable = false)
    private String title;
    @Column(name = "web_link")
    private String link;

    private String fullName;

    private String shortName;

    private String businessAddress;
    @Column(name = "number_inn")
    private String numberINN;
    @Column(name = "number_kpp")
    private String numberKPP;
    @Column(name = "type_okvd")
    private String typeOKVD;
    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, mappedBy = "company")
    private List<TradeCard> tradeCards;


}
