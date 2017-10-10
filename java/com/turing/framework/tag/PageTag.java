package com.turing.framework.tag;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import com.github.pagehelper.PageInfo;


/**
 *@author 赵刚
 *@date 2016-10-31下午3:30:22
 *
 **/
@SuppressWarnings("serial")
public class PageTag extends TagSupport {
	/**
	 * 控制器传给页面的分页对象名
	 */
	private String pageName;
	/**
	 * 查询分页数据的请求路径
	 */
	private String uri;
	/**
	 * 条件查询的表单名
	 */
	private String formName;

	@Override
	public int doStartTag() throws JspException {
		//获取web资源
		HttpServletRequest request = (HttpServletRequest)super.pageContext.getRequest();
		JspWriter out = super.pageContext.getOut();
		//得到分页对象
		PageInfo pageInfo = (PageInfo)request.getAttribute(pageName);
		//获取分页属性
		int pageNum = pageInfo.getPageNum();
		int pages = pageInfo.getPages();
		long total = pageInfo.getTotal();
		boolean hasPreviousPage = pageInfo.isHasPreviousPage();
		int[] navigatepageNums = pageInfo.getNavigatepageNums();
		boolean hasNextPage = pageInfo.isHasNextPage();
		
		int prePage = pageInfo.getPrePage();
		int nextPage = pageInfo.getNextPage();
		
		//获取项目名
		String path = request.getContextPath();
		//判断uri的前面有没有"/"，如果没有则加一个"/"
		if(uri.substring(0, 1).equals("/") == false  ){
			uri = "/"+uri;
		}
		//封装页面标签
		StringBuffer strbuf=new StringBuffer();
		
		strbuf.append("");
		strbuf.append("<div class=\"container text-center\" style=\"margin-top:-20px;font-size: 18px;\">");
		strbuf.append("<a href=\"javascript:pagego('1')\">首页</a>");
	 	
	 	if (hasPreviousPage) {
			strbuf.append("	<a href=\"javascript:pagego('"+prePage+"')\">上一页</a>");
	 	}
	 	for (int i = 1; i <= navigatepageNums.length; i++) {
			if (navigatepageNums[i-1] == pageNum) {
				strbuf.append("	&nbsp;&nbsp;<font style=\"font-size: 30px\">"+navigatepageNums[i-1]+"</font>&nbsp;&nbsp;");
			}else{
				strbuf.append("	<a href=\"javascript:pagego('"+navigatepageNums[i-1]+"')\">"+navigatepageNums[i-1]+"</a>");
			}
		}
	 	if (hasNextPage) {
	 		strbuf.append("	<a href=\"javascript:pagego('"+nextPage+"')\">下一页</a>");
		}
	 	
	 	strbuf.append("pages "+pageNum+"/"+pages+" ");
	 	strbuf.append("rows: "+total+"");
	 	strbuf.append("</div>");
	 	strbuf.append("<script type=\"text/javascript\">");
	 	strbuf.append("var formform="+formName+";");
	 	strbuf.append("function pagego(n){");
	 	strbuf.append("	if(formform == null){");
	 	strbuf.append("		location.href = \""+path+""+uri+"?pageNum=\"+n;");
	 	strbuf.append("	}else{");
	 	strbuf.append("		$(\"form[name='"+formName+"']\").attr(\"action\",\""+path+""+uri+"?pageNum=\"+n);");
	 	strbuf.append("		$(\"form[name='"+formName+"']\").submit();");
	 	strbuf.append("	}");
	 	strbuf.append("}");
	 	strbuf.append("</script>");
		try {
			out.print(strbuf);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return super.doStartTag();
	}

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getFormName() {
		return formName;
	}

	public void setFormName(String formName) {
		this.formName = formName;
	}
}
