package com.es2.service.schemas;

import org.jsmart.zerocode.core.domain.Scenario;
import org.jsmart.zerocode.core.domain.TargetEnv;
import org.jsmart.zerocode.core.runner.ZeroCodeUnitRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@SuppressWarnings("EmptyMethod")
@TargetEnv("SchemaTests/SchemaTest.properties")
@RunWith(ZeroCodeUnitRunner.class)
public class SchemaTests {

    @Scenario("SchemaTests/SchemaCreateUserTest.json")
    @Test
    public void SchemaCreateUserTest() {

    }

    @Scenario("SchemaTests/SchemaListResourcesTest.json")
    @Test
    public void SchemaListResourcesTest() {

    }

    @Scenario("SchemaTests/SchemaListUsersTest.json")
    @Test
    public void SchemaListUsersTest() {

    }

    @Scenario("SchemaTests/SchemaLoginUserTest.json")
    @Test
    public void SchemaLoginUserTest() {

    }

    @Scenario("SchemaTests/SchemaRegisterUserTest.json")
    @Test
    public void SchemaRegisterUserTest() {

    }

    @Scenario("SchemaTests/SchemaSingleResourceTest.json")
    @Test
    public void SchemaSingleResourceTest() {

    }

    @Scenario("SchemaTests/SchemaSingleUserTest.json")
    @Test
    public void SchemaSingleUserTest() {

    }

    /**
     * Testing if, when asked for 2 resources per page the response is correct
     */
    @Scenario("SchemaTests/SchemaListResourcesPerPageTest.json")
    @Test
    public void SchemaListResourcesPerPageTest() {

    }

    /**
     * Testing if, when asked for 2 users per page the response is correct
     */
    @Scenario("SchemaTests/SchemaListUsersPerPageTest.json")
    @Test
    public void SchemaListUsersPerPageTest() {

    }
}
