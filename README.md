### How To Run
- Download the project and maven import
- Run 'mvn clean install' to build project
- In IntelliJ, mark /test/groovy as Test Sources Root if not done
- Run AccountManagementApplication.main() to start SpringBoot
- Open View account list GET API
  - http://localhost:8080/accounts 
- Open View account transactions (for 3 sample accts)
  - http://localhost:8080/transactions?accountNumber=585309209
  - http://localhost:8080/transactions?accountNumber=791066619
  - http://localhost:8080/transactions?accountNumber=321143048
- Run AccountControllerSpec for Unit Test
  
### Source Package Introduction
- common 
    - Enum and Constants
- controller
    - Spring Controller for 2 GET APIs
- dto 
    - Use mapStruct to map DB entities to DTOs for Controller to use
- entity 
    - Hibernate JPA Entity 
    - AccountEntity join with TransactionEntity on accountNumber (oneToMany)
    - SuperEntity contains audit fields for all entities
- exception
    - ControllerAdvice to intercept exception for standardized exception handling
- repository
    - Account hibernate JPA repo.
    - No need of Transaction repo for now since AccountEntity joined with TransactionEntity
- service
    - SpringBoot service layer
- resources
    - data.sql - initializing sql of in-memory h2 for test

### Test Package Introduction
- groovy 
    - RestAssured to mock API to test
    - Use Spock groovy spec