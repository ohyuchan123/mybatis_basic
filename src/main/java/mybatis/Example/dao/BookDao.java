package mybatis.Example.dao;

import mybatis.Example.dto.BookDto;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface BookDao {
    @Select("select bookid, bookname as bookName, publisher, price from book")
    List<BookDto> listBook();

    @Select("select bookid, bookname as bookName, publisher, price from book where bookid = #{bookid}")
    BookDto detailBook(int bookid);

    @Insert("insert into book (bookid, bookname, publisher, price) values (#{bookid}, #{bookName}, #{publisher}, #{price})")
    int insertBook(BookDto bookDto);

    @Update("update book set bookname = #{bookName}, publisher = #{publisher}, price = #{price} where bookid = #{bookid}")
    int updateBook(BookDto bookDto);

    @Delete("delete from book where bookid = #{bookid}")
    int deleteBook(int bookid);
}
