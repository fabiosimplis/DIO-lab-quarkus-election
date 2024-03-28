package infrastructure.lifecycle;

import domain.Election;
import infrastructure.repositories.RedisElectionRepository;
import io.quarkus.redis.datasource.ReactiveRedisDataSource;
import io.quarkus.runtime.Startup;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.infrastructure.Infrastructure;
import jakarta.enterprise.context.ApplicationScoped;
import org.jboss.logging.Logger;


@Startup //Quando a app inicia, essa classe será injetada
@ApplicationScoped
public class Subscribe {

    private static final Logger LOGGER = Logger.getLogger(Subscribe.class);

    //Usando o suporte para linguagem reativa do Redis
    public Subscribe(ReactiveRedisDataSource reactiveRedisDataSource, RedisElectionRepository repository){
        LOGGER.info("Startup: Subscribe");

        Multi<String> sub = reactiveRedisDataSource.pubsub(String.class)
                .subscribe("elections");

        sub.emitOn(Infrastructure.getDefaultWorkerPool())//2024-03-28 16:05:17,316 INFO  [inf.rep.RedisElectionRepository] (executor-thread-1) Retrieving election election-id from redis

                .subscribe()//Ouvindo o canal de streams e pronto para receber objetos nele
                .with(id -> { //Recebendo os objetos
                    LOGGER.info("Election " + id + " received from subscription");
                    Election election = repository.findById(id);
                    LOGGER.info("Election "+ election.id() + "starting");
                });
        /*redisDataSource.pubsub(String.class).subscribe("elections", id -> {
            LOGGER.info("Election " + id + " received from subscription");
            Election election = repository.findById(id);
            LOGGER.info("Election "+ election.id() + "starting");
        });*/

    }
}
