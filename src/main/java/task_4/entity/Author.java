package task_4.entity;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
@DynamicUpdate
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

 //   @Column(name = "last_name")
    private String lastName;
    @ManyToMany( fetch = FetchType.EAGER)
    @JoinTable (name = "AuthorAndbook",
            joinColumns ={
                   @JoinColumn ( table = "author", name = "author_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "book_id")})

    private List<Book> book = new ArrayList<>();

    public Author(String name) {
        this.name = name;
    }

    public Author() {

    }

    public Author(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
    public List<Book> getBooks() {
        return book;
    }

    public void setBooks(List<Book> books) {
        this.book = book;
    }



}

//            joinColumns ={ @JoinColumn (name = "author_id")},
//          inverseJoinColumns ={ @JoinColumn(name = "book_id")})
