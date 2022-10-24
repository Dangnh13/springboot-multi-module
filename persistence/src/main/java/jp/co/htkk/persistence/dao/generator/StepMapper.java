package jp.co.htkk.persistence.dao.generator;

import java.util.List;
import jp.co.htkk.entity.generator.Step;
import jp.co.htkk.entity.generator.StepCriteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

@Mapper
public interface StepMapper {
    long countByExample(StepCriteria example);

    int deleteByExample(StepCriteria example);

    int deleteByPrimaryKey(Long stepId);

    int insert(Step record);

    int insertSelective(Step record);

    List<Step> selectByExampleWithRowbounds(StepCriteria example, RowBounds rowBounds);

    Step selectOneByExample(StepCriteria example);

    List<Step> selectByExample(StepCriteria example);

    Step selectByPrimaryKey(Long stepId);

    int updateByExampleSelective(@Param("record") Step record, @Param("example") StepCriteria example);

    int updateByExample(@Param("record") Step record, @Param("example") StepCriteria example);

    int updateByPrimaryKeySelective(Step record);

    int updateByPrimaryKey(Step record);

    int batchInsert(@Param("list") List<Step> list);

    int batchInsertSelective(@Param("list") List<Step> list, @Param("selective") Step.Column ... selective);

    int upsert(Step record);

    int upsertSelective(Step record);
}