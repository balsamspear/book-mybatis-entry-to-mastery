package mybatis.entry.to.mastery.chapter08.mapper;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    List<Map<String, Object>> selectById(Long id);
}
