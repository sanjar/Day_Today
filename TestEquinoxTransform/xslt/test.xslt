<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fn="http://www.w3.org/2005/xpath-functions">


	<xsl:template match="extension[@point='org.eclipse.ui.views']/view[@id='com.test.sample.plugin.views.SampleView']">
	</xsl:template>
	<!-- identity transformation - copy everything (nodes and attributes) without 
		modifications -->
	<xsl:template match="node()|@*">
		<xsl:copy>
			<xsl:apply-templates select="node()|@*" />
		</xsl:copy>
	</xsl:template>

</xsl:stylesheet>