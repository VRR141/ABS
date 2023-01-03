package group.ship.blackshipstore.security;

import group.ship.blackshipstore.entity.Pirate;
import group.ship.blackshipstore.entity.Role;
import group.ship.blackshipstore.sevices.PirateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private PirateService pirateService;

    @Autowired
    public CustomUserDetailsService(PirateService pirateService) {
        this.pirateService = pirateService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Pirate pirate = pirateService.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("not found"));
        return new User(pirate.getUsername(), pirate.getPassword(), mapRolesToAuthorities(pirate.getRoles()));
    }

    private Collection<GrantedAuthority> mapRolesToAuthorities(List<Role> roleList){
        return roleList.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
