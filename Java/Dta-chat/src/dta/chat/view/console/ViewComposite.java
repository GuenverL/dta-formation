package dta.chat.view.console;

import java.util.ArrayList;
import java.util.List;

public abstract class ViewComposite {
	protected List<ViewComposite> views = new ArrayList<>();

	public ViewComposite() {
	}

	public void add(ViewComposite vc) {
		views.add(vc);
	}

	public void print() {
		for (ViewComposite view : views) {
			view.print();
		}
	}
}
