package com.person.api.personApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.person.api.personApi.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
