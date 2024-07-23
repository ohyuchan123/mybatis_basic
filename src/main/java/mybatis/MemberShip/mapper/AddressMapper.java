package mybatis.MemberShip.mapper;

import mybatis.MemberShip.model.Address;

import java.util.List;

public interface AddressMapper {
    List<Address> getAddressByMemberId(int memberId);
    void insertAddress(Address address);
    void updateAddress(Address address);
    void deleteAddress(int addressId);
}
