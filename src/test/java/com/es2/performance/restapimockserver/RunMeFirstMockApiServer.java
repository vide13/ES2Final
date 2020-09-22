package com.es2.performance.restapimockserver;
/**
 * Uncomment necessary blocks to run performance tests
 */
/*import org.jsmart.simulator.annotations.ApiRepo;
import org.jsmart.simulator.impl.JsonBasedSimulator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

*//*
 * Created by Siddha on 27/04/2015.
 *
 * Are you done with the web server ? To stop this REST server, simply press Ctrl+c or Stop button on your IDE
 *
 *//*
@ApiRepo("localhost_stubs")
public class RunMeFirstMockApiServer extends JsonBasedSimulator {
    public static final int PORT = 8088;
    private static final Logger logger = LoggerFactory.getLogger(RunMeFirstMockApiServer.class);

    public RunMeFirstMockApiServer(int port) {
        super(port);
    }

    public static void main(String[] args) {
        logger.info("\n----------- REST Helper web-service starting...--------------");
        new RunMeFirstMockApiServer(PORT).start();
        logger.info("\n### REST Helper web-service started.");

        System.out.println("\n------ Done? To stop this REST server, simply press Ctrl+c or Stop button on your IDE -------");

    }
}*/
