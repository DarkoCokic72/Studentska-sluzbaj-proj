package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class HelpDialog extends JDialog{
	private static HelpDialog instace = null;
	private static JLabel infoLabel;
	private static JTextArea tekst;
	
	public HelpDialog() {
		
		setVisible(true);
		setTitle("Pomoć");
		setSize(600, 500);
		setLocationRelativeTo(MainFrame.getMainFrame());
		setLayout(new BorderLayout());
		ImageIcon img = new ImageIcon("images" + File.separator + "Help-icon.png");
		setIconImage(img.getImage());
		
		infoLabel = new JLabel();
		infoLabel.setText("Dobro došli! U ovom prozoru možete naći sve što je potrebno za rad u ovoj aplikaciji.");
		infoLabel.setBounds(12, 12, 0, 0);
		add(infoLabel, BorderLayout.NORTH);
		
		tekst = new JTextArea();
		tekst.setEditable(false);
		tekst.setSize(540, 450);
		
		
		String description = new String(
				"Pri pokretanju programa otvara se glavni prozor sa informacijama o studentima, profesorima i predmetima.\n"
				+ "Klikom na zaglavlje tabele omogućuje se sortiranje entiteta po toj izabranoj koloni.\n "
				+ "Iz programa je moguće izaći klikom na uobičajeno dugme X u gornjem desnom ćošku, ili koristeći prečicu Ctrl + W, \n"
				+ "i stanje programa se pamti prilikom izlaska. \n"
				+ "Glavni prozor se sastoji iz: \n"
				+ "Meni bara koji sadrži: \n"
				+ "File(Datoteka) \n"
				+ "\t New(Novo) - kreira novi entite(student, predmet, profesor)\n"
				+ "\t Save(Sačuvaj) - Čuva stanje programa\n"
				+ "\t Open(Otvori)\n"
				+ "\t\t Student - pozicionira se na tab Student\n"
				+ "\t\t Subjects(Predmeti) - pozocionira se na tab Predmeti\n"
				+ "\t\t Professors(Profesori) - pozicionira se na tab Profesor\n"
				+ "\t\t Departments(Katedre) - otvara novi prozor Katedre\n"
				+ "\t Close(Zatvori) zatvara program i čuva stanje aplikacije\n"
				+ "Edit(Izmeni) \n"
				+ "\t Edit - vrši izmenu entiteta\n"
				+ "\t Delete(Obriši) - vrši brisanje entiteta\n"
				+ "Help(Pomoć)\n"
				+ "\t English/Serbian - klikom na jedno od ta dva se menja jezik programa\n"
				+ "\t Help - otvara ovaj prozor\n"
				+ "\t About(O aplikaciji) - prikazuje verziju programa i kratku biografiju autora\n"
				+ "Toolbar:\n"
				+ "Na toolbar-u sa leve strane nalaze se dugmad za dodavanje, izmenu i brisanje entiteta,\n"
				+ " a sa desne strane se nalazi polje za pretragu i dugme za istu namenu.\n"
				+ "Centralni panel: služi za prikaz entiteta\n"
				+ "Status bar: prikazuje naziv programa, otvoreni tab, datum i vreme\n"
				+ "Prečice:\n"
				+ "CTRL + N - kreiranje novg entiteta\n"
				+ "CTRL + S - čuvanje stanja programa \n"
				+ "CTRL + 0 - pozicionira se na tab Studenti\n"
				+ "CTRL + 1 - --------------------- Predmet\n"
				+ "CTRL + 2 - --------------------- Profesori\n"
				+ "CTRL + 3 - Otvara prozor sa Katedrama\n"
				+ "CTRL + W - Zatvaranje programa\n"
				+ "CTRL + E - Izmena Entiteta\n"
				+ "Shift + Delete - Brisanje entiteta\n"
				+ "Alt + F1 - otvara Help-prozor\n"
				+ "CTRL + A - otvara About-prozor\n\n"
				+ "Za dodavanje entiteta potrbno je kliknuti na dugme dodaj ili korisiti prečicu. Na taj način se otvara novi prozor u kome je"
				+ " potrebno uneti željene podatke u sva polja(dok se to ne uradi, dugme Dodaj ostaje onemogućeno)\n"
				+ "Za izmenu entiteta potrebno je selektovati željeni entitet i kliknuti dugme Izmeni. \n"
				+ "Prozor za izmenu studenta sadrži tabove Informacije, Položeni i Nepoloženi. Informacije sadrži polja za izmenu podataka o studentu, \n"
				+ "Položeni tabelu položenih ispita i dugme 'Poništi ocenu', Nepoloženi tabelu nepoloženih predmeta i dugmad \n"
				+ "Dodaj(otvara prozor sa spiskom predmeta), Obriši(prvo se selektuje predmet, pa se onda klikne) i Polaganje(selektuje se predmet i klikom se otvara prozor za unos ocene \n"
				+ "nakon čega predmet prelazi u Položene) \n"
				+ "Prozor za izmenu profesora sadrži tab Informacije(slično kao kod studenta) i Predmeti. \n"
				+ "Tab Predmeti sadri table predmeta koje profesor predaje i dugmad 'Dodaj predmet'(otvara se novi prozor sa spiskom predemta) i \n"
				+ "'Ukloni predmet'(selektuje se vrsta i onda klik)\n"
				+ "Prozor za izmenu predmeta sadrži samo tab Informacije koje sadrži sva polja neophodna za izmenu podataka o predmetu. \n"
				+ "Pretraga se studenta se vrši tako što se unese broj indeksa, prezime, ime \n"
				+ "ili prezime, ime ili samo prezime. \n"
				+ "Na sličan način se pretražuje Profesor(prezime, ime ili samo prezime), a za pretragu predmeta potrebno je uneto samo naziv predmeta. ");
		
		tekst.setText(description);
		tekst.setCaretPosition(0);
		
		JScrollPane scroll = new JScrollPane(tekst);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		add(scroll, BorderLayout.CENTER);
		
		
		
	}
	
	public static HelpDialog getInstance() {
		if(instace == null)
			instace = new HelpDialog();
		
		if(MainFrame.languageChanged) {
			initComponents();
		}
		
		return instace;
	}
	
	public static void initComponents() {
		
		instace.setTitle(MainFrame.getMainFrame().getResourceBundle().getString("helpDialogTitle"));
		infoLabel.setText(MainFrame.getMainFrame().getResourceBundle().getString("infoLabelAboutDialog"));
		tekst.setText(MainFrame.getMainFrame().getResourceBundle().getString("helpDialogText"));
		
		
		
	}
}
