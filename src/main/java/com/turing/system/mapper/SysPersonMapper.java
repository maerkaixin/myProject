package com.turing.system.mapper;

import java.util.List;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.turing.system.entity.SysPerson;
import com.turing.system.page.PersonPage;
import com.turing.system.page.RolePage;

public interface SysPersonMapper {
    int deleteByPrimaryKey(String ppId);

    int insert(SysPerson record);

    int insertSelective(SysPerson record);

    SysPerson selectByPrimaryKey(String ppId);

    int updateByPrimaryKeySelective(SysPerson record);

    int updateByPrimaryKeyWithBLOBs(SysPerson record);

    int updateByPrimaryKey(SysPerson record);
    
    /**
     * 对人员进行条件查询
     * @param pp
     * @return
     */
	List<SysPerson> selective(SysPerson pp);
	
	@SelectProvider(method="pageSql",type=PersonPage.class)
	@ResultMap("BaseResultMap")
	List<SysPerson> query(PersonPage page);

	@SelectProvider(method="allSql" ,type=PersonPage.class)
	@ResultMap("BaseResultMap")
	List<SysPerson> queryAll(PersonPage page);
	/**
	 * 查询人员的信息，包括用户名，职务名及部门名
	 * @param ppId
	 * @return
	 */
	SysPerson queryAllInfoById(String ppId);
	/**
	 * 根据人员主键取消关联的用户
	 * @param ppId
	 */
	void updateUserIdToNull(String ppId);
	
	List<SysPerson> queryPersonList();
	@Select("select pp_id, pp_no, pp_minzu, pp_info, pp_in_time, pp_pay, pp_state,"
			+ " pp_name, pp_birth, pp_sex, pp_adds, pp_phone, pp_shenfenzheng, sp_id,"
			+ " user_id, dept_id, pp_pic from sys_person where dept_id = #{deptId}")
	@ResultMap("BaseResultMap")
	List<SysPerson> queryPersonByDeptId(String deptId);
}