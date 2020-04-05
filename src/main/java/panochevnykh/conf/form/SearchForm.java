package panochevnykh.conf.form;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.format.annotation.DateTimeFormat;
import panochevnykh.conf.domain.Conference;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.*;

public class SearchForm implements Specification<Conference> {
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date startFrom;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date startTo;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date finishFrom;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date finishTo;
    private String title;
    private Integer attendanceFrom;
    private Integer attendanceTo;
    private String status;
    private Set<String> tags;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getAttendanceFrom() {
        return attendanceFrom;
    }

    public void setAttendanceFrom(Integer attendanceFrom) {
        this.attendanceFrom = attendanceFrom;
    }

    public Integer getAttendanceTo() {
        return attendanceTo;
    }

    public void setAttendanceTo(Integer attendanceTo) {
        this.attendanceTo = attendanceTo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }

    public Date getStartFrom() {
        return startFrom;
    }

    public void setStartFrom(Date startFrom) {
        this.startFrom = startFrom;
    }

    public Date getStartTo() {
        return startTo;
    }

    public void setStartTo(Date startTo) {
        this.startTo = startTo;
    }

    public Date getFinishFrom() {
        return finishFrom;
    }

    public void setFinishFrom(Date finishFrom) {
        this.finishFrom = finishFrom;
    }

    public Date getFinishTo() {
        return finishTo;
    }

    public void setFinishTo(Date finishTo) {
        this.finishTo = finishTo;
    }

    // Выглядит максимально неправильно, кажется можно сделать лучше
    @Override
    public Predicate toPredicate(Root<Conference> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();

        Optional.ofNullable(getStartFrom()).ifPresent(t -> predicates.add(criteriaBuilder.greaterThan(root.get("dateStart"), t)));
        Optional.ofNullable(getStartTo()).ifPresent(t -> predicates.add(criteriaBuilder.lessThan(root.get("dateStart"), t)));
        Optional.ofNullable(getStartFrom()).ifPresent(t -> predicates.add(criteriaBuilder.greaterThan(root.get("dateFinish"), t)));
        Optional.ofNullable(getFinishTo()).ifPresent(t -> predicates.add(criteriaBuilder.lessThan(root.get("dateFinish"), t)));
        Optional.ofNullable(getAttendanceFrom()).ifPresent(t -> predicates.add(criteriaBuilder.greaterThan(root.get("attendance"), t)));
        Optional.ofNullable(getTitle()).ifPresent(t -> predicates.add(criteriaBuilder.like(root.get("title"), t)));
        Optional.ofNullable(getTags()).ifPresent(t -> t.forEach(i -> predicates.add(criteriaBuilder.isMember(i, root.<Set<String>>get("tags")))));

        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
