package marcsEisdiele.client;

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
	@UiField Button bMaschine;
	@UiField Button bKonkurrenz;
	@UiField Button bstarten;
	@UiField Slider sAuslastung;
	@UiField Slider sPreis;
	

	ContentPanel panel = new ContentPanel();
	Popup pPersonal = new Popup();
	VerticalPanel vPanel = new VerticalPanel();
	HorizontalPanel hPanel = new HorizontalPanel();

	public Runde(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
		bPersonal.setText(firstName);
	}

	@UiHandler("bPersonal")
	void onClickPersonal(ClickEvent e) {			
		pPersonal.clear();
//		pPersonal.setAutoHide(true);
		pPersonal.setBorders(isVisible());
		pPersonal.setStyleName("popup");
		vPanel.add(new Label("Personal einstellen"));
		hPanel.add(new Label("Personal alt"));
		TextBox tb = new TextBox();
		tb.setText("500");
		hPanel.add(tb);
		vPanel.add(hPanel);
		pPersonal.add(vPanel);
		pPersonal.showAt(100,100);
	}

	public void setText(String text) {
		bPersonal.setText(text);
	}

	public String getText() {
		return bPersonal.getText();
	}
	
	public Widget getRunde(){
		setText("Personal einstellen/ entlassen");
		bMarketing.setText("in Marketing investieren");
		bForschung.setText("in Forschung investieren");
		bMaschine.setText("Maschine hinzufuegen");
		bKonkurrenz.setText("Konkurrenzverhalten bearbeiten");
		bstarten.setText("Runde starten");
		return this;
		
	}

}
