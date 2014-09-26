package com.ofg.loan

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document;

@Document
class LoanApplication {

    @Id
    String id
    String decision;
    Person person;

}

class Person {

    String firstName;
    String lastName;

}