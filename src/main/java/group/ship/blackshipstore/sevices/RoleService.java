package group.ship.blackshipstore.sevices;

import group.ship.blackshipstore.entity.Role;
import group.ship.blackshipstore.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService {

    private RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Optional<Role> findByName(String name){
        return roleRepository.findByName(name);
    }
}
