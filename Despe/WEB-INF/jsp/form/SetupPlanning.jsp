<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/app.tld" prefix="app" %>

<app:checkLogon>
	<h1>
		<br><bean:message key="title.user.setupplanning" />
	</h1>
	
	<html:form action="/setupConf">
		<table>
			<tr>
				<td colspan="3" >
					<b><font size="3" align="left">Periode</font> :</b><br>
				</td>
				</tr>
			<tr>
				<td>
					<font size="2">du</font>
					<html:text property="fromDate" size="10" maxlength="20" />
					<font size="2">au</font>
				</td>
				<td>
					<html:text property="toDate" size="10" maxlength="20" />
				 </td>
			</tr>
			<tr>
				 	<td> <html:errors property="fromDate"/> </td>
			 		<td> <html:errors property="toDate"/> </td>
			 </tr>
			<tr><td>&nbsp</td></tr>
			 <tr>
			  	<td colspan="3"><b><font size="3">Horaire :</font></b></td>
			 </tr>
			 <tr>
			  	<td><font size="2">Matin :</font></td>
		 		<td>
		 			<font size="2">de</font>
					<html:text property="beginAM" size="10" maxlength="20" />
					<font size="2">a</font>
				</td>
				<td>
			 		<html:text property="endAM" size="10" maxlength="20" />
			 	</td>
			 	</tr>
			 	<tr>
			 			<td></td>
			 		 	<td> <html:errors property="beginAM"/> </td>
	 		 		 	<td> <html:errors property="endAM"/> </td>
			 </tr>
			 <tr>
		  		<td><font size="2">Apres midi :</font></td>
		  		<td><font size="2">de	
			  		<html:text property="beginPM" size="10" maxlength="20" />
			   		<font size="2">a</font>
		      	</td>
		      <td>
			 	<html:text property="endPM" size="10" maxlength="20" />
			 </td>
			  </tr>
			 <tr>
			 <td></td>
	 	 	<td> <html:errors property="beginPM"/> </td>
 		 	<td> <html:errors property="endPM"/> </td>
			 <tr><td>&nbsp</td></tr>
		   	<tr>
		   		  	<td colspan="3"><b><font size="3">Duree du rendez vous:<b></td>
		   	</tr>
		   			<td>
		   				<font size="2">Matin</font>
			   			 <html:text property="rdvDurationAM" size="10" maxlength="20" />
			   		</td>
		     		<td>
		   				<font size="2">Apres midi</font>
		   				<html:text property="rdvDurationPM" size="10" maxlength="20" />
		   			</td>
		   	  </tr>
			 <tr>
		   			 	<td> <html:errors property="rdvDurationAM"/> </td>
 		 				<td> <html:errors property="rdvDurationPM"/> </td>
		   	</tr>
		   	<tr><td>&nbsp</td></tr>
		    <tr>
			  	<td colspan="3"><b><font size="3">Nombre de correcteur: </font></b></td>
			</tr>
			<tr>
			    <td>
			   		<font size="2">Matin</font>
			   		 <html:text property="nbCorrectorAM" size="10" maxlength="20" />
			    </td>
			    <td>
		   			<font size="2">Apres midi</font>
		   			<html:text property="nbCorrectorPM" size="10" maxlength="20" />
		   		</td>
		   	 </tr>
			 <tr>
		   		<td> <html:errors property="nbCorrectorAM"/> </td>
 		 		<td> <html:errors property="nbCorrectorPM"/> </td>
		   	</tr>
		   	<tr><td>&nbsp</td></tr>
			<tr>      
		 		<td colspan="3"><b><font size="3">Nombre d'etudiants ravel:</font></b></td>
		 	</tr>
		 	<tr>
		  		<td>
		  			<font size="2">Matin</font>
			  		<html:text property="nbRavelAM" size="10" maxlength="20" />
			  	</td>
			  	<td>
			 		<font size="2">Apres midi</font>
				 	<html:text property="nbRavelPM" size="10" maxlength="20" />
				 </td>
				 </tr>
			 <tr>
				<td> <html:errors property="nbRavelAM"/> </td>
 		 		<td> <html:errors property="nbRavelPM"/> </td>
			</tr>
			   	<tr><td>&nbsp</td></tr>
			<tr>
		 	  <td colspan="3" align="center"><html:submit value="Ok"/></td>
		 	 </tr>
		 </table>
	</html:form>

</app:checkLogon>