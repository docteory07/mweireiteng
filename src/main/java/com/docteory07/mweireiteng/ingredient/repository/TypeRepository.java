package com.docteory07.mweireiteng.ingredient.repository;

import com.docteory07.mweireiteng.ingredient.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends JpaRepository<Type, Integer> {
}
