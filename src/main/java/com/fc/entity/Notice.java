package com.fc.entity;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import java.util.Date;
@Repository
public class Notice {
    private Integer id;

    private String content;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ndate;
   @DateTimeFormat
    private String title;

    private String uper;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getNdate() {
        return ndate;
    }

    public void setNdate(Date ndate) {
        this.ndate = ndate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getUper() {
        return uper;
    }

    public void setUper(String uper) {
        this.uper = uper == null ? null : uper.trim();
    }
}