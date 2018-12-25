package com.mainserver.hibernate.tutorial.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "companies")
public class CompanyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "company_name", nullable = false, unique = true)
    private String companyName;

    @Column(name = "short_info")
    private String shortInfo;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @OneToMany(mappedBy = "companyEntity")
    private List<JobAnnouncementEntity> jobAnnouncementEntities;

    public CompanyEntity() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getShortInfo() {
        return shortInfo;
    }

    public void setShortInfo(String shortInfo) {
        this.shortInfo = shortInfo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<JobAnnouncementEntity> getJobAnnouncementEntities() {
        return jobAnnouncementEntities;
    }

    public void setJobAnnouncementEntities(List<JobAnnouncementEntity> jobAnnouncementEntities) {
        this.jobAnnouncementEntities = jobAnnouncementEntities;
    }
}
