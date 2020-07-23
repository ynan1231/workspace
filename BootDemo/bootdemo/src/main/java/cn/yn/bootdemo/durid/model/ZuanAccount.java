package cn.yn.bootdemo.durid.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * zuan_account
 * @author 
 */
@Data
public class ZuanAccount implements Serializable {
    /**
     * 用户ID,用户天涯数字ID，唯一，不为null
     */
    private Long userId;

    /**
     * 用户名,用户天涯名
     */
    private String userName;

    /**
     * 账户余额,天涯贝余额
     */
    private BigDecimal balance;

    /**
     * 锁定钻数
     */
    private BigDecimal freezeBalance;

    /**
     * 账户状态
     */
    private Byte status;

    /**
     * 用户类型;0:普通用户;1超级节点;2:关键节点
     */
    private Byte userType;

    /**
     * 中间账户创建IP
     */
    private String createIp;

    /**
     * 最近操作IP地址
     */
    private String recentIpAddr;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 最近修改时间，同时也兼作CAS修改余额字段的版本号
     */
    private Date gmtModified;

    private static final long serialVersionUID = 1L;
}