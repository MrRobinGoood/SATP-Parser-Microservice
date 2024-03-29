package ru.algor.parser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.algor.parser.entity.Company;
import ru.algor.parser.entity.ProductItem;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    Company findByLink(String link);
}
