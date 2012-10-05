package unternehmensplanspiel.shared;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.ContentPanel;

public class Runde extends Composite implements  HasText {

	private static RundeUiBinder uiBinder = GWT.create(RundeUiBinder.class);

	interface RundeUiBinder extends UiBinder<Widget, Runde> {
	}

	public Runde() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField Button bPersonal;
	@UiField Button bForschung;
	@UiField Button bMarketing;

	ContentPanel panel = new ContentPanel();

	public Runde(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
		bPersonal.setText(firstName);
	}

	@UiHandler("bPersonal")
	void onClick(ClickEvent e) {
		Window.alert("Hello!");
	}

	public void setText(String text) {
		bPersonal.setText(text);
	}

	public String getText() {
		return bPersonal.getText();
	}
	
	public Widget getRunde(){
		setText("Personal einstellen/ entlassen");
		panel.add(this);
		return panel;
		
	}

//	@Override
//	public void onModuleLoad() {
//		// TODO Auto-generated method stub
//	}

}
