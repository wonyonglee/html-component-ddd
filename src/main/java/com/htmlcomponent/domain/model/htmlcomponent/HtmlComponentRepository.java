package com.htmlcomponent.domain.model.htmlcomponent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HtmlComponentRepository extends JpaRepository<HtmlComponent, Long> {
}