package marcsEisdiele.client;

import marcsEisdiele.server.PersistenceManager;
import marcsEisdiele.shared.Unternehmen;

import com.gargoylesoftware.htmlunit.javascript.host.Text;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.Slider;
import com.sencha.gxt.widget.core.client.TabItemConfig;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.menu.Menu;
import com.sencha.gxt.widget.core.client.menu.MenuBar;
import com.sencha.gxt.widget.core.client.menu.MenuBarItem;
import com.sencha.gxt.widget.core.client.menu.MenuItem;




public class start extends Composite implements EntryPoint, HasText {

	private static startUiBinder uiBinder = GWT.create(startUiBinder.class);

	interface startUiBinder extends UiBinder<Widget, start> {
	}

	public start() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	Unternehmen eigenesUN;
	Runde runde[];
	Auswertung auswertung[];
	int personal;
	int quality;
	int kapital;
	int capaticity;
	private UnternehmensServiceAsync service;

	@UiField TextBox tNameUN;
	@UiField TextBox currentPersonal;
	@UiField TextBox currentProdQuality;
	@UiField TextBox currentKapital;
	@UiField TextBox currentCapaticity;
	@UiField Slider sPersonal;
	@UiField Slider sKapital;
	@UiField Slider sQualitaet;	
	@UiField Slider sKapazitaet;	
	@UiField Button bWeiter;

	public start(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
		bWeiter.setText(firstName);
	}

	@UiHandler("bWeiter")
	void onClickWeiter(ClickEvent e) {
//		String name = tNameUN.getText();
//		Window.alert("Variablen" + name + personal);
//		eigenesUN = new Unternehmen(tNameUN.getText(), personal, kapital, quality, capaticity);
		
		//Beispielhafte implementierung der Datenbank. der eingetragenen Name wird einfach gespeichert
		Unternehmen u = new Unternehmen(tNameUN.getText());
		service.addUnternehmen(u, new AddUnternehmenCallback());

	}

	public void setText(String text) {
		bWeiter.setText(text);
	}

	public String getText() {
		return bWeiter.getText();
	}

	@Override
	public void onModuleLoad() {
		
		//Instanziieren des Services
		service = GWT.create(UnternehmensService.class);
		
		//MENUBAR
		
		MenuBar bar = new MenuBar();

	    Menu menu = new Menu();
	    menu.add(new MenuItem("Schnelles Spiel"));

	    MenuBarItem item = new MenuBarItem("Neues Spiel starten", menu);
	    bar.add(item);

	    menu = new Menu();
	    menu.add(new MenuItem("Spiel 1"));
	    menu.add(new MenuItem("Spiel 2"));

	    item = new MenuBarItem("Spiel laden", menu);
	    bar.add(item);
	    
	    menu = new Menu();

	    item = new MenuBarItem("Optionen", menu);
	    menu.add(new MenuItem("Spieleinstellungen"));
	    bar.add(item);

	    RootPanel.get().add(bar);
	    
	    //TABPANEL
	    
	    final TabPanel panel = new TabPanel();
	    panel.setTabScroll(true);
	    panel.setWidth("100%");
	    panel.setResizeTabs(true);
	    
	    
	    runde = new Runde[8];
	    auswertung = new Auswertung[8];
	    for (int i = 1; i < 8; i++) {
	    	if(i!=1){
	    		runde[i] = new Runde();
	    		auswertung[i] = new Auswertung();
	    		panel.add(runde[i].getRunde(), new TabItemConfig("Runde " + i) );
	    		panel.add(auswertung[i].getAuswertung(), new TabItemConfig("Auswertung " + i) );
	    	}
	    	else{
	        sPersonal.setMinValue(100);
			sPersonal.setMaxValue(1000);
			sPersonal.setIncrement(100);
			sPersonal.addValueChangeHandler(new ValueChangeHandler<Integer>() {
				public void onValueChange(ValueChangeEvent<Integer> event) {
					personal = event.getValue(); 
					currentPersonal.setText("" + personal);
				}
			});
			
			
			sQualitaet.setMinValue(100);
			sQualitaet.setMaxValue(1000);
			sQualitaet.setIncrement(100);	
			sQualitaet.addValueChangeHandler(new ValueChangeHandler<Integer>() {
				public void onValueChange(ValueChangeEvent<Integer> event) {
					quality = event.getValue(); 
					currentProdQuality.setText("" + quality);
				}
			});
			
			sKapazitaet.setMinValue(100);
			sKapazitaet.setMaxValue(1000);
			sKapazitaet.setIncrement(100);
			sKapazitaet.addValueChangeHandler(new ValueChangeHandler<Integer>() {
				public void onValueChange(ValueChangeEvent<Integer> event) {
					capaticity = event.getValue(); 
					currentCapaticity.setText("" + capaticity);
				}
			});
			
			sKapital.setMinValue(100);
			sKapital.setMaxValue(1000);
			sKapital.setIncrement(100);
			sKapital.addValueChangeHandler(new ValueChangeHandler<Integer>() {
				public void onValueChange(ValueChangeEvent<Integer> event) {
					kapital = event.getValue(); 
					currentKapital.setText("" + kapital);
				}
			});
						
			bWeiter.setText("weiter");
//			currentPersonal.setText("100");
			panel.add(this, new TabItemConfig("Unternehmen definieren"));
	    	}
	    }

	    //config.setClosable(true);
	    //panel.add(new Label("2"), config);

	    panel.setActiveWidget(panel.getWidget(0));
	 
	    
	    panel.getWidget(1);
   		panel.addSelectionHandler(new SelectionHandler<Widget>() {
            public void onSelection(SelectionEvent<Widget> event) {
                    Widget item = event.getSelectedItem();
                    TabItemConfig config = panel.getConfig(item);
//                    String name = config.getText();
//                    
            }
		
   		});
	    RootPanel.get().add(panel);
		
	}
	//Callbacks für die Async Services
	public class AddUnternehmenCallback implements AsyncCallback<java.lang.Void> {

        @Override
        public void onFailure(Throwable caught) {
        	System.out.println("fail");
        }

        @Override
        public void onSuccess(Void result) {
        	System.out.println("success");
        }
    }

	
}

