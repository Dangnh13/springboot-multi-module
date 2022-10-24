package jp.co.htkk.persistence.dao.generator;

import java.util.List;
import jp.co.htkk.entity.generator.TransactionPoint;
import jp.co.htkk.entity.generator.TransactionPointCriteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

@Mapper
public interface TransactionPointMapper {
    long countByExample(TransactionPointCriteria example);

    int deleteByExample(TransactionPointCriteria example);

    int deleteByPrimaryKey(Long transactionPointId);

    int insert(TransactionPoint record);

    int insertSelective(TransactionPoint record);

    List<TransactionPoint> selectByExampleWithRowbounds(TransactionPointCriteria example, RowBounds rowBounds);

    TransactionPoint selectOneByExample(TransactionPointCriteria example);

    List<TransactionPoint> selectByExample(TransactionPointCriteria example);

    TransactionPoint selectByPrimaryKey(Long transactionPointId);

    int updateByExampleSelective(@Param("record") TransactionPoint record, @Param("example") TransactionPointCriteria example);

    int updateByExample(@Param("record") TransactionPoint record, @Param("example") TransactionPointCriteria example);

    int updateByPrimaryKeySelective(TransactionPoint record);

    int updateByPrimaryKey(TransactionPoint record);

    int batchInsert(@Param("list") List<TransactionPoint> list);

    int batchInsertSelective(@Param("list") List<TransactionPoint> list, @Param("selective") TransactionPoint.Column ... selective);

    int upsert(TransactionPoint record);

    int upsertSelective(TransactionPoint record);
}