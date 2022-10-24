package jp.co.htkk.persistence.dao.generator;

import java.util.List;
import jp.co.htkk.entity.generator.DailyPoint;
import jp.co.htkk.entity.generator.DailyPointCriteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

@Mapper
public interface DailyPointMapper {
    long countByExample(DailyPointCriteria example);

    int deleteByExample(DailyPointCriteria example);

    int deleteByPrimaryKey(Long dailyPointId);

    int insert(DailyPoint record);

    int insertSelective(DailyPoint record);

    List<DailyPoint> selectByExampleWithRowbounds(DailyPointCriteria example, RowBounds rowBounds);

    DailyPoint selectOneByExample(DailyPointCriteria example);

    List<DailyPoint> selectByExample(DailyPointCriteria example);

    DailyPoint selectByPrimaryKey(Long dailyPointId);

    int updateByExampleSelective(@Param("record") DailyPoint record, @Param("example") DailyPointCriteria example);

    int updateByExample(@Param("record") DailyPoint record, @Param("example") DailyPointCriteria example);

    int updateByPrimaryKeySelective(DailyPoint record);

    int updateByPrimaryKey(DailyPoint record);

    int batchInsert(@Param("list") List<DailyPoint> list);

    int batchInsertSelective(@Param("list") List<DailyPoint> list, @Param("selective") DailyPoint.Column ... selective);

    int upsert(DailyPoint record);

    int upsertSelective(DailyPoint record);
}