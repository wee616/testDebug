package clone.cloneTree;

import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author wuyc
 * @version 0.0.1
 * @date 2019/3/19
 */
public class Test {

    public static void main(String[] args){

        NewTree newTree = init();

        OldTree oldTree = transfer(newTree);

        System.out.println(oldTree);
    }

    public static NewTree init(){
        NewTree newTree = new NewTree();
        newTree.setOrgName("11");
        newTree.setOrgId(1);
        newTree.setOrgCode("111");
        Map<String,String> property = new HashMap<>();
        property.put("parentOrgCode","000");
        newTree.setProperty(property);
        NewTree child = new NewTree();
        child.setOrgName("22");
        child.setOrgId(2);
        child.setOrgCode("222");
        Map<String,String> propertyChild = new HashMap<>();
        propertyChild.put("parentOrgCode",newTree.getOrgCode());
        child.setProperty(propertyChild);
        newTree.setChildren(Arrays.asList(child));
        NewTree child2 = new NewTree();
        child2.setOrgName("33");
        child2.setOrgId(3);
        child2.setOrgCode("333");
        Map<String,String> propertyChild2 = new HashMap<>();
        propertyChild2.put("parentOrgCode",child.getOrgCode());
        child2.setProperty(propertyChild2);
        child.setChildren(Arrays.asList(child2));

        return newTree;
    }

    public static OldTree transfer(NewTree newTree){
        OldTree result = new OldTree();
        if(!CollectionUtils.isEmpty(newTree.getChildren())){
            List<OldTree> oldTrees = new LinkedList<>();
            newTree.getChildren().forEach(treeNew ->{
                OldTree oldTree = transfer(treeNew);
                oldTrees.add(oldTree);
            });
            result.setChildren(oldTrees);
        }
        result.setOrgId(newTree.getOrgId());
        result.setOrgName(newTree.getOrgName());
        result.setOrgCode(newTree.getOrgCode());
        result.setParentOrgCode(newTree.getProperty().get("parentOrgCode"));

        return result;
    }
}