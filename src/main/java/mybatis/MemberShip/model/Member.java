package mybatis.MemberShip.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member {
    private int id;
    private String name;
    private String password;
    private String phone;
    private String email;

    public Member() {}

    public Member(int id, String name, String password, String phone, String email) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.phone = phone;
        this.email = email;
    }
}