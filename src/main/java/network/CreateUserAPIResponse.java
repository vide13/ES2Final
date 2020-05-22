package network;

public class CreateUserAPIResponse {
    String id;
    String name;
    String job;
    String createdAt;

    public CreateUserAPIResponse(String id, String name, String job, String createdAt) {
        this.id = id;
        this.name = name;
        this.job = job;
        this.createdAt = createdAt;
    }
}
