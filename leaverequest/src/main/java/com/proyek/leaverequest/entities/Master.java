package com.proyek.leaverequest.entities;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "leavemaster")
public class Master   {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;


    @OneToOne
    @JoinColumn(name="categoryId")

    private Category categoryId;

    private int userId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private  Date endDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date submitDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private  Date approvalDate;
    private  String status;

    public int getId() { return id; }

    public void setId(int id) {
        this.id = id;
    }

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }

    public int getUserId() { return userId;}

    public void setUserId(int userId) {this.userId = userId;}

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
    }

    public Date getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(Date approvalDate) {
        this.approvalDate = approvalDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
