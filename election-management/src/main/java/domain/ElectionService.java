package domain;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Any;
import jakarta.enterprise.inject.Instance;

import java.util.List;

@ApplicationScoped
public class ElectionService {
    private final Instance<ElectionRepository> repositories;
    private final CandidateService candidateService;

    public ElectionService(Instance<ElectionRepository> repositories,
                           CandidateService candidateService) {
        this.repositories = repositories;
        this.candidateService = candidateService;
    }

    public void submit() {
        Election election = Election.create(candidateService.findAll());
        repositories.forEach(repository -> repository.submit(election));
    }

}
