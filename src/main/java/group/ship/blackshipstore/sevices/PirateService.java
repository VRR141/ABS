package group.ship.blackshipstore.sevices;

import group.ship.blackshipstore.entity.Pirate;
import group.ship.blackshipstore.repositories.PirateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PirateService {

    private PirateRepository pirateRepository;

    @Autowired
    public PirateService(PirateRepository pirateRepository) {
        this.pirateRepository = pirateRepository;
    }

    public Optional<Pirate> findByUsername(String username){
        return pirateRepository.findByUsername(username);
    }

    public boolean existsByUsername(String username){
        return pirateRepository.existsByUsername(username);
    }

    public Pirate save(Pirate pirate){
        pirateRepository.saveAndFlush(pirate);
        return pirate;
    }
}
