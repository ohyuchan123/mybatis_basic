package mybatis.MemberShip.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address {
    private int id;
    private int memberid;
    private String addressType;
    private String street;
    private String city;
    private String country;

    public Address(String country, String city, String street, String addressType, int memberid, int id) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.addressType = addressType;
        this.memberid = memberid;
        this.id = id;
    }
}
