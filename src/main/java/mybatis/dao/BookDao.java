package mybatis.dao;

import mybatis.dto.BookDto;

import java.util.List;

public interface BookDao {
    List<BookDto> listBook();
    BookDto getBookById(int bookid);
    int insertBook(BookDto bookDto);
    int updateBook(BookDto bookDto);
    int deleteBook(BookDto bookDto);
}
