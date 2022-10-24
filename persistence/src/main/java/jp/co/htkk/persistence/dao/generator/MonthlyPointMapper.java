package jp.co.htkk.persistence.dao.generator;

import java.util.List;
import jp.co.htkk.entity.generator.MonthlyPoint;
import jp.co.htkk.entity.generator.MonthlyPointCriteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

@Mapper
public interface MonthlyPointMapper {
    long countByExample(MonthlyPointCriteria example);

    int deleteByExample(MonthlyPointCriteria example);

    int deleteByPrimaryKey(Long monthlyPointId);

    int insert(MonthlyPoint record);

    int insertSelective(MonthlyPoint record);

    List<MonthlyPoint> selectByExampleWithRowbounds(MonthlyPointCriteria example, RowBounds rowBounds);

    MonthlyPoint selectOneByExample(MonthlyPointCriteria example);

    List<MonthlyPoint> selectByExample(MonthlyPointCriteria example);

    MonthlyPoint selectByPrimaryKey(Long monthlyPointId);

    int updateByExampleSelective(@Param("record") MonthlyPoint record, @Param("example") MonthlyPointCriteria example);

    int updateByExample(@Param("record") MonthlyPoint record, @Param("example") MonthlyPointCriteria example);

    int updateByPrimaryKeySelective(MonthlyPoint record);

    int updateByPrimaryKey(MonthlyPoint record);

    int batchInsert(@Param("list") List<MonthlyPoint> list);

    int batchInsertSelective(@Param("list") List<MonthlyPoint> list, @Param("selective") MonthlyPoint.Column ... selective);

    int upsert(MonthlyPoint record);

    int upsertSelective(MonthlyPoint record);
}