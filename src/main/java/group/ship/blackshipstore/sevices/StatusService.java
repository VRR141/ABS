package group.ship.blackshipstore.sevices;

import group.ship.blackshipstore.entity.Status;
import group.ship.blackshipstore.repositories.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class StatusService {

    private final StatusRepository statusRepository;

    @Autowired
    public StatusService(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    public Status getById(Long id) {
        return statusRepository.findById(id).orElse(null);
    }
}
