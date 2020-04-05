package panochevnykh.conf.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.mapping.Collection;

import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table
public class Conference {


    @Id
    private String _id;
    private String title;
    @ElementCollection
    private List<String> projects;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "conference_id")
    private Location location;
    @ElementCollection
    private Set<String> tags;

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }

    private Date dateStart;
    private Date dateFinish;
    private String ytLink;
    private Integer attendance;
    private String link;
    @OneToMany
    private List<Comment> comments;
    private String status;

    public Conference() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateFinish() {
        return dateFinish;
    }

    public void setDateFinish(Date dateFinish) {
        this.dateFinish = dateFinish;
    }

    public String getYtLink() {
        return ytLink;
    }

    public List<String> getProjects() {
        return projects;
    }

    public void setProjects(List<String> projects) {
        this.projects = projects;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public void setYtLink(String ytlink) {
        this.ytLink = ytlink;
    }

    public Integer getAttendance() {
        return attendance;
    }

    public void setAttendance(Integer attendance) {
        this.attendance = attendance;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
