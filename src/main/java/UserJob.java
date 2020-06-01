public class UserJob {
    private final String name;
    private final String job;
    private final String id;
    private final String createdAt;
    private final String updatedAt;

    public UserJob(String name, String id) {
        this.name = name;
        this.job = "job";
        this.id = "49";
        this.createdAt = "2020-06-01T21:00:08.929Z";
        this.updatedAt = null;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getId() {
        return id;
    }
}
