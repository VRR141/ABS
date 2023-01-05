package group.ship.blackshipstore.dto.response;

import java.util.List;

public class RoleResponseDto {

    private Long id;

    private String name;

    private List<PirateResponseDto> pirates;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PirateResponseDto> getPirates() {
        return pirates;
    }

    public void setPirates(List<PirateResponseDto> pirates) {
        this.pirates = pirates;
    }
}
