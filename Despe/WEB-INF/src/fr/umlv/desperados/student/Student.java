//Source file: C:\\DOCUMENTS AND SETTINGS\\NCUVELIE\\MES DOCUMENTS\\GÉNIE LOG\\SRC\\fr\\umlv\\desperados\\student\\Student.java

package fr.umlv.desperados.student;

import java.sql.Timestamp;
import java.util.Date;

import fr.umlv.desperados.util.XMLable;

/**
 * Object that defines a student in the application.
 */
public class Student implements XMLable 
{
   
   /**
    * primary key in the Student database
    */
   private String studentId;
   
   /**
    * @see Current name
    */
   private String name;
   private String firstName;
   private Date birthday;
   private String ine;
   private boolean wasToUmlvLastYear;
   private String patronymicName;
   private String firstname1;
   private String firstname2;
   private String townOfBirth;
   private char sex;
   private String firstInsSupEduc;
   
   /**
    * @see first inscription french university
    */
   private String firstInsFrenchUniv;
   
   /**
    * @see establishment first inscription french university
    */
   private String estaFirstInsFrenchUniv;
   
   /**
    * @see first inscription establishment
    */
   private String firstInsEstablishment;
   
   /**
    * @see year bac obtaining
    */
   private String bacYear;
   private String establishmentBacObtaining;
   
   /**
    * @see foreign city bac
    */
   private String foreignCityBac;
   
   /**
    * @see have a fixed address in France
    */
   private boolean haveFixAddFr;
   
   /**
    * @see number fixe address
    */
   private String numFixAdd;
   
   /**
    * @see street fixe address
    */
   private String streetFixAdd;
   
   /**
    * @see building fixed address
    */
   private String buildingFixAdd;
   
   /**
    * @see foreign city fixed address
    */
   private String foreignCityFixAdd;
   
   /**
    * @see phone fixe address
    */
   private int phoneFixAdd;
   
   /**
    * @see have a temporary address in France
    */
   private boolean haveTmpAddFr;
   
   /**
    * @see number temporary address
    */
   private String numTmpAdd;
   
   /**
    * @see street temporary address
    */
   private String streetTmpAdd;
   
   /**
    * @see building temporary address
    */
   private String buildingTmpAdd;
   
   /**
    * @see city temporary address
    */
   private String cityTmpAdd;
   
   /**
    * @see phone temporary address
    */
   private int phoneTmpAdd;
   
   /**
    * @see is employed
    */
   private boolean isEmployed;
   
   /**
    * @see student employment type
    */
   private String studEmplType;
   
   /**
    * @see head of family profession
    */
   private String headFamProf;
   
   /**
    * @see is national sportsman
    */
   private boolean isNatSport;
   private boolean isRegSport;
   
   /**
    * @see practised sport
    */
   private String practisedSport;
   
   /**
    * @see have a financial assistance
    */
   private boolean haveFinancialAss;
   
   /**
    * @see international exchange original astablishment
    */
   private String internaExchOriEstab;
   
   /**
    * @see international exchange reception establishment
    */
   private String internaExchRecEstab;
   
   /**
    * @see last attended establishment
    */
   private String lastAttendedEstab;
   
   /**
    * @see last attended establishment year
    */
   private String lastAttendedEstabYear;
   
   /**
    * @see precedent year establishment
    */
   private String precedentYearEstab;
   
   /**
    * @see other inscription establishment
    */
   private String otherInsEstab;
   
   /**
    * @see principal cycle inscriptions number
    */
   private int princCycleInsNum;
   
   /**
    * @see complementary cycle inscriptions number
    */
   private int complCycleInsNum;
   
   /**
    * @see principal diploma inscription number
    */
   private int princDiplInsNum;
   
   /**
    * @see complementary diploma inscription number
    */
   private int complDipInsNum;
   
   /**
    * @see principal inscriptions year number
    */
   private int princInsYearNum;
   
   /**
    * @see complementary inscriptions year number
    */
   private int compInsYearNum;
   
   /**
    * @see stock broker number
    */
   private int stockBrokerNum;
   
