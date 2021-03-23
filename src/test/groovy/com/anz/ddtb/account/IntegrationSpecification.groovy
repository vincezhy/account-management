package com.anz.ddtb.account

import io.restassured.RestAssured
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import spock.lang.Specification

@ActiveProfiles("test")
@SpringBootTest(classes = AccountManagementApplication.class
        , webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
class IntegrationSpecification extends Specification{

    def setupSpec(){
        RestAssured.reset()
    }

}
