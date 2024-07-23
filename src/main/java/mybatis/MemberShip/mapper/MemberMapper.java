package mybatis.MemberShip.mapper;

import mybatis.MemberShip.model.Member;

import java.util.List;

public interface MemberMapper {
    Member getMemberById(int memberId);
    List<Member> getAllMembers();
    void insertMember(Member member);
    void updateMember(Member member);
    void deleteMember(int memberId);
}
