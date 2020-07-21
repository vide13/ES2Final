package com.es2.performance.load;

import com.es2.performance.tests.get.GetScreeningServiceTest;
import org.jsmart.zerocode.core.domain.LoadWith;
import org.jsmart.zerocode.core.domain.TestMapping;
import org.jsmart.zerocode.core.runner.parallel.ZeroCodeLoadRunner;
import org.junit.runner.RunWith;

@LoadWith("load_generation.properties")
@TestMapping(testClass = GetScreeningServiceTest.class, testMethod = "testGetScreeningLocalAndGlobal")
@RunWith(ZeroCodeLoadRunner.class)
public class LoadGetTest {

}