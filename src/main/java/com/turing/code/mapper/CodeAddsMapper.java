package com.turing.code.mapper;

import java.util.List;

import com.turing.code.entity.CodeAdds;

public interface CodeAddsMapper {
    int deleteByPrimaryKey(String caId);

    int insert(CodeAdds record);

    int insertSelective(CodeAdds record);

    CodeAdds selectByPrimaryKey(String caId);

    int updateByPrimaryKeySelective(CodeAdds record);

    int updateByPrimaryKey(CodeAdds record);

	List<CodeAdds> queryAll();

	List<CodeAdds> queryByParentId(String id);
}