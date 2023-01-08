package group.ship.blackshipstore.sevices;

import group.ship.blackshipstore.BlackShipStoreApplicationTests;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.SpyBean;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PirateServiceTest extends BlackShipStoreApplicationTests {

    @SpyBean
    private PirateService pirateService;

    @Test
    void findByUsernameCacheable() {
        String log = "login1";
        pirateService = Mockito.spy(pirateService);

        for (int i = 0; i < 5; i++){
            pirateService.findByUsernameCacheable(log);
        }

        Mockito.verify(pirateService, Mockito.times(1))
                .findByUsernameCacheable(log);
    }


}