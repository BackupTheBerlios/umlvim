 package fr.umlv.desperados.util;

// JDK API

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.DateFormat;
import java.util.Enumeration;
import java.util.Locale;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

// UNO API
import com.sun.star.bridge.XUnoUrlResolver;
import com.sun.star.uno.XComponentContext;
import com.sun.star.uno.UnoRuntime;
import com.sun.star.frame.XComponentLoader;
import com.sun.star.frame.XStorable;
import com.sun.star.beans.PropertyValue;
import com.sun.star.beans.XPropertySet;
import com.sun.star.lang.XComponent;
import com.sun.star.lang.XMultiComponentFactory;

import fr.umlv.desperados.student.DatabaseInformationListManager;
import fr.umlv.desperados.student.Student;

/** This class implements a http servlet in order to convert an incoming document
 * with help of a running OpenOffice.org and to push the converted file back
 * to the client.
 */
public class PDFTools {
	
	private final static String stringHost = "localhost";
	private final static String stringPort = "8100";
  
  	private String fileName;
  	
  	public PDFTools(String fileName) {
  		this.fileName = fileName;
  	}
  
   /** This method converts a document to a given type by using a running
   * OpenOffice.org and saves the converted document to the specified
   * working directory.
   * @param stringDocumentName The full path name of the file on the server to be converted.
   * @return The full path name of the converted file will be returned.
   * @see stringWorkingDirectory
   */  
  public String convertDocument() {
	String stringConvertedFile = "";
	
	// Converting the document to the favoured type
	try {
	  // Composing the URL
	  String stringUrl = "file:///" + fileName;

	  /* Bootstraps a component context with the jurt base components
		 registered. Component context to be granted to a component for running.
		 Arbitrary values can be retrieved from the context. */
	  XComponentContext xcomponentcontext =
	  com.sun.star.comp.helper.Bootstrap.createInitialComponentContext( null );
      
	  /* Gets the service manager instance to be used (or null). This method has
		 been added for convenience, because the service manager is a often used
		 object. */
	  XMultiComponentFactory xmulticomponentfactory =
	  xcomponentcontext.getServiceManager();
      
	  /* Creates an instance of the component UnoUrlResolver which
		 supports the services specified by the factory. */
	  Object objectUrlResolver =
	  xmulticomponentfactory.createInstanceWithContext(
	  "com.sun.star.bridge.UnoUrlResolver", xcomponentcontext );
      
	  // Create a new url resolver
	  XUnoUrlResolver xurlresolver = ( XUnoUrlResolver )
	  UnoRuntime.queryInterface( XUnoUrlResolver.class,
	  objectUrlResolver );
      
	  // Resolves an object that is specified as follow:
	  // uno:<connection description>;<protocol description>;<initial object name>
	  Object objectInitial = xurlresolver.resolve(
	  "uno:socket,host=" + stringHost + ",port=" + stringPort + ";urp;StarOffice.ServiceManager" );
      
	  // Create a service manager from the initial object
	  xmulticomponentfactory = ( XMultiComponentFactory )
	  UnoRuntime.queryInterface( XMultiComponentFactory.class, objectInitial );
      
	  // Query for the XPropertySet interface.
	  XPropertySet xpropertysetMultiComponentFactory = ( XPropertySet )
	  UnoRuntime.queryInterface( XPropertySet.class, xmulticomponentfactory );
      
	  // Get the default context from the office server.
	  Object objectDefaultContext =
	  xpropertysetMultiComponentFactory.getPropertyValue( "DefaultContext" );
      
	  // Query for the interface XComponentContext.
	  xcomponentcontext = ( XComponentContext ) UnoRuntime.queryInterface(
	  XComponentContext.class, objectDefaultContext );
      
	  /* A desktop environment contains tasks with one or more
		 frames in which components can be loaded. Desktop is the
		 environment for components which can instanciate within
		 frames. */
	  XComponentLoader xcomponentloader = ( XComponentLoader )
	  UnoRuntime.queryInterface( XComponentLoader.class,
	  xmulticomponentfactory.createInstanceWithContext(
	  "com.sun.star.frame.Desktop", xcomponentcontext ) );
      
	  // Preparing properties for loading the document
	  PropertyValue propertyvalue[] = new PropertyValue[ 1 ];
	  // Setting the flag for hidding the open document
	  propertyvalue[ 0 ] = new PropertyValue();
	  propertyvalue[ 0 ].Name = "Hidden";
	  propertyvalue[ 0 ].Value = new Boolean(false);
      
	  // Loading the wanted document
	  Object objectDocumentToStore = 
	  xcomponentloader.loadComponentFromURL(
	  stringUrl, "_blank", 0, propertyvalue ); 
	  //xcomponentloader.loadComponentFromURL(
	  //stringUrl,"_blank", 0, new PropertyValue[0]);
	    
	  // Getting an object that will offer a simple way to store a document to a URL.
	  XStorable xstorable =
	  ( XStorable ) UnoRuntime.queryInterface( XStorable.class,
	  objectDocumentToStore );
      
	  // Preparing properties for converting the document
	  propertyvalue = new PropertyValue[ 2 ];
	  // Setting the flag for overwriting
	  propertyvalue[ 0 ] = new PropertyValue();
	  propertyvalue[ 0 ].Name = "FilterName";
	  propertyvalue[ 0 ].Value = "writer_pdf_Export";
	  // Setting the filter name	
	  propertyvalue[ 1 ] = new PropertyValue();
	  propertyvalue[ 1 ].Name = "CompressionMode";
	  propertyvalue[ 1 ].Value = "1";
      
	  // Appending the favoured extension to the origin document name
	  int index = stringUrl.lastIndexOf(".");
	  stringConvertedFile = stringUrl.substring(0, index + 1) + "pdf";
     
      // Storing and converting the document
	  xstorable.storeToURL( stringConvertedFile, propertyvalue);

	  // Getting the method dispose() for closing the document
	  XComponent xcomponent =
	  ( XComponent ) UnoRuntime.queryInterface( XComponent.class,
	  xstorable );
      
	  // Closing the converted document
	  xcomponent.dispose();
	}
	catch( Exception exception ) {
	  exception.printStackTrace();
	  return( "" );
	}
    
	if ( stringConvertedFile.startsWith( "file:///" ) ) {
	  // Truncating the beginning of the file name
	  stringConvertedFile = stringConvertedFile.substring( 8 );
	}
    
	// Returning the name of the converted file
	return( stringConvertedFile );
  }
  
