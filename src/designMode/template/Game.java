package designMode.template;

/**
 * 用抽象类实现模板模式，将模板方法定义为final的，子类不可改写，细节允许改写
 * 
 * @author 11941
 *
 */
public abstract class Game {
	public abstract void init();

	public abstract void start();

	public abstract void end();

	public final void play() {
		init();
		start();
		end();
	}
}
