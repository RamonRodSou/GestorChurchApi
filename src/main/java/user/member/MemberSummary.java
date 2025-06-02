package user.member;

public class MemberSummary {
    private Long id;
    private String name;
    private String email;

    public MemberSummary() { }

    public MemberSummary(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
