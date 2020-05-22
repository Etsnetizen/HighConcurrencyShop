package com.imooc.pojo.vo;

import java.util.Date;

/**
 * @FileName ItemCommentVO
 * @Description 商品评价VO
 * @Author jiuhao
 * @Date 2020/5/21 15:33
 * @Modified
 * @Version 1.0
 */
public class ItemCommentVO {

    private Integer commentLevel;

    private String content;

    private String specName;

    private Date createTime;

    private String userFace;

    private String nickName;

    public Integer getCommentLevel() {
        return commentLevel;
    }

    public void setCommentLevel(Integer commentLevel) {
        this.commentLevel = commentLevel;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUserFace() {
        return userFace;
    }

    public void setUserFace(String userFace) {
        this.userFace = userFace;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
