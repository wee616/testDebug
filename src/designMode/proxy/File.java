package designMode.proxy;

public class File implements IFile {

	public File(){
		loadFile();
	}
	
	@Override
	public void showFile() {
		System.out.println("show file");

	} 
	
	private void loadFile(){
		System.out.println("load file");
	}

}
