package com.turing.information.entity;

public class KcglCangku {
    private String ckId;

    private String ppId;

    private String deptId;

    private String ckNo;

    private String ckName;

    private String ckAdds;
    private String ppName;
    private String deptName;

    public String getCkId() {
        return ckId;
    }

    public void setCkId(String ckId) {
        this.ckId = ckId == null ? null : ckId.trim();
    }

    public String getPpId() {
        return ppId;
    }

    public void setPpId(String ppId) {
        this.ppId = ppId == null ? null : ppId.trim();
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId == null ? null : deptId.trim();
    }

    public String getCkNo() {
        return ckNo;
    }

    public void setCkNo(String ckNo) {
        this.ckNo = ckNo == null ? null : ckNo.trim();
    }

    public String getCkName() {
        return ckName;
    }

    public void setCkName(String ckName) {
        this.ckName = ckName == null ? null : ckName.trim();
    }

    public String getCkAdds() {
        return ckAdds;
    }

    public void setCkAdds(String ckAdds) {
        this.ckAdds = ckAdds == null ? null : ckAdds.trim();
    }

	public String getPpName() {
		return ppName;
	}

	public void setPpName(String ppName) {
		this.ppName = ppName;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
}