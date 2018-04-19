package designMode.iterator;

/**
 * 迭代器模式，用内部类实现，提供一种方法遍历聚合对象中的各个元素，而又不暴露对象的内部元素
 * @author 11941
 *
 */
public class NameRepository implements INameContainer {
	
	private String[] names={"first","second","third"};

	@Override
	public Iterator getIterator() {
		return new NameIterator();
	}
	
	private class NameIterator implements Iterator{

		private int index;
		
		@Override
		public Boolean hasNext() {
			if(index < names.length){
				return true;
			}
			return false;
		}

		@Override
		public Object next() {
			if(hasNext()){
				return names[index++];
			}
			return null;
		}
	}

}
