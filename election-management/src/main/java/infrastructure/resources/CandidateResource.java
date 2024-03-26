package infrastructure.resources;

import api.CandidateApi;
import api.dto.in.CreateCandidate;
import api.dto.out.CandidateOut;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.jboss.resteasy.reactive.ResponseStatus;
import org.jboss.resteasy.reactive.RestResponse;

import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/api/candidates")
public class CandidateResource {

    private final CandidateApi api;

    public CandidateResource(CandidateApi candidateApi) {
        this.api = candidateApi;
    }

    @POST
    @ResponseStatus(RestResponse.StatusCode.CREATED)
    @Transactional
    public void create(CreateCandidate dto){
        api.create(dto);
    }

    @GET
    public List<CandidateOut> list(){
        return api.list();
    }


}
