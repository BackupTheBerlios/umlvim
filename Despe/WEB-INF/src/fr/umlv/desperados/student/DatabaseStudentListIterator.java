//Source file: C:\\DOCUMENTS AND SETTINGS\\NCUVELIE\\MES DOCUMENTS\\GÉNIE LOG\\SRC\\fr\\umlv\\desperados\\student\\DatabaseStudentListIterator.java

package fr.umlv.desperados.student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import fr.umlv.desperados.database.DatabaseAbstractListIterator;

/**
 * Provides a implementation of java.util.ListIterator interface to iterate the 
 * elements contained by a DatabaseStudentList.
 */
final class DatabaseStudentListIterator extends DatabaseAbstractListIterator {

	private Properties prop;
	/**
	 * Constructor.
	 * 
	 * @param rs the ResultSet containing a Student list.
	 * @roseuid 3FE188330307
	 */
	DatabaseStudentListIterator(ResultSet rs, Properties propertiesPath) {
		super(rs);
		prop= propertiesPath;
		}

	/**
		* Constructor.
		* 
		* @param rs the ResultSet containing a User list.
		* @roseuid 3FE2F884035B
		*/
	DatabaseStudentListIterator(
		ResultSet rs,
		int index,
		Properties propertiesPath) {
		super(rs, index);
		prop =propertiesPath;
}

	public Object next() {
		index++;
		return rowToStudent();
	}

	/**
		* @return java.lang.Object
		* @roseuid 3FF869B80140
		*/
	public Object previous() {
		index--;
		return rowToStudent();
	}

