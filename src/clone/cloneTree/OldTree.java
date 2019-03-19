package clone.cloneTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuyc
 * @version 0.0.1
 * @date 2019/3/19
 */
public class OldTree {
    private int orgId;

    private String orgName;

    private String orgCode;

    private String parentOrgCode;

    private List<OldTree> children = new ArrayList<>();

    public int getOrgId() {
        return orgId;
    }

    public void setOrgId(int orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public List<OldTree> getChildren() {
        return children;
    }

    public void setChildren(List<OldTree> children) {
        this.children = children;
    }

    public String getParentOrgCode() {
        return parentOrgCode;
    }

    public void setParentOrgCode(String parentOrgCode) {
        this.parentOrgCode = parentOrgCode;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"orgId\":")
                .append(orgId);
        sb.append(",\"orgName\":\"")
                .append(orgName).append('\"');
        sb.append(",\"orgCode\":\"")
                .append(orgCode).append('\"');
        sb.append(",\"parentOrgCode\":\"")
                .append(parentOrgCode).append('\"');
        sb.append(",\"children\":")
                .append(children);
        sb.append('}');
        return sb.toString();
    }
}