   /**
    * @see social security number
    */
   private String socialSecurityNum;
   
   /**
    * @see father name
    */
   private String fatherName;
   
   /**
    * @see father first name
    */
   private String fatherFirstName;
   
   /**
    * @see mother patronymic name
    */
   private String motherPatronymicName;
   
   /**
    * @see mother name
    */
   private String motherName;
   
   /**
    * @see insurance civil liability
    */
   private boolean insuranceCivilLiability;
   
   /**
    * @see appointment date
    */
   private Timestamp appointmentDate;
   private int workedShareId;
   private char financialAssistanceId;
   private int socialEconomicCategoryId;
   private int MLVDiplomaId;
   private String baccalaureatId;
   private String handicapId;
   private int lodgingTypeId;
   private int inscriptionModeId;
   private int inscriptionTypeId;
   private int centerPaymentId;
   private int internationalExchangeTypeId;
   private int mutualInsuranceCompanyId;
   private int socialSecurityId;
   private int paymentModeId;
   private int purseIde;
   private char lastDiplomaTypeId;
   private int bacMentionId;
   private int baccalaureatEstablishmentTypeId;
   private int lastEstabTypeId;
   private int militarySituationId;
   private int fixeAddFrenchCityId;
   private int tmpAdressFrenchCityId;
   private int frenchBirthplaceId;
   private int frenchBacCityId;
   
   /**
    * @see first inscription in french university department identify
    */
   private int firstInsFrUnivDepId;
   
   /**
    * @see last attended establishment place identify
    */
   private int lastAttendedEstabPlaceId;
   
   /**
    * @see precedent year establishment place identify
    */
   private int precYearEstabPlaceId;
   
   /**
    * @see other establishment inscription place idetify
    */
   private int otherEstabInsPlaceId;
   private int bacObtainingCountryId;
   private int nationalityId;
   
   /**
    * @see international exchange place identify
    */
   private int intExchPlaceId;
   private int foreignBirthplaceId;
   
   /**
    * @see fixed address country identify
    */
   private int fixeAddCountryId;
   
   /**
    * @see temporary address country identify
    */
   private int tmpAddCountryId;
   
   /**
    * @see precedent year situation type identify
    */
   private int precYearSitTypeId;
   private int famSituation;
   private String motifProlSocSec;
   private boolean noSocSecStu;
   private char sitLastYear;
   private int otherEtabIns;
   
   /**
    * @param studentId
    * @roseuid 3FCA089F033C
    */
   public Student(int studentId) 
   {
    
   }
   
   /**
    * @param name
    * @roseuid 3FCB614B000D
    */
   public void setName(String name) 
   {
    
   }
   
   /**
    * @param firstname
    * @roseuid 3FCB6159007B
    */
   public void setFirstname(String firstname) 
   {
    
   }
   
   /**
    * @param birthday
    * @roseuid 3FCB618101F5
    */
   public void setBirthday(java.util.Date birthday) 
   {
    
   }
   
   /**
    * @param ine
    * @roseuid 3FD7AD2603D8
    */
   public void setIne(String ine) 
   {
    
   }
   
   /**
    * @return int
    * @roseuid 3FD7AD550148
    */
   public int getStudentId() 
   {
    return 0;
   }
   
   /**
    * @return java.lang.String
    * @roseuid 3FD7AD74003E
    */
   public String getName() 
   {
    return null;
   }
   
   /**
    * @return java.lang.String
    * @roseuid 3FD7AD82004E
    */
   public String getFirstName() 
   {
    return null;
   }
   
   /**
    * @return java.util.Date
    * @roseuid 3FD7AD9000BB
    */
   public Date getBirthday() 
   {
    return null;
   }
   
   /**
    * @return java.lang.String
    * @roseuid 3FD7ADA80399
    */
   public String getIne() 
   {
    return null;
   }
   
   /**
    * @return java.lang.String
    * @roseuid 3FF869BB00F5
    */
   public String toXML() 
   {
    return null;
   }
}
/**
 * 
 * 
 *  
 * Student.toXML(){
 *     return null;
 *    }
 *  
 *  
 *  
 */