	private Student rowToStudent() {
		int current = -1;
		Student student = null;
		synchronized (rs) {
			try {
				current = rs.getRow();
				rs.absolute(index);
				student =
					new Student(rs.getInt(prop.get("studentId").toString()));
				student.setName(rs.getString(prop.get("name").toString()));
				student.setBirthday(
					rs.getDate(prop.get("birthday").toString()));
				student.setFirstname1(
					rs.getString(prop.get("firstname1").toString()));
				student.setIne(rs.getString(prop.get("ine").toString()));
				student.setWasToUmlvLastYear(
					rs.getBoolean((prop.get("wasToUmlvLastYear").toString())));
				student.setPatronymicName(
					rs.getString(prop.get("patronymicName").toString()));
				student.setFirstname2(
					rs.getString(prop.get("firstname2").toString()));
				student.setTownOfBirth(
					rs.getString(prop.get("townOfBirth").toString()));
				student.setSex(rs.getString(prop.get("sex").toString()));
				student.setFirstInsSupEduc(
					rs.getString(prop.get("firstInsSupEduc").toString()));
				student.setFirstInsFrenchUniv(
					rs.getString(prop.get("firstInsFrenchUniv").toString()));
				student.setEstaFirstInsFrenchUniv(
					rs.getString(
						prop.get("estaFirstInsFrenchUniv").toString()));
				student.setFirstInsEstablishment(
					rs.getString(prop.get("firstInsEstablishment").toString()));
				student.setBacYear(
					rs.getString(prop.get("bacYear").toString()));
				student.setEstablishmentBacObtaining(
					rs.getString(
						prop.get("establishmentBacObtaining").toString()));
				student.setForeignCityBac(
					rs.getString(prop.get("foreignCityBac").toString()));
				student.setHaveFixAddFr(
					rs.getBoolean(prop.get("haveFixAddFr").toString()));
				student.setNumFixAdd(
					rs.getString(prop.get("numFixAdd").toString()));
				student.setStreetFixAdd(
					rs.getString(prop.get("streetFixAdd").toString()));
				student.setBuildingFixAdd(
					rs.getString(prop.get("buildingFixAdd").toString()));
				student.setForeignCityFixAdd(
					rs.getString(prop.get("foreignCityFixAdd").toString()));
				student.setPhoneFixAdd(
					rs.getString(prop.get("phoneFixAdd").toString()));
				student.setHaveTmpAddFr(
					rs.getBoolean(prop.getProperty("haveTmpAddFr").toString()));
				student.setNumTmpAdd(
					rs.getString(prop.get("numTmpAdd").toString()));
				student.setStreetTmpAdd(
					rs.getString(prop.get("streetTmpAdd").toString()));
				student.setBuildingTmpAdd(
					rs.getString(prop.get("buildingTmpAdd").toString()));
				student.setCityTmpAdd(
					rs.getString(prop.get("cityTmpAdd").toString()));
				student.setPhoneTmpAdd(
					rs.getString(prop.get("phoneTmpAdd").toString()));
				student.setEmployed(
					rs.getBoolean(prop.get("isEmployed").toString()));
				student.setStudEmplType(
					rs.getString(prop.get("studEmplType").toString()));
				student.setHeadFamProf(
					rs.getString(prop.get("headFamProf").toString()));
				student.setNatSport(
					rs.getBoolean(prop.get("isNatSport").toString()));
				student.setRegSport(
					rs.getBoolean(prop.get("isRegSport").toString()));
				student.setPractisedSport(
					rs.getString(prop.get("practisedSport").toString()));
				student.setHaveFinancialAss(
					rs.getBoolean(prop.get("haveFinancialAss").toString()));
				student.setInternaExchOriEstab(
					rs.getString(prop.get("internaExchOriEstab").toString()));
				student.setInternaExchRecEstab(
					rs.getString(prop.get("internaExchRecEstab").toString()));
				student.setLastAttendedEstab(
					rs.getString(prop.get("lastAttendedEstab").toString()));
				student.setLastAttendedEstabYear(
					rs.getString(prop.get("lastAttendedEstabYear").toString()));
				student.setPrecedentYearEstab(
					rs.getString(prop.get("precedentYearEstab").toString()));
				student.setOtherInsEstab(
					rs.getString(prop.get("otherInsEstab").toString()));
				student.setPrincCycleInsNum(
					rs.getInt(prop.get("princCycleInsNum").toString()));
				student.setComplCycleInsNum(
					rs.getInt(prop.get("complCycleInsNum").toString()));
				student.setPrincDiplInsNum(
					rs.getInt(prop.get("princDiplInsNum").toString()));
				student.setComplDipInsNum(
					rs.getInt(prop.get("complDipInsNum").toString()));
				student.setPrincInsYearNum(
					rs.getInt(prop.get("princInsYearNum").toString()));
				student.setCompInsYearNum(
					rs.getInt(prop.get("compInsYearNum").toString()));
				student.setStockBrokerNum(
					rs.getInt(prop.get("stockBrokerNum").toString()));
				student.setSocialSecurityNum(
					rs.getString(prop.get("socialSecurityNum").toString()));
				student.setFatherName(
					rs.getString(prop.get("fatherName").toString()));
				student.setFatherFirstName(
					rs.getString(prop.get("fatherFirstName").toString()));
				student.setMotherPatronymicName(
					rs.getString(prop.get("motherPatronymicName").toString()));
				student.setMotherName(
					rs.getString(prop.get("motherName").toString()));
				student.setInsuranceCivilLiability(
					rs.getBoolean(
						prop
							.getProperty("insuranceCivilLiability")
							.toString()));
				student.setAppointmentDate(
					rs.getTimestamp(prop.get("appointmentDate").toString()));
				student.setWorkedShareId(
					rs.getInt(prop.get("workedShareId").toString()));
				student.setFinancialAssistanceId(
					rs.getString(prop.get("financialAssistanceId").toString()));
				student.setSocialEconomicCategoryId(
					rs.getInt(prop.get("socialEconomicCategoryId").toString()));
				student.setMLVDiplomaId(
					rs.getInt(prop.get("MLVDiplomaId").toString()));
				student.setBaccalaureatId(
					rs.getString(prop.get("baccalaureatId").toString()));
				student.setLodgingTypeId(
					rs.getInt(prop.get("lodgingTypeId").toString()));
				student.setInscriptionModeId(
					rs.getInt(prop.get("inscriptionModeId").toString()));
				student.setInscriptionTypeId(
					rs.getInt(prop.get("inscriptionTypeId").toString()));
				student.setCenterPaymentId(
					rs.getInt(prop.get("centerPaymentId").toString()));
				student.setInternationalExchangeTypeId(
					rs.getInt(
						prop
							.getProperty("internationalExchangeTypeId")
							.toString()));
				student.setMutualInsuranceCompanyId(
					rs.getInt(prop.get("mutualInsuranceCompanyId").toString()));
				student.setSocialSecurityId(
					rs.getInt(prop.get("socialSecurityId").toString()));
				student.setPaymentModeId(
					rs.getInt(prop.get("paymentModeId").toString()));
				student.setPurseId(rs.getInt(prop.get("purseId").toString()));
				student.setLastDiplomaTypeId(
					rs.getString(prop.get("lastDiplomaTypeId").toString()));
				student.setBacMentionId(
					rs.getInt(prop.get("bacMentionId").toString()));
				student.setBaccalaureatEstablishmentTypeId(
					rs.getInt(
						prop
							.get("baccalaureatEstablishmentTypeId")
							.toString()));
				student.setLastEstabTypeId(
					rs.getInt(prop.getProperty("lastEstabTypeId").toString()));
				student.setMilitarySituationId(
					rs.getInt(prop.get("militarySituationId").toString()));
				student.setFixeAddFrenchCityId(
					rs.getInt(prop.get("fixeAddFrenchCityId").toString()));
				student.setTmpAdressFrenchCityId(
					rs.getInt(prop.get("tmpAdressFrenchCityId").toString()));
				student.setFrenchBirthplaceId(
					rs.getInt(prop.get("frenchBirthplaceId").toString()));
				student.setFrenchBacCityId(
					rs.getInt(prop.get("frenchBacCityId").toString()));
				student.setFirstInsFrUnivDepId(
					rs.getInt(prop.get("firstInsFrUnivDepId").toString()));
				student.setLastAttendedEstabPlaceId(
					rs.getInt(prop.get("lastAttendedEstabPlaceId").toString()));
				student.setPrecYearEstabPlaceId(
					rs.getInt(prop.get("precYearEstabPlaceId").toString()));
				student.setOtherEstabInsPlaceId(
					rs.getInt(prop.get("otherEstabInsPlaceId").toString()));
				student.setBacObtainingCountryId(
					rs.getInt(prop.get("bacObtainingCountryId").toString()));
				student.setNationalityId(
					rs.getInt(prop.get("nationalityId").toString()));
				student.setIntExchPlaceId(
					rs.getInt(prop.get("intExchPlaceId").toString()));
				student.setForeignBirthplaceId(
					rs.getInt(prop.get("foreignBirthplaceId").toString()));
				student.setFixeAddCountryId(
					rs.getInt(prop.get("fixeAddCountryId").toString()));
				student.setTmpAddCountryId(
					rs.getInt(prop.get("tmpAddCountryId").toString()));
				student.setPrecYearSitTypeId(
					rs.getString(prop.get("precYearSitTypeId").toString()));
				student.setFamSituation(
					rs.getInt(prop.get("famSituation").toString()));
				student.setMotifProlSocSec(
					rs.getString(prop.get("motifProlSocSec").toString()));
				student.setNoSocSecStu(
					rs.getBoolean(prop.getProperty("noSocSecStu").toString()));
				student.setOtherEtabIns(
					rs.getInt(prop.get("otherEtabIns").toString()));
				student.setHeadFamJob(
					rs.getInt(prop.get("headFamJob").toString()));
				student.setMLVDiplomaComplId(
					rs.getInt(prop.get("MLVDiplomaComplId").toString()));
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (current != -1) {
						rs.absolute(current);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
		return student;
	}

}
/**
 * 
 * 
 *  
 * DatabaseStudentListIterator.next(){
 *     return null;
 *    }
 *  
 *  
 * DatabaseStudentListIterator.set(Object){
 *     
 *    }
 *  
 *  
 * DatabaseStudentListIterator.hasNext(){
 *     return true;
 *    }
 *  
 *  
 * DatabaseStudentListIterator.nextIndex(){
 *     return 0;
 *    }
 *  
 *  
 * DatabaseStudentListIterator.previousIndex(){
 *     return 0;
 *    }
 *  
 *  
 * DatabaseStudentListIterator.hasPrevious(){
 *     return true;
 *    }
 *  
 *  
 * DatabaseStudentListIterator.previous(){
 *     return null;
 *    }
 *  
 *  
 * DatabaseStudentListIterator.remove(){
 *     
 *    }
 *  
 *  
 * DatabaseStudentListIterator.add(Object){
 *     
 *    }
 *  
 *  
 *  
 */
