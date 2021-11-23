package study.jpa.hellojpa;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String username;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    @OneToOne
    @JoinColumn(name = "LOCK_ID")
    private Locker locker;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

//    @Temporal(TemporalType.TIMESTAMP)
//    private Date createDate;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date lastModifiedDate;

    @Embedded
    private Period workPeriod;

    @Embedded
    private Address homeAddress;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "city", column = @Column(name = "workCity"))
            ,@AttributeOverride(name = "street", column = @Column(name = "workStreet"))
            ,@AttributeOverride(name = "zipCode", column = @Column(name = "workZipCode"))
    })
    private Address wordAddress;

    @Lob
    private String description;

    @Transient
    private int tmp;

    public Member() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
