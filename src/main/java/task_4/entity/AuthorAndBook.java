package task_4.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table (name = "authorandbook")
public class AuthorAndBook implements Serializable {
    @Id
    @JoinColumn(name = "author_id")
    private long author_id;

    @Id
    @JoinColumn (name = "book_id")
    private long book_id;


    public AuthorAndBook() {
    }

    public AuthorAndBook(long author_id, long book_id) {
        this.author_id = author_id;
        this.book_id = book_id;
    }

    public long getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(long author_id) {
        this.author_id = author_id;
    }

    public long getBook_id() {
        return book_id;
    }

    public void setBook_id(long book_id) {
        this.book_id = book_id;
    }
}
