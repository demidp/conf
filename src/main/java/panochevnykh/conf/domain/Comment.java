package panochevnykh.conf.domain;


import javax.persistence.*;
@SuppressWarnings()
@Entity
@Table
public class Comment {

    @GeneratedValue
    @Id
    private int id;
    private String text;
    @ManyToOne
    @JoinColumn(name = "conference_id", nullable = false)
    private Conference conference;
}
