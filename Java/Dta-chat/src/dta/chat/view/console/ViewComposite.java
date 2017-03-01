package dta.chat.view.console;

import java.util.ArrayList;
import java.util.List;

import dta.chat.controller.ChatAuthController;

public abstract class ViewComposite {
	protected List<ViewComposite> views = new ArrayList<>();
	protected String id;
	protected ChatAuthController authController;

	public void add(ViewComposite vc) {
		views.add(vc);
	}

	public void print() {
		for (ViewComposite view : views) {
			view.print();
		}
	}

	public void setLogin(String id) {
		this.id = id;
		this.views.forEach(view -> view.setLogin(id));

	}

	public void setAuthController(ChatAuthController authController) {
		this.authController = authController;
		this.views.forEach(view -> view.setAuthController(authController));
	}
}
