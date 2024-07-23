package mybatis.MemberShip;


import mybatis.MemberShip.model.Address;
import mybatis.MemberShip.model.Member;
import mybatis.MemberShip.service.MemberService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MemberManagementApp {
    public static void main(String[] args) {
        try {
            String resource = "config/MemberManagement/mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            MemberService memberService = new MemberService(sqlSessionFactory);

            // 회원 등록 예제
            Member newMember = new Member("johndoe", "password123", "John Doe", "john@example.com");
            Address newAddress = new Address();
            newAddress.setAddressType("Home");
            newAddress.setStreet("123 Main St");
            newAddress.setCity("Anytown");
            newAddress.setCountry("USA");

            memberService.registerMember(newMember, newAddress);
            System.out.println("새 회원이 등록되었습니다. ID: " + newMember.getId());

            // 회원 조회 예제
            Member retrievedMember = memberService.getMember(newMember.getId());
            System.out.println("조회된 회원: " + retrievedMember.getName());

            // 회원 정보 수정 예제
            retrievedMember.setEmail("john.doe@example.com");
            memberService.updateMember(retrievedMember);
            System.out.println("회원 정보가 수정되었습니다.");

            // 전체 회원 조회 예제
            System.out.println("전체 회원 목록:");
            for (Member member : memberService.getAllMembers()) {
                System.out.println(member.getName() + " (" + member.getEmail() + ")");
            }

            // 회원 삭제 예제
            memberService.deleteMember(newMember.getId());
            System.out.println("회원이 삭제되었습니다.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}