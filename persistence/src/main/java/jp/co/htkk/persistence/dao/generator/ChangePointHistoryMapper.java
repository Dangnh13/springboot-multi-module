package jp.co.htkk.persistence.dao.generator;

import java.util.List;
import jp.co.htkk.entity.generator.ChangePointHistory;
import jp.co.htkk.entity.generator.ChangePointHistoryCriteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

@Mapper
public interface ChangePointHistoryMapper {
    long countByExample(ChangePointHistoryCriteria example);

    int deleteByExample(ChangePointHistoryCriteria example);

    int deleteByPrimaryKey(Long changePointHistoryId);

    int insert(ChangePointHistory record);

    int insertSelective(ChangePointHistory record);

    List<ChangePointHistory> selectByExampleWithRowbounds(ChangePointHistoryCriteria example, RowBounds rowBounds);

    ChangePointHistory selectOneByExample(ChangePointHistoryCriteria example);

    List<ChangePointHistory> selectByExample(ChangePointHistoryCriteria example);

    ChangePointHistory selectByPrimaryKey(Long changePointHistoryId);

    int updateByExampleSelective(@Param("record") ChangePointHistory record, @Param("example") ChangePointHistoryCriteria example);

    int updateByExample(@Param("record") ChangePointHistory record, @Param("example") ChangePointHistoryCriteria example);

    int updateByPrimaryKeySelective(ChangePointHistory record);

    int updateByPrimaryKey(ChangePointHistory record);

    int batchInsert(@Param("list") List<ChangePointHistory> list);

    int batchInsertSelective(@Param("list") List<ChangePointHistory> list, @Param("selective") ChangePointHistory.Column ... selective);

    int upsert(ChangePointHistory record);

    int upsertSelective(ChangePointHistory record);
}