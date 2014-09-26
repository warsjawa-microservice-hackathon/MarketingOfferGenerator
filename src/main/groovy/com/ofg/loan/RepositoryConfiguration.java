package com.ofg.loan;


import com.github.fakemongo.Fongo;
import com.mongodb.Mongo;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories
@ComponentScan(basePackageClasses = {LoanApplicationRepository.class})
public class RepositoryConfiguration extends AbstractMongoConfiguration {

    @Override
    protected String getDatabaseName() {
        return "demo-test";
    }

    @Override
    public Mongo mongo() {
        // uses fongo for in-memory tests
        return new Fongo("mongo-test").getMongo();
    }

    @Override
    protected String getMappingBasePackage() {
        return "com.ofg.loan";
    }

}