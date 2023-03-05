package task_4.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable (name = "AuthorAndbook", joinColumns ={
                    @JoinColumn ( name = "book_id")},
                    inverseJoinColumns = {@JoinColumn(name = "author_id")})
    private List<Author> author = new ArrayList<>();

    public Book() {

    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Author> getAuthors() {
        return author;
    }

    public void setAuthors(List<Author> author) {
        this.author = author;
    }
}

//            joinColumns ={ @JoinColumn (name = "book_id")},
//            inverseJoinColumns ={ @JoinColumn(name = "author_id")})


