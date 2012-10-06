package marcsEisdiele.client;

import com.gargoylesoftware.htmlunit.javascript.host.Text;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.Popup;
import com.sencha.gxt.widget.core.client.Slider;

public class Auswertung extends Composite implements  HasText {

	private static AuswertungUiBinder uiBinder = GWT.create(AuswertungUiBinder.class);

	interface AuswertungUiBinder extends UiBinder<Widget, Auswertung> {
	} 

	public Auswertung() {
		initWidget(uiBinder.createAndBindUi(this));
	}


	@UiField Button bNeueRunde;
	@UiField TextBox tVerkaufteProdukte;
	@UiField TextBox tMarktanteil;
	@UiField TextBox tPreis;
	ContentPanel panel = new ContentPanel();
	

	public Auswertung(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
		bNeueRunde.setText(firstName);
	}

	@UiHandler("bNeueRunde")
	void onClickPersonal(ClickEvent e) {			

	}

	public void setText(String text) {
		bNeueRunde.setText(text);
	}

	public String getText() {
		return bNeueRunde.getText();
	}
	
	public Widget getAuswertung(){
		setText("neue Runde");
		panel.add(this);
		return panel;
		
	}

}
