package com.whatsappapi.api.model;
import javax.persistence.*;


@Entity
public class Attachment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private message message;
    
    private String url;
    
    public Attachment(long id,message message,String url){
        this.id=id;
        this.message=message;
        this.url=url;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setMessage(message message) {
        this.message = message;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public Long getId() {
        return id;
    }
    public message getMessage() {
        return message;
    }
    public String getUrl() {
        return url;
    }
}

