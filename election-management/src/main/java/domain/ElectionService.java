package domain;

import domain.annotations.Principal;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Any;
import jakarta.enterprise.inject.Instance;

import java.util.List;

@ApplicationScoped
public class ElectionService {
    private final Instance<ElectionRepository> repositories;
    private final CandidateService candidateService;
    private final ElectionRepository repository;

    public ElectionService(Instance<ElectionRepository> repositories,
                           @Any CandidateService candidateService,
                           @Principal ElectionRepository repository) {
        this.repositories = repositories;
        this.candidateService = candidateService;
        this.repository = repository;
    }

    public List<Election> findall() {

        return repository.findAll();
    }

    public void submit() {
        Election election = Election.create(candidateService.findAll());
        repositories.forEach(repository -> repository.submit(election));
    }

}
