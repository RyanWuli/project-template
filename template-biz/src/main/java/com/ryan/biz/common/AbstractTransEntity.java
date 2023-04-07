package com.ryan.biz.common;

import java.io.Serializable;
import java.util.Date;

/**
 * Create by Ryan on 2023/4/3 22:41
 * Version 1.0
 * Description 实体基类
 */
public class AbstractTransEntity implements Serializable {

    private static final long serialVersionUID = -3808530589583061971L;

    private Long id;
    private String createUser;
    private Date createDate;
    private String modifyUser;
    private Date modifyDate;
}
