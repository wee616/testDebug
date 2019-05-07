package clone.cloneTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuyc
 * @version 0.0.1
 * @date 2019/3/19
 */
public class NewTree extends Property {

    private int orgId;

    private String orgName;

    private String orgCode;

    private List<NewTree> children = new ArrayList<>();

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

    public List<NewTree> getChildren() {
        return children;
    }

    public void setChildren(List<NewTree> children) {
        this.children = children;
    }
}