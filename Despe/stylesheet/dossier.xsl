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
    <fo:block>
	      Dossier d'inscription
    </fo:block>
    <xsl:apply-templates/>
  </fo:flow>  
 </fo:page-sequence> 
</fo:root>
</xsl:template>

<!-- A series of XSLT rules that produce fo:blocks to be inserted above -->

 <xsl:template match="studentNumber">
    <fo:block text-align="justify"  space-before="0.5cm">
	Numero etudiant :
      <xsl:apply-templates/>
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

 <xsl:template match="firstname">
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