  public void modifyFile(Student student, DatabaseInformationListManager manager) {
  	try {
		ZipFile zipfile = new ZipFile(fileName);
		InputStream is = zipfile.getInputStream(zipfile.getEntry("content.xml"));
		StringBuffer sbuff = inputStreamToString(is);

		replace(sbuff,"#prenom#", student.getFirstname1());
		replace(sbuff,"#nom_pat#", student.getPatronymicName());	

		// appointement
		if(student.getAppointmentDate() != null) {
			DateFormat d = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT, Locale.FRENCH);
			String sdate = d.format(student.getAppointmentDate());
			replace(sbuff, "#jour#", sdate.substring(0,8));
			replace(sbuff, "#heure#", sdate.substring(8,14));
		}
		// inscription
		else {
			replace(sbuff,"#nom_pat#", student.getPatronymicName());	
			replace(sbuff,"#prenom2#", student.getFirstname2());
			DateFormat d = DateFormat.getDateInstance(DateFormat.SHORT, Locale.FRENCH);
			String sdate = d.format(student.getBirthday());
			replace(sbuff, "#date_naissance#", sdate);
			replace(sbuff,"#INE#", student.getIne());
			String nat = new Integer(student.getNationalityId()).toString();
			replace(sbuff,"#code_nationalite#", nat);
			//replace(sbuff, "#nationalite#", manager.get(DatabaseInformationListManager.NATIONALITY, nat));
			//replace(sbuff,"#ville_naissance#", student.getTownOfBirth());
			replace(sbuff, "#sexe#", student.getSex());
		
			// faire des tests ...
			replace(sbuff, "#lieu_naissance#", new Integer(student.getForeignBirthplaceId()).toString());
		
			replace(sbuff,"#inscr1_an1#", student.getFirstInsSupEduc());
			replace(sbuff,"#inscr1_an2#", student.getFirstInsFrenchUniv());
			replace(sbuff, "#inscr1_eta#", student.getEstaFirstInsFrenchUniv());
			replace(sbuff, "#inscr1_dep#", new Integer(student.getFirstInsFrUnivDepId()).toString());
			replace(sbuff, "#inscr1_an3#", student.getFirstInsEstablishment());
		
			/*************************** Baccalaureat *********************************/
			// replace(sbuff, "#code_bac#", student.getBaccalaureatId());
			replace(sbuff, "#annee_bac#", student.getBacYear());
			String mention = manager.get(DatabaseInformationListManager.BAC_MENTION, new Integer(student.getBacMentionId()).toString());
			//replace(sbuff, "#mention#", mention);
			Integer year = new Integer(student.getBacYear());
			String resource;
			if(year.intValue() >= 1995)
				resource = DatabaseInformationListManager.BAC_POST_95;
			else resource = DatabaseInformationListManager.BAC_PRE_95;
			//replace(sbuff, "#serie#", manager.get(resource, student.getBaccalaureatId()));
			//replace(sbuff, "#bac_ville#", student.getb)
			replace(sbuff, "#bac_eta#", student.getEstablishmentBacObtaining());
		
			/********************************Fix and Temp Addresses*********************************/
			replace(sbuff, "#fixe_adr#", student.getNumFixAdd() 
							+ "-" + student.getBuildingFixAdd()
							+ "-" + student.getStreetFixAdd());
			replace(sbuff, "#fixe_pays#", student.getForeignCityFixAdd());
			replace(sbuff, "#fixe_tel#", student.getPhoneFixAdd());
		
			replace(sbuff, "#tmp_adr#", student.getNumTmpAdd()
							+ "-" + student.getBuildingTmpAdd()
							+ "-" + student.getStreetTmpAdd());
			replace(sbuff, "#tmp_ville#", student.getCityTmpAdd());
			replace(sbuff, "#tmp_tel#", student.getPhoneTmpAdd());
		
			/********************** Job ************************/
			replace(sbuff, "#emploi#", student.isEmployed()?"oui":"non");
			String emploi = student.getStudEmplType();
			System.out.println("emploi = "+emploi);
			//replace(sbuff, "#emploi_nom#", manager.get(DatabaseInformationListManager.SOCIAL_ECONOMIC_CATEGORY, emploi));
			//replace(sbuff, "#emploi_code#", student.getStudEmplType());
			//replace(sbuff, "#prof_chef#", student.getHeadFamProf());
		
			//replace(sbuff, "#sport#", student.getPractisedSport());
		
			/******************Financial Aid*****************/
			//replace(sbuff, "#aide_code#", student.getFinancialAssistanceId());
			//replace(sbuff, "#aide#", manager.get(DatabaseInformationListManager.FINANCIAL_AID, student.getFinancialAssistanceId()));
		
			/***************** Inscriptions ******************/
			String diploma = new Integer(student.getMLVDiplomaId()).toString();
			//replace(sbuff, "#inscr_principale#", manager.get(DatabaseInformationListManager.MLV_DIPLOMA, diploma));
			//replace(sbuff, "#nb1#", new Integer(student.getPrincCycleInsNum()).toString());
			//replace(sbuff, "#nb2#", new Integer(student.getPrincDiplInsNum()).toString());
			//replace(sbuff, "#nb3#", new Integer(student.getPrincInsYearNum()).toString());
			//diploma = new Integer(student.getMLVDiplomaComplId()).toString();
			//replace(sbuff, "#inscr_complementaire#", manager.get(DatabaseInformationListManager.MLV_DIPLOMA, diploma));
			//replace(sbuff, "#nb4#", new Integer(student.getComplCycleInsNum()).toString());
			//replace(sbuff, "#nb5#", new Integer(student.getComplDipInsNum()).toString());
			//replace(sbuff, "#nb6#", new Integer(student.getCompInsYearNum()).toString());
		
		
			//replace(sbuff, "#numero_boursier#", new Integer(student.getStockBrokerNum()).toString());
			//replace(sbuff, "#prolongation_motif#", student.getMotifProlSocSec());
			//replace(sbuff, "#SS#", student.getSocialSecurityNum());
			//replace(sbuff, "#nom_pere#", student.getFatherName());
			//replace(sbuff, "#prenom_pere#", student.getFatherFirstName());
			//replace(sbuff, "#prenom_mere#", student.getMotherName());
			//replace(sbuff, "#nom_mere#", student.getMotherPatronymicName());
		}	
		changeContentFile(sbuff.toString().getBytes());
	} catch (IOException e) {
		// TODO Bloc catch auto-généré
		e.printStackTrace();
	}
  }
  
 /** Read the content of a Stream into a String */
  private StringBuffer inputStreamToString(InputStream is) throws IOException {
  	Reader reader = new InputStreamReader(is);
	StringBuffer sb = new StringBuffer();
	char[] b = new char[8192];
	int n;
	// Read a block. If it gets any chars, append them.
	while((n=reader.read(b))>0) {
	 sb.append(b,0,n);
	}
	// Only construct the String object once, here.
	return sb;
  }
  
  private void replace(StringBuffer buffer, String oldString, String newString) {
	int start = buffer.indexOf(oldString);
	if(start != -1) {
		int end = start + oldString.length();
  		buffer.replace(start, end, newString);
  	}
  }

  private void changeContentFile(byte[] buff) {
  	try {
  		copy(fileName, fileName+".tmp");
  		ZipFile zf = new ZipFile(fileName+".tmp");
  		byte[] data = new byte[2048];
  		Enumeration e = zf.entries();

		ZipOutputStream zos = new 
			ZipOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)));
			
		ZipEntry entry = new ZipEntry("content.xml");
		zos.putNextEntry(entry);
		zos.write(buff, 0, buff.length);
		while(e.hasMoreElements()) {
			ZipEntry en = (ZipEntry)e.nextElement();
			if(!en.getName().trim().equals("content.xml")) {
				zos.putNextEntry(en);
				InputStream origin = zf.getInputStream(en);
				int count;
				while((count = origin.read(data,0, 2048)) != -1) {
					zos.write(data, 0, count);
				}
				origin.close();
			}
		}
		zos.close();
		zf.close();		
		new File(fileName+".tmp").delete();
		
	} catch (FileNotFoundException e) {
		// TODO Bloc catch auto-généré
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Bloc catch auto-généré
		e.printStackTrace();
  	}
  }
  
  public static void copy(String from, String to) {
  try {
	  FileInputStream in = new FileInputStream(new File(from));
	  FileOutputStream out = new FileOutputStream(new File(to));
	  int i;
	  while((i = in.read()) > -1)
	  out.write(i);
	  in.close();
	  out.flush();
	  out.close();
  }
  catch (FileNotFoundException fnfe) {
	  System.out.println("copy: fnfe: "+fnfe);}
  catch (IOException ioe) {
	  System.out.println("copy: ioe: "+ioe); }
  }
}