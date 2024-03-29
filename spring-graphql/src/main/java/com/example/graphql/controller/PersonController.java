package com.example.graphql.controller;

import com.example.graphql.entity.Person;
import com.example.graphql.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class PersonController {
    private final PersonRepository personRepository;

    @SchemaMapping(typeName = "Query", value = "findAll")
    public List<Person> findAll() {
        return (List<Person>) personRepository.findAll();
    }

    @SchemaMapping(typeName = "Query", value = "findById")
    public Optional<Person> findById(@Argument Integer id) {
        return personRepository.findById(id);
    }
}

/* test query */
/*
{
    findAll {
        id
        firstName
        lastName
        address {
        address
        city
        }
    }
}


{
    findById(id: 1) {
        id
        firstName
        lastName
        address {
        address
        city
        }
    }
}*/
