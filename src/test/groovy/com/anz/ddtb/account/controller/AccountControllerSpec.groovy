package com.anz.ddtb.account.controller

import com.anz.ddtb.account.IntegrationSpecification
import com.anz.ddtb.account.service.AccountService
import groovy.util.logging.Slf4j
import io.restassured.RestAssured
import io.restassured.builder.RequestSpecBuilder
import io.restassured.http.ContentType
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.http.HttpStatus
import spock.lang.Unroll

@Slf4j
class AccountControllerSpec extends IntegrationSpecification{

    @LocalServerPort
    private int port

    @Autowired
    private AccountService accountService

    def setup(){
        RestAssured.port = port;
        RestAssured.requestSpecification = new RequestSpecBuilder()
            .setContentType(ContentType.JSON).build()
    }

    @Unroll
    def "Test accounts"() {
        given:
            def request = RestAssured.given().basePath("").log().all()

        when:
            def response = request.body().get("/accounts");

        then:
            response.then().log().all().statusCode(HttpStatus.OK.value())
            List<Map<String,String>> list = response.jsonPath().getList("\$")
            assert list.size() == 3
            assert list.get(0).get("accountNumber") == "585309209"
            assert list.get(1).get("accountNumber") == "791066619"
            assert list.get(2).get("accountNumber") == "321143048"
    }

    @Unroll
    def "Test transactions?accountNumber={accountNumber}"(String accountNumber, int numOfTransactions) {
        given:
        def request = RestAssured.given().basePath("").log().all()

        when:
        def response = request.body().get("/transactions?accountNumber=" + accountNumber);

        then:
        response.then().log().all().statusCode(HttpStatus.OK.value())
        List<Map<String,String>> list = response.jsonPath().getList("\$")
        assert list.size() == numOfTransactions

        where:
        accountNumber | numOfTransactions
        "585309209"   | 3
        "791066619"   | 0
        "321143048"   | 0
    }

}
