package com.ofg.loan

import org.springframework.data.mongodb.repository.MongoRepository


interface LoanApplicationRepository extends MongoRepository<LoanApplication, String> {
}
