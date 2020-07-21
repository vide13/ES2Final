package com.es2.performance.loadgradually;

import com.es2.performance.loadgradually.get.LoadGet1Per1SecTest;
import com.es2.performance.loadgradually.get.LoadGet1Per5SecTest;
import com.es2.performance.loadgradually.get.LoadGet5Per1SecTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@Suite.SuiteClasses({

        LoadGet1Per5SecTest.class, // <-- Less load (5 sec gap)
        LoadGet1Per1SecTest.class, // <-- Bit more load (1 sec gap)
        LoadGet5Per1SecTest.class  // <-- Heavy load (0.2 sec gap)

})
@RunWith(Suite.class)
public class LoadGraduallyTestSuite {

}
