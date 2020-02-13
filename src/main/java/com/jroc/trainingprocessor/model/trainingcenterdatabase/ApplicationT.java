//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.02.13 at 10:45:13 AM GMT 
//


package com.jroc.trainingprocessor.model.trainingcenterdatabase;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * Identifies a PC software application.
 *
 * <p>Java class for Application_t complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Application_t"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2}AbstractSource_t"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Build" type="{http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2}Build_t"/&gt;
 *         &lt;element name="LangID" type="{http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2}LangID_t"/&gt;
 *         &lt;element name="PartNumber" type="{http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2}PartNumber_t"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Application_t", propOrder = {
    "build",
    "langID",
    "partNumber"
})
public class ApplicationT
    extends AbstractSourceT {

  @XmlElement(name = "Build", required = true)
  protected BuildT build;
  @XmlElement(name = "LangID", required = true)
  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  @XmlSchemaType(name = "token")
  protected String langID;
  @XmlElement(name = "PartNumber", required = true)
  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  @XmlSchemaType(name = "token")
  protected String partNumber;

  /**
   * Gets the value of the build property.
   *
   * @return possible object is {@link BuildT }
   */
  public BuildT getBuild() {
    return build;
  }

  /**
   * Sets the value of the build property.
   *
   * @param value allowed object is {@link BuildT }
   */
  public void setBuild(BuildT value) {
    this.build = value;
  }

  /**
   * Gets the value of the langID property.
   *
   * @return possible object is {@link String }
   */
  public String getLangID() {
    return langID;
  }

  /**
   * Sets the value of the langID property.
   *
   * @param value allowed object is {@link String }
   */
  public void setLangID(String value) {
    this.langID = value;
  }

  /**
   * Gets the value of the partNumber property.
   *
   * @return possible object is {@link String }
   */
  public String getPartNumber() {
    return partNumber;
  }

  /**
   * Sets the value of the partNumber property.
   *
   * @param value allowed object is {@link String }
   */
  public void setPartNumber(String value) {
    this.partNumber = value;
  }

}
