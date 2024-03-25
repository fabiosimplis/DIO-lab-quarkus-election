package api;

import api.dto.in.CreateCandidate;
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
}
