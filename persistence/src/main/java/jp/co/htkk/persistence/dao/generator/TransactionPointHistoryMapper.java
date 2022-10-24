package jp.co.htkk.persistence.dao.generator;

import java.util.List;
import jp.co.htkk.entity.generator.TransactionPointHistory;
import jp.co.htkk.entity.generator.TransactionPointHistoryCriteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

@Mapper
public interface TransactionPointHistoryMapper {
    long countByExample(TransactionPointHistoryCriteria example);

    int deleteByExample(TransactionPointHistoryCriteria example);

    int deleteByPrimaryKey(Long transactionPointHistoryId);

    int insert(TransactionPointHistory record);

    int insertSelective(TransactionPointHistory record);

    List<TransactionPointHistory> selectByExampleWithBLOBsWithRowbounds(TransactionPointHistoryCriteria example, RowBounds rowBounds);

    TransactionPointHistory selectOneByExample(TransactionPointHistoryCriteria example);

    TransactionPointHistory selectOneByExampleWithBLOBs(TransactionPointHistoryCriteria example);

    List<TransactionPointHistory> selectByExampleWithBLOBs(TransactionPointHistoryCriteria example);

    List<TransactionPointHistory> selectByExampleWithRowbounds(TransactionPointHistoryCriteria example, RowBounds rowBounds);

    List<TransactionPointHistory> selectByExample(TransactionPointHistoryCriteria example);

    TransactionPointHistory selectByPrimaryKey(Long transactionPointHistoryId);

    int updateByExampleSelective(@Param("record") TransactionPointHistory record, @Param("example") TransactionPointHistoryCriteria example);

    int updateByExampleWithBLOBs(@Param("record") TransactionPointHistory record, @Param("example") TransactionPointHistoryCriteria example);

    int updateByExample(@Param("record") TransactionPointHistory record, @Param("example") TransactionPointHistoryCriteria example);

    int updateByPrimaryKeySelective(TransactionPointHistory record);

    int updateByPrimaryKeyWithBLOBs(TransactionPointHistory record);

    int updateByPrimaryKey(TransactionPointHistory record);

    int batchInsert(@Param("list") List<TransactionPointHistory> list);

    int batchInsertSelective(@Param("list") List<TransactionPointHistory> list, @Param("selective") TransactionPointHistory.Column ... selective);

    int upsert(TransactionPointHistory record);

    int upsertSelective(TransactionPointHistory record);

    int upsertWithBLOBs(TransactionPointHistory record);
}