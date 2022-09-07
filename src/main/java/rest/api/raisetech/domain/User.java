package rest.api.raisetech.domain;

public class User {
    private final long id;
    private final String content;

    private final String birthDate;

    public String getBirthDate() {
        return birthDate;
    }

    public User(long id, String content, String birthDate) {
        this.id = id;
        this.content = content;
        this.birthDate = birthDate;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
