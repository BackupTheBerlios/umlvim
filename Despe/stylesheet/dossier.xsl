<?xml version="1.0"?>

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
    			<fo:block text-align="center">ANNEE UNIVERSITAIRE 2003/2004
    			DOSSIER D'INSCRIPTION</fo:block>
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

 <xsl:template match="studentNumber">
    <fo:block text-align="left"  space-before="0.5cm" font-size="10pt" font-weight="bold">
	Numero etudiant :
      <xsl:apply-templates/>
      (reserve a l'administration)
    </fo:block>
 </xsl:template>

 <xsl:template match="name">
    <fo:block text-align="justify"  space-before="0.5cm">
	Nom :
    <xsl:apply-templates/></fo:block>
 </xsl:template>
 
 <xsl:template match="namePatronymic">
    <fo:block font-size="12pt" text-align="start" space-before="0.7cm" font-style="italic">
    	Nom patronymique :
    <xsl:apply-templates/></fo:block>
 </xsl:template>

 <xsl:template match="firstName">
    <fo:block font-size="12pt" text-align="start" space-before="0.7cm" font-style="italic">
	 Prenom :
    <xsl:apply-templates/></fo:block>
 </xsl:template>

 <xsl:template match="INE">
    <fo:block font-size="12pt" text-align="start" space-before="0.7cm" font-style="italic">
	 Num INE :
    <xsl:apply-templates/></fo:block>
 </xsl:template>

 <xsl:template match="birthdate">
    <fo:block font-size="12pt" text-align="start" space-before="0.7cm" font-style="italic">
	 Date de naissance :
    <xsl:apply-templates/></fo:block>
 </xsl:template>

 <xsl:template match="birthplace">
    <fo:block font-size="12pt" text-align="start" space-before="0.7cm" font-style="italic">
	 Lieu de naissance :
    <xsl:apply-templates/></fo:block>
 </xsl:template>

 <xsl:template match="sex">
    <fo:block font-size="12pt" text-align="start" space-before="0.7cm" font-style="italic">
	 Sexe :
    <xsl:apply-templates/></fo:block>
 </xsl:template>

 <xsl:template match="nationality">
    <fo:block font-size="12pt" text-align="start" space-before="0.7cm" font-style="italic">
	 Nationalite :
    <xsl:apply-templates/></fo:block>
 </xsl:template>

 <xsl:template match="famSituation">
    <fo:block font-size="12pt" text-align="start" space-before="0.7cm" font-style="italic">
	 Situation familiale :
    <xsl:apply-templates/></fo:block>
 </xsl:template>

 <xsl:template match="milSituation">
    <fo:block font-size="12pt" text-align="start" space-before="0.7cm" font-style="italic">
	 Situation militaire :
    <xsl:apply-templates/></fo:block>
 </xsl:template>

</xsl:stylesheet>