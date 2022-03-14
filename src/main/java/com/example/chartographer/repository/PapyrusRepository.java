package com.example.chartographer.repository;

import com.example.chartographer.entity.Papyrus;
import org.hibernate.annotations.NamedNativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.lang.annotation.Native;

@Repository
public interface PapyrusRepository extends JpaRepository<Papyrus, Long> {
}
