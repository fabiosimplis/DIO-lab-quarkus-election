package api;

import api.dto.out.ElectionOut;
import domain.Election;
import domain.ElectionService;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class ElectionApi {

    private final ElectionService service;

    public ElectionApi(ElectionService service) {
        this.service = service;
    }

    public List<ElectionOut> findAll() {
        return service.findAll().stream().map(ElectionOut::fromDomain).toList();
    }

    public void vote(String electionId, String candidateId) {
        service.vote(electionId, candidateId);
    }
}
