package com.briup.sports.bean;

import java.util.Date;

public class Order {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_order.order_id
     *
     * @mbg.generated Tue May 05 23:52:37 CST 2020
     */
    private Integer orderId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_order.order_date
     *
     * @mbg.generated Tue May 05 23:52:37 CST 2020
     */
    private Date orderDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_order.member_id
     *
     * @mbg.generated Tue May 05 23:52:37 CST 2020
     */
    private Integer memberId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_order.order_member_name
     *
     * @mbg.generated Tue May 05 23:52:37 CST 2020
     */
    private String orderMemberName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_order.order_status
     *
     * @mbg.generated Tue May 05 23:52:37 CST 2020
     */
    private Integer orderStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_order.course_id
     *
     * @mbg.generated Tue May 05 23:52:37 CST 2020
     */
    private Integer courseId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_order.addr_id
     *
     * @mbg.generated Tue May 05 23:52:37 CST 2020
     */
    private Integer addrId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_order.course_name
     *
     * @mbg.generated Tue May 05 23:52:37 CST 2020
     */
    private String courseName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_order.course_img
     *
     * @mbg.generated Tue May 05 23:52:37 CST 2020
     */
    private String courseImg;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_order.order_id
     *
     * @return the value of sys_order.order_id
     *
     * @mbg.generated Tue May 05 23:52:37 CST 2020
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_order.order_id
     *
     * @param orderId the value for sys_order.order_id
     *
     * @mbg.generated Tue May 05 23:52:37 CST 2020
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_order.order_date
     *
     * @return the value of sys_order.order_date
     *
     * @mbg.generated Tue May 05 23:52:37 CST 2020
     */
    public Date getOrderDate() {
        return orderDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_order.order_date
     *
     * @param orderDate the value for sys_order.order_date
     *
     * @mbg.generated Tue May 05 23:52:37 CST 2020
     */
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_order.member_id
     *
     * @return the value of sys_order.member_id
     *
     * @mbg.generated Tue May 05 23:52:37 CST 2020
     */
    public Integer getMemberId() {
        return memberId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_order.member_id
     *
     * @param memberId the value for sys_order.member_id
     *
     * @mbg.generated Tue May 05 23:52:37 CST 2020
     */
    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_order.order_member_name
     *
     * @return the value of sys_order.order_member_name
     *
     * @mbg.generated Tue May 05 23:52:37 CST 2020
     */
    public String getOrderMemberName() {
        return orderMemberName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_order.order_member_name
     *
     * @param orderMemberName the value for sys_order.order_member_name
     *
     * @mbg.generated Tue May 05 23:52:37 CST 2020
     */
    public void setOrderMemberName(String orderMemberName) {
        this.orderMemberName = orderMemberName == null ? null : orderMemberName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_order.order_status
     *
     * @return the value of sys_order.order_status
     *
     * @mbg.generated Tue May 05 23:52:37 CST 2020
     */
    public Integer getOrderStatus() {
        return orderStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_order.order_status
     *
     * @param orderStatus the value for sys_order.order_status
     *
     * @mbg.generated Tue May 05 23:52:37 CST 2020
     */
    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_order.course_id
     *
     * @return the value of sys_order.course_id
     *
     * @mbg.generated Tue May 05 23:52:37 CST 2020
     */
    public Integer getCourseId() {
        return courseId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_order.course_id
     *
     * @param courseId the value for sys_order.course_id
     *
     * @mbg.generated Tue May 05 23:52:37 CST 2020
     */
    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_order.addr_id
     *
     * @return the value of sys_order.addr_id
     *
     * @mbg.generated Tue May 05 23:52:37 CST 2020
     */
    public Integer getAddrId() {
        return addrId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_order.addr_id
     *
     * @param addrId the value for sys_order.addr_id
     *
     * @mbg.generated Tue May 05 23:52:37 CST 2020
     */
    public void setAddrId(Integer addrId) {
        this.addrId = addrId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_order.course_name
     *
     * @return the value of sys_order.course_name
     *
     * @mbg.generated Tue May 05 23:52:37 CST 2020
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_order.course_name
     *
     * @param courseName the value for sys_order.course_name
     *
     * @mbg.generated Tue May 05 23:52:37 CST 2020
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName == null ? null : courseName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_order.course_img
     *
     * @return the value of sys_order.course_img
     *
     * @mbg.generated Tue May 05 23:52:37 CST 2020
     */
    public String getCourseImg() {
        return courseImg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_order.course_img
     *
     * @param courseImg the value for sys_order.course_img
     *
     * @mbg.generated Tue May 05 23:52:37 CST 2020
     */
    public void setCourseImg(String courseImg) {
        this.courseImg = courseImg == null ? null : courseImg.trim();
    }
}