package mybatis.MemberShip.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address {
    private int id;
    private int memberId;
    private String addressType;
    private String street;
    private String city;
    private String country;

    public Address() {} // 기본 생성자 추가

    // 필요한 경우 모든 필드를 초기화하는 생성자도 추가할 수 있습니다
    public Address(int memberId, String addressType, String street, String city, String country) {
        this.memberId = memberId;
        this.addressType = addressType;
        this.street = street;
        this.city = city;
        this.country = country;
    }
}
