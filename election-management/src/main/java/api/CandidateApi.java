package api;

import api.dto.in.CreateCandidate;
import api.dto.out.CandidateOut;
import domain.Candidate;
import domain.CandidateService;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CandidateApi {

    private final CandidateService service;

    public CandidateApi(CandidateService service) {
        this.service = service;
    }

    public void create(CreateCandidate dto) {
        service.save(dto.toDomain());
    }

    public CandidateOut update(String id, api.dto.in.UpdateCandidate dto){
        service.save(dto.toDomain(id));

        return CandidateOut.fromDomain(service.findById(id));
    }
}
