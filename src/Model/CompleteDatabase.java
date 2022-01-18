package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import Controller.Converter;
import Model.Profesor.Zvanje;
import Model.Student.Status;
import Model.Subject.Term;
import gui.ProfessorJTable;
import gui.StudentTable;
import gui.SubjectJTable;
import gui.UnpassedExamsTable;


public class CompleteDatabase implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4833356850657704986L;
	private List<Student> students;
	private List<Profesor> professors;
	private List<Subject> subjects;
	private List<Grade> grades;
	
	public CompleteDatabase(List<Student> students, List<Profesor> professors, List<Subject> subjects, List<Grade> grades) {
		
		this.students = students;
		this.professors = professors;
		this.subjects = subjects;
		this.grades = grades;
		
	}
	
	


	public CompleteDatabase() {
		super();
		
		students = new ArrayList<Student>();
		professors = new ArrayList<Profesor>();
		subjects = new ArrayList<Subject>();
		grades = new ArrayList<Grade>();
	}




	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public List<Profesor> getProfessors() {
		return professors;
	}

	public void setProfessors(List<Profesor> professors) {
		this.professors = professors;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	public List<Grade> getGrades() {
		return grades;
	}

	public void setGrades(List<Grade> grades) {
		this.grades = grades;
	}
	
	public static void fillDatabase() {
		
		ProfessorDatabase professorDatabase = ProfessorDatabase.getDatabase();
		ProfessorJTable professorTable = ProfessorJTable.getTable();
		StudentDatabase studentDatabase = StudentDatabase.getInstance();
		StudentTable studentTable = StudentTable.getTable();
		SubjectDatabase subjectDatabase = SubjectDatabase.getDatabase();
		SubjectJTable subjectTable = SubjectJTable.getTable();
		
		Address a1 = new Address("Safarikova","2", "Novi Sad", "Srbija");
		Address a2 = new Address("Nikole Tesle", "56", "Novi Sad", "Srbija");
		Address a3 = new Address("Bulevar Patrijarha Pavla", "3", "Beograd", "Srbija");
		Address a4 = new Address("Strazilovska", "6a", "Novi Sad", "Srbija");
		Address a5 = new Address("Nikole Pasica", "2d", "Kikinda", "Srbija");
		Address a6 = new Address("Bulevar Kralja Petra", "22","Nis", "Srbija");
		Address a7 = new Address("Tolstojeva", "31", "Novi Sad", "Srbija");
		Address a8 = new Address("Mariceva", "11", "Kragujevac", "Srbija");
		Address a9 = new Address("Strazilovska", "3", "Beograd", "Srbija");
		Address a10 = new Address("Nikole Pasica", "6a", "Novi Sad", "Srbija");
		Address a11 = new Address("Bulevar Kralja Petra", "2d", "Nis", "Novi Sad");
		Address a12 = new Address("Knez Mihajlova", "22","Beograd", "Srbija");
		
		Profesor p1 = new Profesor("Milos", "Nikolic", Converter.convertStringToDate("12.12.1965") , "milos.nikolic@malinator.com", "021/365-785", a1, a10, 123123123, 30, Zvanje.REDOVNI_PROFESOR);
		Profesor p2 = new Profesor("Nikola", "Mirkovic", Converter.convertStringToDate("01.01.1978") , "nikola.mirkovic@malinator.com", "021/368-456", a2, a10, 321321321, 22, Zvanje.REDOVNI_PROFESOR);
		Profesor p3 = new Profesor("Ilija", "Petkovic", Converter.convertStringToDate("03.09.1988."), "ilija.petkovic@malinator.com", "021/215-314", a3, a10, 456456456, 22, Zvanje.VANREDNI_PROFESOR);
		Profesor p4 = new Profesor("Mitar", "Petrovic", Converter.convertStringToDate("25.07.1976."), "mitar.petrovic@malinator.com", "021/884-640", a4, a10, 789789789, 27, Zvanje.VANREDNI_PROFESOR);
		Profesor p5 = new Profesor("Vasa", "Micic", Converter.convertStringToDate("14.02.1970."), "vasa.micic@malinator.com", "021/212-114", a5, a10, 100100144, 24, Zvanje.DOCENT);
		Profesor p6 = new Profesor("Srdjan", "Miletic", Converter.convertStringToDate("20.04.1966."), "mitar.petrovic@malinator.com", "021/978-225", a6, a10, 200020244, 31, Zvanje.DOCENT);
		Profesor p7 = new Profesor("Branislav", "Mihajlovic", Converter.convertStringToDate("28.06.1980."), "branislav.mihajlovic@malinator.com", "021/778-323", a7, a10, 559585632, 13, Zvanje.REDOVNI_PROFESOR);
		Profesor p8 = new Profesor("Marko", "Markovic", Converter.convertStringToDate("31.01.1985."), "marko.markovic@malinator.com", "021/899-659", a8, a10, 334968855, 17, Zvanje.REDOVNI_PROFESOR);
		Profesor p9 = new Profesor("Milos", "Milakovic", Converter.convertStringToDate("21.09.1975."), "milos.milakovic@malinator.com", "021/122-326", a9, a10, 730703654, 12, Zvanje.VANREDNI_PROFESOR);
		Profesor p10 = new Profesor("Lazar", "Bratic", Converter.convertStringToDate("13.11.1973."), "lazar.bratic@malinator.com", "021/899-659", a10, a10, 600378644, 3, Zvanje.REDOVNI_PROFESOR);
		Profesor p11 = new Profesor("Ljeposava", "Drazic", Converter.convertStringToDate("11.08.1964."), "ljeposava.drazic@malinator.com", "021/888-156", a11, a10, 158496152, 31, Zvanje.DOCENT);
		Profesor p12 = new Profesor("Miroljub", "Dragic", Converter.convertStringToDate("02.03.1959."), "miroljub.dragic@malinator.com", "021/456-125", a12, a10, 777348595, 42, Zvanje.DOCENT);
		Profesor p13 = new Profesor("Bogdan", "Rekavic", Converter.convertStringToDate("23.06.1977."), "bogdan.rekavic@malinator.com", "021/886-455", a6, a10, 721254363, 18, Zvanje.VANREDNI_PROFESOR);
		Profesor p14 = new Profesor("Stanka", "Milic", Converter.convertStringToDate("03.03.1991."), "stanka.milic@malinator.com", "021/945-155", a3, a10, 225533448, 7, Zvanje.DOCENT);
		Profesor p15 = new Profesor("Milica", "Vukovic", Converter.convertStringToDate("18.10.1967."), "milica.vukovic@malinator.com", "021/746-659", a8, a10, 111555888, 14, Zvanje.VANREDNI_PROFESOR);
		Profesor p16 = new Profesor("Misa", "Misisc", Converter.convertStringToDate("20.10.1969."), "misa.misic@malinator.com", "021/489-326", a1, a10, 300300344, 19, Zvanje.DOCENT);
		Profesor p17 = new Profesor("Branko", "Maricic", Converter.convertStringToDate("18.01.1973."), "branko.maricic@malinator.com", "021/487-265", a2, a10, 400400444, 22, Zvanje.DOCENT);
		Profesor p18 = new Profesor("Branislav", "Lukovic", Converter.convertStringToDate("08.04.1982."), "branislav.lukovic@malinator.com", "021/159-478", a3, a10, 500500544, 9, Zvanje.REDOVNI_PROFESOR);
		Profesor p19 = new Profesor("Branimir", "Obradovic", Converter.convertStringToDate("07.01.1973."), "branimir.obradovic@malinator.com", "021/922-333", a1, a10, 600600644, 17, Zvanje.DOCENT);
		
		Student s1 = new Student("Marko","Milosevic", Converter.convertStringToDate("12.03.2001."), "marko.milosevic@mailinator.com",  "021/333-555", a1 ,"ra-2-2020",2020 , 1 ,Status.B);											
		Student s2 = new Student("Marija","Milić", Converter.convertStringToDate("12.01.2000."),"marija.milic@mailinator.com", "021/555-2222", a2,"ra-3-2019",2019,2,Status.S);											
		Student s3 = new Student("Nikola","Nikolic",Converter.convertStringToDate("30.08.2001."),"nikola.nikolic@mailinator.com", "021/135-463", a3, "ra-3-2017",2017,1,Status.B);											
		Student s4 = new Student("Pera","Peric",Converter.convertStringToDate("07.06.1995."),"pera.peric@mailinator.com", "021/903-463", a4, "ra-134-2015",2015,3,Status.S);											
		Student s5 = new Student("Sofija","Ilic",Converter.convertStringToDate("06.05.1999."),"sofija.ilic@mailinator.com", "021/731-067", a5, "ra-5-2019",2019,3,Status.B);											
		Student s6 = new Student("Martina","Lukic",Converter.convertStringToDate("16.05.1999."),"martina.lukic@mailinator.com","011/4333-800", a6, "ra-8-2018",2018,3,Status.S);											
		Student s7 = new Student("Stojan","Stojakovic",Converter.convertStringToDate("19.10.2001."),"stojan.stojakovic@mailinator.com", "011/3130-007", a7, "ra-10-2017",2017,1,Status.B);											
		Student s8 = new Student("Milan","Milanovic",Converter.convertStringToDate("02.11.2000."),"milan.milanovic@mailinator.com", "015/313-061", a8, "ra-12-2017",2017,2,Status.S);											
		Student s9 = new Student("Miroslav","Milic",Converter.convertStringToDate("11.10.2000."),"miroslav.milic@mailinator.com", "021/351-091", a9, "ra-16-2019",2019,2,Status.B);											
		Student s10 = new Student("Stefan","Gojic",Converter.convertStringToDate("01.05.1999.") ,"stefan.gojic@mailinator.com", "015/324-500", a10, "ra-21-2015",2015,3, Status.S);											
		Student s11 = new Student("Anastasija","Jokic",Converter.convertStringToDate("11.07.1999."),"anastasija.jokic@mailinator.com", "011/2333-900", a11, "ra-9-2020",2020,3,Status.B);											
		Student s12 = new Student("Bogdan","Bogdanovic",Converter.convertStringToDate("23.07.1999."),"bogdan.bogdanovic@mailinator.com","021/231-114", a12, "ra-4-2017",2017,3,Status.S);											
		Student s13 = new Student("Ana","Dabovic",Converter.convertStringToDate("12.12.2001."),"ana.dabovic@mailinator.com","014/303-007", null, "ra-30-2019",2019,1,Status.B);											
		Student s14 = new Student("Mika","Mikic",Converter.convertStringToDate("05.11.2001."),"mika.mikic@mailinator.com","015/101-909", a2, "ra-1-2020",2020,1,Status.S);											
		Student s15 = new Student("Jovan","Deretic", Converter.convertStringToDate("10.09.1998."),"jovan.deretic@mailinator.com","002/200-300", a3, "ra-11-2018",2018,4,Status.B);											
		Student s16 = new Student("Nikola","Miskovic",Converter.convertStringToDate("03.08.1998."),"nikola.miskovic@mailinator.com","022/123-456", a4, "ra-12-2018",2018,4,Status.S);											
		Student s17 = new Student("Martin","Stojanovic",Converter.convertStringToDate("01.05.1998."),"martin.stojanovic@mailinator.com","024/321-775", null, "ra-13-2018",2018,4,Status.S);											
		Student s18 = new Student("Tomislav","Novakovic",Converter.convertStringToDate("25.02.1996."),"tomislav.novakovic@mailinator.com","011/1188-379", a6, "ra-14-2018",2018,4,Status.B);											
		Student s19 = new Student("Lena","Ivic", Converter.convertStringToDate("11.05.1998."),"lena.ivic@mailinator.com","024/333-555", a7, "ra-154-2016",2016,4,Status.B);											
		Student s20 = new Student("Jovan","Lazic",Converter.convertStringToDate("22.01.2001."),"jovan.lazic@mailinator.com", "025/1189-479", a8, "ra-23-2020",2020,1,Status.B);											
		Student s21 = new Student("Isidora","Mikic",Converter.convertStringToDate("31.12.2000."),"isidora.mikic@mailinator.com","011/1122-366", a9, "ra-1-2019",2019,2,Status.B);											
		Student s22 = new Student("Vladimir","Ilic",Converter.convertStringToDate("31.08.1998."),"vladimir.ilic@mailinator.com","0211122-367", a10, "sw-4-2014",2014,4,Status.B);											
		Student s23 = new Student("Mirko","Alicic", Converter.convertStringToDate("21.07.1999."),"mirko.alicic@mailinator.com","012/1122-368", a11, "sw-17-2015",2015,3,Status.S);											
		Student s24 = new Student("Milisav","Perkovic", Converter.convertStringToDate("28.09.1998."),"milisav.pejkovic@mailinator.com","012/1122-369", a12, "sw-17-2016",2016,4,Status.S);											
		Student s25 = new Student("Purisa","Djordjevic",Converter.convertStringToDate("29.02.2000."),"purisa.djordjevic@mailinator.com","011/1543-370", a3, "sw-27-2018",2018,2,Status.B);											
		Student s26 = new Student("Mikica","Kovacevic", Converter.convertStringToDate("23.03.1999."),"mikica.kovacevic@mailinator.com","011/1992-371", a5, "ra-226-2017",2017,3,Status.S);											
		Student s27 = new Student("Miloš","Milić", Converter.convertStringToDate("21.10.2001."),"milos.milic@mailinator.com","011/8172-372", a2, "sw-12-2020",2020,1,Status.S);	
		
		Subject subj1 = new Subject("p1", "osnove programiranja", Term.WINTER, 1, p2, 7);
		Subject subj2 = new Subject("p2", "statistika", Term.SUMMER, 3, p2, 8);
		Subject subj3 = new Subject("p3", "algoritmi i strukture podataka", Term.SUMMER, 2, p2, 9);
		Subject subj4 = new Subject("p4", "LPRS", Term.WINTER, 3, p2, 7);
		Subject subj5 = new Subject("p5", "matematika", Term.SUMMER, 1, null, 11);
		Subject subj6 = new Subject("p6", "xml i web servisi", Term.SUMMER, 4, null, 6);
		Subject subj7 = new Subject("p7", "Metode optimizacije", Term.WINTER, 3, null, 6);
		Subject subj8 = new Subject("p8", "osnove elektrotehnike", Term.SUMMER, 1, p5, 11);
		Subject subj9 = new Subject("p9", "Sociologija", Term.WINTER, 1, p5, 10);
		Subject subj10 = new Subject("p10", "Filozofija", Term.WINTER, 1, p5, 4);
		Subject subj11 = new Subject("p11", "ORT", Term.SUMMER, 2, null, 7);
		Subject subj12 = new Subject("p12", "NANS", Term.SUMMER, 2, p6, 5);
		Subject subj13 = new Subject("p13", "Organizacija podataka", Term.WINTER, 2, p6, 7);
		Subject subj14 = new Subject("p14", "Baze podataka", Term.WINTER, 2, p6, 6);
		Subject subj15 = new Subject("p15", "paralelno programiranje", Term.WINTER, 2, p7, 8);
		Subject subj16 = new Subject("p16", "konkurentno programiranje", Term.SUMMER, 2, p7, 9);
		Subject subj17 = new Subject("p17", "Operativni sistemi", Term.SUMMER, 2, null, 8);
		Subject subj18 = new Subject("p18", "Algebra", Term.WINTER, 1, null, 15);
		Subject subj19 = new Subject("p19", "Diskretna matematika", Term.SUMMER, 3, null, 14);
		Subject subj20 = new Subject("ps20", "Upravljacki sistemi", Term.SUMMER, 3, null, 8);
		Subject subj21 = new Subject("ps21", "Osnovi elektrotehnike", Term.WINTER, 2, null, 7);
		Subject subj22 = new Subject("ps22", "Slucajni procesi", Term.SUMMER, 4, null, 9);
		Subject subj23 = new Subject("ps23", "Racunarstvo visokih performansi", Term.SUMMER, 4, null, 10);
		Subject subj24 = new Subject("p24", "Analiza 1", Term.WINTER, 1, null, 20);
		Subject subj25 = new Subject("it25", "Informaciona bezbednost", Term.SUMMER, 4, p17, 9);
		Subject subj26 = new Subject("it26", "Elektronsko placanje", Term.WINTER, 3, p18, 8);
		Subject subj27 = new Subject("p16", "Distribuirani sistemi", Term.SUMMER, 4, p19, 6);
		Subject subj28 = new Subject("p28", "Projektovanje softvera", Term.WINTER, 3, p18, 5);
		Subject subj29 = new Subject("p29", "Informacioni sistemi", Term.WINTER, 4, p17, 6);
		Subject subj30 = new Subject("p30", "Masinsko ucenje", Term.SUMMER, 4, null, 7);
		
		p2.getSubjectsTeaches().add(subj1);
		p2.getSubjectsTeaches().add(subj2);
		p2.getSubjectsTeaches().add(subj3);
		p2.getSubjectsTeaches().add(subj4);
		p5.getSubjectsTeaches().add(subj8);
		p5.getSubjectsTeaches().add(subj9);
		p5.getSubjectsTeaches().add(subj10);
		p6.getSubjectsTeaches().add(subj12);
		p6.getSubjectsTeaches().add(subj13);
		p6.getSubjectsTeaches().add(subj14);
		p7.getSubjectsTeaches().add(subj15);
		p7.getSubjectsTeaches().add(subj16);
		p17.getSubjectsTeaches().add(subj25);
		p18.getSubjectsTeaches().add(subj26);
		p19.getSubjectsTeaches().add(subj27);
		p18.getSubjectsTeaches().add(subj28);
		p17.getSubjectsTeaches().add(subj29);
		
		professorDatabase.addProfessorToTable(p1);
		professorDatabase.addProfessorToTable(p2);
		professorDatabase.addProfessorToTable(p3);
		professorDatabase.addProfessorToTable(p4);
		professorDatabase.addProfessorToTable(p5);
		professorDatabase.addProfessorToTable(p6);
		professorDatabase.addProfessorToTable(p7);
		professorDatabase.addProfessorToTable(p8);
		professorDatabase.addProfessorToTable(p9);
		professorDatabase.addProfessorToTable(p10);
		professorDatabase.addProfessorToTable(p11);
		professorDatabase.addProfessorToTable(p12);
		professorDatabase.addProfessorToTable(p13);
		professorDatabase.addProfessorToTable(p14);
		professorDatabase.addProfessorToTable(p15);
		professorDatabase.addProfessorToTable(p16);
		professorDatabase.addProfessorToTable(p17);
		professorDatabase.addProfessorToTable(p18);
		professorDatabase.addProfessorToTable(p19);
		
		
		studentDatabase.addStudentsIntoTable(s1);
		studentDatabase.addStudentsIntoTable(s2);
		studentDatabase.addStudentsIntoTable(s3);
		studentDatabase.addStudentsIntoTable(s4);
		studentDatabase.addStudentsIntoTable(s5);
		studentDatabase.addStudentsIntoTable(s6);
		studentDatabase.addStudentsIntoTable(s7);
		studentDatabase.addStudentsIntoTable(s8);
		studentDatabase.addStudentsIntoTable(s9);
		studentDatabase.addStudentsIntoTable(s10);
		studentDatabase.addStudentsIntoTable(s11);
		studentDatabase.addStudentsIntoTable(s12);
		studentDatabase.addStudentsIntoTable(s13);
		studentDatabase.addStudentsIntoTable(s14);
		studentDatabase.addStudentsIntoTable(s15);
		studentDatabase.addStudentsIntoTable(s16);
		studentDatabase.addStudentsIntoTable(s17);
		studentDatabase.addStudentsIntoTable(s18);
		studentDatabase.addStudentsIntoTable(s19);
		studentDatabase.addStudentsIntoTable(s20);
		studentDatabase.addStudentsIntoTable(s21);
		studentDatabase.addStudentsIntoTable(s22);
		studentDatabase.addStudentsIntoTable(s23);
		studentDatabase.addStudentsIntoTable(s24);
		studentDatabase.addStudentsIntoTable(s25);
		studentDatabase.addStudentsIntoTable(s26);
		studentDatabase.addStudentsIntoTable(s27);
	 
		subjectDatabase.addSubjectIntoTable(subj1);
		subjectDatabase.addSubjectIntoTable(subj2);
		subjectDatabase.addSubjectIntoTable(subj3);
		subjectDatabase.addSubjectIntoTable(subj4);
		subjectDatabase.addSubjectIntoTable(subj5);
		subjectDatabase.addSubjectIntoTable(subj6);
		subjectDatabase.addSubjectIntoTable(subj7);
		subjectDatabase.addSubjectIntoTable(subj8);
		subjectDatabase.addSubjectIntoTable(subj9);
		subjectDatabase.addSubjectIntoTable(subj10);
		subjectDatabase.addSubjectIntoTable(subj11);
		subjectDatabase.addSubjectIntoTable(subj12);
		subjectDatabase.addSubjectIntoTable(subj13);
		subjectDatabase.addSubjectIntoTable(subj14);
		subjectDatabase.addSubjectIntoTable(subj15);
		subjectDatabase.addSubjectIntoTable(subj16);
		subjectDatabase.addSubjectIntoTable(subj17);
		subjectDatabase.addSubjectIntoTable(subj18);
		subjectDatabase.addSubjectIntoTable(subj19);
		subjectDatabase.addSubjectIntoTable(subj20);
		subjectDatabase.addSubjectIntoTable(subj21);
		subjectDatabase.addSubjectIntoTable(subj22);
		subjectDatabase.addSubjectIntoTable(subj23);
		subjectDatabase.addSubjectIntoTable(subj24);
		subjectDatabase.addSubjectIntoTable(subj25);
		subjectDatabase.addSubjectIntoTable(subj26);
		subjectDatabase.addSubjectIntoTable(subj27);
		subjectDatabase.addSubjectIntoTable(subj28);
		subjectDatabase.addSubjectIntoTable(subj29);
		subjectDatabase.addSubjectIntoTable(subj30);
		
		s4.getUnpassedCourses().add(subj2);
		s4.getUnpassedCourses().add(subj4);
		s17.getUnpassedCourses().add(subj15);
		s18.getUnpassedCourses().add(subj15);
		s22.getUnpassedCourses().add(subj18);
		s23.getUnpassedCourses().add(subj18);
		s24.getUnpassedCourses().add(subj18);
		s26.getUnpassedCourses().add(subj18);
		s22.getUnpassedCourses().add(subj19);
		s23.getUnpassedCourses().add(subj19);
		s24.getUnpassedCourses().add(subj19);
		s26.getUnpassedCourses().add(subj19);
		
		Grade g1 = new Grade(s4, subj5, 10, Converter.convertStringToDate("12.12.2017"));
		Grade g2 = new Grade(s4, subj3, 9, Converter.convertStringToDate("10.11.2019"));
		Grade g3 = new Grade(s4, subj1, 8, Converter.convertStringToDate("11.11.2020"));
		Grade g4 = new Grade(s2, subj1, 10, Converter.convertStringToDate("20.11.2020"));
		Grade g5 = new Grade(s2, subj5, 10, Converter.convertStringToDate("30.10.2021"));
		Grade g6 = new Grade(s15, subj15, 7, Converter.convertStringToDate("10.11.2021"));
		Grade g7 = new Grade(s16, subj15, 10, Converter.convertStringToDate("12.01.2018"));
		Grade g8 = new Grade(s15, subj16, 10, Converter.convertStringToDate("01.01.2021"));
		Grade g9 = new Grade(s16, subj16, 9, Converter.convertStringToDate("04.02.2019"));
		
		s4.getPassedCourses().add(g1);
		s4.getPassedCourses().add(g2);
		s4.getPassedCourses().add(g3);
		s2.getPassedCourses().add(g4);
		s2.getPassedCourses().add(g5);
		s15.getPassedCourses().add(g6);
		s16.getPassedCourses().add(g7);
		s15.getPassedCourses().add(g8);
		s16.getPassedCourses().add(g9);
		
		s4.setAvgMark();
		s2.setAvgMark();
		s15.setAvgMark();
		s16.setAvgMark();
		
		UnpassedExamsTable unpassedExamsTable = UnpassedExamsTable.getTable();
		unpassedExamsTable.updateTable();
		professorTable.updateTable();
		studentTable.updateTable();
		subjectTable.updateTable();
	}

}
