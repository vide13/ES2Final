package com.es2.service.schemas;


import org.jsmart.zerocode.core.domain.Scenario;
import org.jsmart.zerocode.core.domain.TargetEnv;
import org.jsmart.zerocode.core.runner.ZeroCodeUnitRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@TargetEnv("SchemaTests/SchemaTest.properties")
@RunWith(ZeroCodeUnitRunner.class)
public class SchemaCreateUserTest {

    @Scenario("SchemaTests/SchemaCreateUserTest.json")
    @Test
    public void testGet() {

    }
}




