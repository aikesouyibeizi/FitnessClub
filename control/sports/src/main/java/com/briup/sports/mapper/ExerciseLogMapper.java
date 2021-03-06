package com.briup.sports.mapper;

import com.briup.sports.bean.ExerciseLog;
import com.briup.sports.bean.ExerciseLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExerciseLogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table exercise_log
     *
     * @mbg.generated Tue May 05 23:52:37 CST 2020
     */
    long countByExample(ExerciseLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table exercise_log
     *
     * @mbg.generated Tue May 05 23:52:37 CST 2020
     */
    int deleteByExample(ExerciseLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table exercise_log
     *
     * @mbg.generated Tue May 05 23:52:37 CST 2020
     */
    int deleteByPrimaryKey(Integer logId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table exercise_log
     *
     * @mbg.generated Tue May 05 23:52:37 CST 2020
     */
    int insert(ExerciseLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table exercise_log
     *
     * @mbg.generated Tue May 05 23:52:37 CST 2020
     */
    int insertSelective(ExerciseLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table exercise_log
     *
     * @mbg.generated Tue May 05 23:52:37 CST 2020
     */
    List<ExerciseLog> selectByExample(ExerciseLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table exercise_log
     *
     * @mbg.generated Tue May 05 23:52:37 CST 2020
     */
    ExerciseLog selectByPrimaryKey(Integer logId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table exercise_log
     *
     * @mbg.generated Tue May 05 23:52:37 CST 2020
     */
    int updateByExampleSelective(@Param("record") ExerciseLog record, @Param("example") ExerciseLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table exercise_log
     *
     * @mbg.generated Tue May 05 23:52:37 CST 2020
     */
    int updateByExample(@Param("record") ExerciseLog record, @Param("example") ExerciseLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table exercise_log
     *
     * @mbg.generated Tue May 05 23:52:37 CST 2020
     */
    int updateByPrimaryKeySelective(ExerciseLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table exercise_log
     *
     * @mbg.generated Tue May 05 23:52:37 CST 2020
     */
    int updateByPrimaryKey(ExerciseLog record);
}