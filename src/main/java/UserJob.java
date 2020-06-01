import java.time.LocalDateTime;

public class UserJob {
    private String name;
    private String job;
    private final String id;
    private String createdAt;
    private String updatedAt;

    public UserJob(String name, String job, String id, String createdAt) {
        this.name = name;
        this.job = job;
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = null;
    }

    public UserJob(String name, String job) {
        this.name = name;
        this.job = job;
        this.id = "421";
        LocalDateTime dataHora = LocalDateTime.now();
        this.createdAt = dataHora.toString();
        this.updatedAt = null;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }
}
