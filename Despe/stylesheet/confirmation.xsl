<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
  xmlns:fo="http://www.w3.org/1999/XSL/Format" 
  version="1.0" >

<!-- rule for the whole document: root element is page -->

<xsl:template match="inscription">

 <fo:root>

  <fo:layout-master-set>

  <!-- Definition of a single master page. It is simple (no headers etc.) -->
  <fo:simple-page-master 
			 master-name="first" 
			 margin-left="2cm"  margin-right="2cm"
			 margin-bottom="0.5cm" margin-top="0.75cm"
			 page-width="21cm" page-height="29.7cm"
			 >

   <!-- required element body -->

   <fo:region-body/>
  </fo:simple-page-master>
 </fo:layout-master-set>

  

 <!-- Definition of a page sequence -->

 <fo:page-sequence master-reference="first">
  <fo:flow flow-name="xsl-region-body" font-size="16pt" line-height="16pt">
    <fo:table>
    	<fo:table-column column-width="60%"/>
    	<fo:table-column column-width="40%"/>
    	
    	<fo:table-body>
    		<fo:table-row>
    			<fo:table-cell>
    			     <fo:external-graphic src="/home/dslg00/ndedanil/despe/pages/images/logo_blanc.gif" 
    			    					height="80pt"
                     					width="150pt"/>
                    <fo:block font-size="8pt">5, boulevard Descartes - CHAMPS SUR MARNE</fo:block>
                    <fo:block font-size="8pt">77454 MARNE-LA-VALLEE - Cedex 2</fo:block>
                </fo:table-cell>
     			<fo:table-cell background-color="silver">
    				<fo:block text-align="center">BON DE CONFIRMATION DE RENDEZ-VOUS</fo:block>
    			</fo:table-cell>
    		</fo:table-row>
    	</fo:table-body>
   
    </fo:table>
    <xsl:apply-templates/>
  </fo:flow>  
 </fo:page-sequence> 
</fo:root>
</xsl:template>

<!-- A series of XSLT rules that produce fo:blocks to be inserted above -->

 <xsl:template match="namePatronymic">
    <fo:block font-size="12pt" text-align="start" space-before="0.5cm">
    <xsl:apply-templates/></fo:block>
 </xsl:template>

 <xsl:template match="firstName">
    <fo:block font-size="12pt" text-align="start" space-before="0.5cm">
    <xsl:apply-templates/></fo:block>
 </xsl:template>

<xsl:template match="appointmentDay">
    <fo:block font-size="12pt" text-align="start" space-before="0.5cm">
	 Vous avez rendez-vous le :
    <xsl:apply-templates/></fo:block>
 </xsl:template>
 
 <xsl:template match="appointmentHour">
    <fo:block font-size="12pt" text-align="start" space-before="0.7cm">
	 a :
    <xsl:apply-templates/></fo:block>
 </xsl:template>
</xsl:stylesheet>