/**********************************************************************
 * $Source: /cvsroot/hibiscus/hibiscus/src/de/willuhn/jameica/hbci/gui/views/AuslandsUeberweisungList.java,v $
 * $Revision: 1.3 $
 * $Date: 2009/10/20 23:12:58 $
 * $Author: willuhn $
 * $Locker:  $
 * $State: Exp $
 *
 * Copyright (c) by willuhn.webdesign
 * All rights reserved
 *
 **********************************************************************/
package de.willuhn.jameica.hbci.gui.views;

import de.willuhn.jameica.gui.AbstractView;
import de.willuhn.jameica.gui.GUI;
import de.willuhn.jameica.gui.internal.buttons.Back;
import de.willuhn.jameica.gui.util.ButtonArea;
import de.willuhn.jameica.hbci.HBCI;
import de.willuhn.jameica.hbci.gui.action.AuslandsUeberweisungImport;
import de.willuhn.jameica.hbci.gui.action.AuslandsUeberweisungNew;
import de.willuhn.jameica.hbci.gui.controller.AuslandsUeberweisungControl;
import de.willuhn.jameica.system.Application;
import de.willuhn.logging.Logger;
import de.willuhn.util.I18N;

/**
 * Zeigt eine Liste mit den vorhandenen Auslandsueberweisungen an.
 */
public class AuslandsUeberweisungList extends AbstractView {

  /**
   * @see de.willuhn.jameica.gui.AbstractView#bind()
   */
  public void bind() throws Exception {

		I18N i18n = Application.getPluginLoader().getPlugin(HBCI.class).getResources().getI18N();

		GUI.getView().setTitle(i18n.tr("Vorhandene SEPA-�berweisungen"));
		
		final AuslandsUeberweisungControl control = new AuslandsUeberweisungControl(this);
		
		try {

			control.getAuslandsUeberweisungListe().paint(getParent());

			ButtonArea buttons = new ButtonArea(getParent(),3);
	    buttons.addButton(new Back(false));
      buttons.addButton(i18n.tr("Importieren..."),new AuslandsUeberweisungImport(),null,false,"document-open.png");
			buttons.addButton(i18n.tr("Neue SEPA-�berweisung"), new AuslandsUeberweisungNew(),null,true,"text-x-generic.png");

		}
		catch (Exception e)
		{
			Logger.error("error while loading transfer list",e);
			GUI.getStatusBar().setErrorText(i18n.tr("Fehler beim Lesen der Auftr�ge."));
		}
  }
}


/**********************************************************************
 * $Log: AuslandsUeberweisungList.java,v $
 * Revision 1.3  2009/10/20 23:12:58  willuhn
 * @N Support fuer SEPA-Ueberweisungen
 * @N Konten um IBAN und BIC erweitert
 *
 * Revision 1.2  2009/05/06 23:11:23  willuhn
 * @N Mehr Icons auf Buttons
 *
 * Revision 1.1  2009/03/13 00:25:12  willuhn
 * @N Code fuer Auslandsueberweisungen fast fertig
 *
 **********************************************************************/