<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">
 <html>
 <body>
   <h2>??????:XSLT</h2>
   <table border="1">
     <tr bgcolor="#9acd32">
       <th>??</th>
       <th>??</th>
     </tr>
     <tr>
      <td><xsl:value-of select="email/name"/></td>
      <td><xsl:value-of select="email/code"/></td>
     </tr>
   </table>
 </body>
 </html>
</xsl:template>

</xsl:stylesheet>