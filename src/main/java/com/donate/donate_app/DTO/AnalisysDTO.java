package com.donate.donate_app.DTO;


public class AnalisysDTO {

    private Long id;
    private Long crowdfunding_id;
    private Long user_id;
    private String refuse_motive;
    private String status;

    public AnalisysDTO() {}

    public AnalisysDTO(Long id, Long crowdfunding_id, Long user_id, String refuse_motive, String status) {
        this.id = id;
        this.crowdfunding_id = crowdfunding_id;
        this.user_id = user_id;
        this.refuse_motive = refuse_motive;
        this.status = status;
    }

    public AnalisysDTO(Long crowdfunding_id, Long user_id, String refuse_motive, String status) {
        this.crowdfunding_id = crowdfunding_id;
        this.user_id = user_id;
        this.refuse_motive = refuse_motive;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCrowdfunding_id() {
        return crowdfunding_id;
    }

    public void setCrowdfunding_id(Long crowdfunding_id) {
        this.crowdfunding_id = crowdfunding_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getRefuse_motive() {
        return refuse_motive;
    }

    public void setRefuse_motive(String refuse_motive) {
        this.refuse_motive = refuse_motive;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
