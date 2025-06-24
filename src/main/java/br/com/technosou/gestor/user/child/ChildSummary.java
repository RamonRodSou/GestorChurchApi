package br.com.technosou.gestor.user.child;

public class ChildSummary {
    private Long id;
    private String name;
    private String phone;

    public ChildSummary() { }

    public ChildSummary(Long id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }
}
