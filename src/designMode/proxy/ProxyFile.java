package designMode.proxy;

public class ProxyFile implements IFile {

	private IFile file;
	@Override
	public void showFile() {
		if(file == null){
			file = new File();
		}
		file.showFile();
	}

}
