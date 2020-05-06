package mybatis.entry.to.mastery.chapter10.mapper;

import mybatis.entry.to.mastery.chapter10.model.Country;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CountryMapper {

    List<Country> selectAll();
}
