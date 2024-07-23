package mybatis;

import mybatis.dao.BookDao;
import mybatis.dto.BookDto;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

// config : xml
public class Main {
    public static void main(String[] args) throws IOException {
        // Mybatis 설정 파일을 읽어 온다.
        Reader reader = Resources.getResourceAsReader("config/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // SQL (mapper) + java
        // Java 의 어떤 메소드(BookDao) 가 호출되면 mapper 어떤 sql이 수행되는지 연결
        BookDao bookDao = sqlSession.getMapper(BookDao.class);

        // 목록
//        {
//            List<BookDto> bookDtoList = bookDao.listBook();
//            for (BookDto bookDto : bookDtoList) { // 한껀식 불러와서 추출
//                System.out.println(bookDto);
//            }
//        }

        // 상세
//        {
//            BookDto bookDto = bookDao.detailBook(1);
//            System.out.println(bookDto);
//        }

        // 등록
//        {
//            BookDto bookDto = new BookDto(11, "11번째 책", "uplus press", 5000);
//            int ret = bookDao.insertBook(bookDto);
//            System.out.println(ret);
//            sqlSession.commit();
//        }

        // 수정
        {
            BookDto bookDto = new BookDto(11,"11번째 책 수정","uplus press", 7000);
            int ret = bookDao.updateBook(bookDto);
            System.out.println(ret);
            sqlSession.commit();
        }


        //삭제
//        {
//            int ret = bookDao.deleteBook(11);
//            System.out.println(ret);
//            sqlSession.commit();
//        }
    }
}