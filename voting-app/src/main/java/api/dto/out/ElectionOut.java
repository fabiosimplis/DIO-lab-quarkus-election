package api.dto.out;

import domain.Candidate;
import domain.Election;

import java.util.List;

public record ElectionOut(String id, List<String> candidates) {

    public static ElectionOut fromDomain(Election election) {
        return new ElectionOut(election.id(), election.candidates().stream().map(Candidate::id).toList());
    }
}
