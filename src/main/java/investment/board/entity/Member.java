package investment.board.entity;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Builder
public class Member {

    @Id
    @GeneratedValue
    private Long id;
    private String memberId;
    private String username;
    private String email;
    private String password;
}
