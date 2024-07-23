package mybatis.Example.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDto {
    private int bookid;
    private String bookName;
    private String publisher;
    int price;

    public BookDto(int bookid, String bookName, String publisher, int price) {
        this.bookid = bookid;
        this.bookName = bookName;
        this.publisher = publisher;
        this.price = price;
    }
}
