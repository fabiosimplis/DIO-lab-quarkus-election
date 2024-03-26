package domain;

import infrastructure.resources.CandidateResource;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusIntegrationTest;

//Teste de integração
@QuarkusIntegrationTest
@TestHTTPEndpoint(CandidateResource.class)
public class CandidateResourceIT {


}
