package com.hl.domain;

import com.hl.utils.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 产品实体类
 * @author hl2333
 */
public class Product {
    /**
    * 主键
    * */
    private String id;
    /**
     * 产品编号，唯一
     * */
    private String productNum;
    /***
     * 产品名称
     */
    private String productName;
    /***
     * 出发城市
     */
    private String cityName;
    /***
     * 出发时间
     */
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date departureTime;
    private String departureTimeStr;
    /***
     * 产品价格
     */
    private Double productPrice;
    /***
     * 产品描述
     */
    private String productDesc;
    /***
     * 订单状态
     * 0表示关闭
     * 1表示开启
     */
    private Integer productStatus;
    private String productStatusStr;

    private static final String OPEN = "开启";
    private static final String CLOSE = "关闭";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public String getDepartureTimeStr() {
        if (departureTime != null){
            departureTimeStr = DateUtils.dateToString(departureTime, "yyyy-MM-dd HH:mm:ss");
        }
        return departureTimeStr;
    }

    public void setDepartureTimeStr(String departureTimeStr) {
        this.departureTimeStr = departureTimeStr;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    public String getProductStatusStr() {
        if (productStatus == 0){
            productStatusStr = CLOSE;
        }
        else if (productStatus == 1){
            productStatusStr = OPEN;
        }
        return productStatusStr;
    }

    public void setProductStatusStr(String productStatusStr) {
        this.productStatusStr = productStatusStr;
    }
}
