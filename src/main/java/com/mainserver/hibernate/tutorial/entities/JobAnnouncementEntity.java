package com.mainserver.hibernate.tutorial.entities;

import javax.persistence.*;

@Entity
@Table(name = "job_announcements")
public class JobAnnouncementEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "position", nullable = false)
    private String position;

    @Column(name = "salary_from", nullable = false)
    private Double salaryFrom;

    @Column(name = "salary_to", nullable = false)
    private Double salaryTo;

    @Column(name = "description")
    private String description;

    @ManyToOne
    private CompanyEntity companyEntity;

    public JobAnnouncementEntity() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Double getSalaryFrom() {
        return salaryFrom;
    }

    public void setSalaryFrom(Double salaryFrom) {
        this.salaryFrom = salaryFrom;
    }

    public Double getSalaryTo() {
        return salaryTo;
    }

    public void setSalaryTo(Double salaryTo) {
        this.salaryTo = salaryTo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CompanyEntity getCompanyEntity() {
        return companyEntity;
    }

    public void setCompanyEntity(CompanyEntity companyEntity) {
        this.companyEntity = companyEntity;
    }
}