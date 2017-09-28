package com.turing.code.service;

import java.util.List;

import com.turing.code.entity.CodeAdds;

public interface IAddsService {
	public List<CodeAdds> queryShengList();

	public List<CodeAdds> queryByParentId(String id);
}
