package cn.smilex.dao;

import cn.smilex.entity.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author smilex
 * @date 2022/11/11/21:28
 * @since 1.0
 */
@Mapper
public interface StudentDao extends BaseMapper<Student> {
}
