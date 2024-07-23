package mybatis.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDto {
    private int bookid;
    private String bookname;
    private String publisher;
    int price;

    public BookDto(int bookid, String bookname, String publisher, int price) {
        this.bookid = bookid;
        this.bookname = bookname;
        this.publisher = publisher;
        this.price = price;
    }
}
