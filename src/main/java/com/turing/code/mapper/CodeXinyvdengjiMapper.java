package com.turing.code.mapper;

import java.util.List;

import com.turing.code.entity.CodeXinyvdengji;
import com.turing.code.page.XydjPage;

public interface CodeXinyvdengjiMapper {
    int deleteByPrimaryKey(String cxyId);

    int insert(CodeXinyvdengji record);

    int insertSelective(CodeXinyvdengji record);

    CodeXinyvdengji selectByPrimaryKey(String cxyId);

    int updateByPrimaryKeySelective(CodeXinyvdengji record);

    int updateByPrimaryKey(CodeXinyvdengji record);
    
	List<CodeXinyvdengji> queryAll();
	//查询分页数据
	List queryForPage(XydjPage page);
	//查询总记录数
	int queryForCount(XydjPage page);
}