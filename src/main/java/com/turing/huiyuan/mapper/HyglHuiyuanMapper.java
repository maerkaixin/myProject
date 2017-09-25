package com.turing.huiyuan.mapper;

import java.util.List;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.turing.huiyuan.entity.HyglHuiyuan;

public interface HyglHuiyuanMapper {
    int deleteByPrimaryKey(String hyId);

    int insert(HyglHuiyuan record);

    int insertSelective(HyglHuiyuan record);

    HyglHuiyuan selectByPrimaryKey(String hyId);

    int updateByPrimaryKeySelective(HyglHuiyuan record);

    int updateByPrimaryKey(HyglHuiyuan record);
    
    @Select("select hy_id, h.crf_id, hy_name, hy_no, hy_age, hy_sex, hy_birth, hy_gongzhuodanwei, hy_shenfenzheng, hy_zhiye, hy_xuexing, "
    		+ " hy_shengao, hy_tizhong, hy_youbian, hy_email, hy_hunyinqingkuang, hy_in_date, hy_out_date, hy_phone, hy_info, "
    		+ "hy_pic,c.crf_name from hygl_huiyuan h left join code_ruhuifangshi c on h.crf_id = c.crf_id ")
    @ResultMap("BaseResultMap")
    List<HyglHuiyuan>  queryAll();
}