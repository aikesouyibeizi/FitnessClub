package com.briup.sports.bean;

import java.util.Date;

public class SysLog {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_log.log_id
     *
     * @mbg.generated Tue May 05 23:52:37 CST 2020
     */
    private Integer logId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_log.log_op
     *
     * @mbg.generated Tue May 05 23:52:37 CST 2020
     */
    private String logOp;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_log.log_event
     *
     * @mbg.generated Tue May 05 23:52:37 CST 2020
     */
    private String logEvent;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_log.log_date
     *
     * @mbg.generated Tue May 05 23:52:37 CST 2020
     */
    private Date logDate;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_log.log_id
     *
     * @return the value of sys_log.log_id
     *
     * @mbg.generated Tue May 05 23:52:37 CST 2020
     */
    public Integer getLogId() {
        return logId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_log.log_id
     *
     * @param logId the value for sys_log.log_id
     *
     * @mbg.generated Tue May 05 23:52:37 CST 2020
     */
    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_log.log_op
     *
     * @return the value of sys_log.log_op
     *
     * @mbg.generated Tue May 05 23:52:37 CST 2020
     */
    public String getLogOp() {
        return logOp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_log.log_op
     *
     * @param logOp the value for sys_log.log_op
     *
     * @mbg.generated Tue May 05 23:52:37 CST 2020
     */
    public void setLogOp(String logOp) {
        this.logOp = logOp == null ? null : logOp.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_log.log_event
     *
     * @return the value of sys_log.log_event
     *
     * @mbg.generated Tue May 05 23:52:37 CST 2020
     */
    public String getLogEvent() {
        return logEvent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_log.log_event
     *
     * @param logEvent the value for sys_log.log_event
     *
     * @mbg.generated Tue May 05 23:52:37 CST 2020
     */
    public void setLogEvent(String logEvent) {
        this.logEvent = logEvent == null ? null : logEvent.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_log.log_date
     *
     * @return the value of sys_log.log_date
     *
     * @mbg.generated Tue May 05 23:52:37 CST 2020
     */
    public Date getLogDate() {
        return logDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_log.log_date
     *
     * @param logDate the value for sys_log.log_date
     *
     * @mbg.generated Tue May 05 23:52:37 CST 2020
     */
    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }
}