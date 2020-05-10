package sdh2.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class User {

  @Id
  @GeneratedValue
  private long id;
  
  @Lob
  @Column(columnDefinition = "CLOB")
  private String data;
  
  public User() {}
  public User(int id) {
    this(id, null);
  }
  public User(int id, String data) {
    this.id=id;
    this.data=data;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }
  
  public String getData() {
    return data;
  }
  public void setData(String data) {
    this.data = data;
  }
  
  @Override
  public String toString() {
    return "User[" + id + "]";
  }
}
