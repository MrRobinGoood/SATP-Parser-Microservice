package ru.algor.parser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.algor.parser.entity.Document;
@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {
}
