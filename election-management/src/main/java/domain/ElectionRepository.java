package domain;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public interface ElectionRepository {
    void submit(Election election);

}
