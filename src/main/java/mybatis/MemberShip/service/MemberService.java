package mybatis.MemberShip.service;
import mybatis.MemberShip.mapper.AddressMapper;
import mybatis.MemberShip.mapper.MemberMapper;
import mybatis.MemberShip.model.Address;
import mybatis.MemberShip.model.Member;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class MemberService {
    private final SqlSessionFactory sqlSessionFactory;

    public MemberService(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public Member getMember(int id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            MemberMapper mapper = session.getMapper(MemberMapper.class);
            return mapper.getMemberById(id);
        }
    }

    public List<Member> getAllMembers() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            MemberMapper mapper = session.getMapper(MemberMapper.class);
            return mapper.getAllMembers();
        }
    }

    public void registerMember(Member member, Address address) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            MemberMapper memberMapper = session.getMapper(MemberMapper.class);
            AddressMapper addressMapper = session.getMapper(AddressMapper.class);

            memberMapper.insertMember(member);
            address.setMemberId(member.getId());
            addressMapper.insertAddress(address);

            session.commit();
        }
    }

    public void updateMember(Member member) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            MemberMapper mapper = session.getMapper(MemberMapper.class);
            mapper.updateMember(member);
            session.commit();
        }
    }

    public void deleteMember(int id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            MemberMapper mapper = session.getMapper(MemberMapper.class);
            mapper.deleteMember(id);
            session.commit();
        }
    }
}
