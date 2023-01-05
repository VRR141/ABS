package group.ship.blackshipstore.exception_handling;

public class BadJwtToken {
    private String info;

    public BadJwtToken() {
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
