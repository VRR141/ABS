package group.ship.blackshipstore.repository;

import group.ship.blackshipstore.BlackShipStoreApplicationTests;
import group.ship.blackshipstore.repositories.PirateRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

@ExtendWith(MockitoExtension.class)
public class PirateRepositoryTest extends BlackShipStoreApplicationTests {

    @Autowired
    private PirateRepository pirateRepository;

    @Test
    public void findByUsernameCacheableTest(){
        Long firstExpected = 1L;
        Long secondExpected = 2L;

        String login1 = "login1";
        String login2 = "login2";

        Long firstActual = pirateRepository.findByUsernameCacheable(login1).get();
        Long secondActual = pirateRepository.findByUsernameCacheable(login2).get();

        Assertions.assertEquals(firstExpected, firstActual);
        Assertions.assertEquals(secondExpected, secondActual);

    }

}
