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


/**
 * <p>Java class for Version_t complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Version_t"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="VersionMajor" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/&gt;
 *         &lt;element name="VersionMinor" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/&gt;
 *         &lt;element name="BuildMajor" type="{http://www.w3.org/2001/XMLSchema}unsignedShort" minOccurs="0"/&gt;
 *         &lt;element name="BuildMinor" type="{http://www.w3.org/2001/XMLSchema}unsignedShort" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Version_t", propOrder = {
    "versionMajor",
    "versionMinor",
    "buildMajor",
    "buildMinor"
})
public class VersionT {

  @XmlElement(name = "VersionMajor")
  @XmlSchemaType(name = "unsignedShort")
  protected int versionMajor;
  @XmlElement(name = "VersionMinor")
  @XmlSchemaType(name = "unsignedShort")
  protected int versionMinor;
  @XmlElement(name = "BuildMajor")
  @XmlSchemaType(name = "unsignedShort")
  protected Integer buildMajor;
  @XmlElement(name = "BuildMinor")
  @XmlSchemaType(name = "unsignedShort")
  protected Integer buildMinor;

  /**
   * Gets the value of the versionMajor property.
   */
  public int getVersionMajor() {
    return versionMajor;
  }

  /**
   * Sets the value of the versionMajor property.
   */
  public void setVersionMajor(int value) {
    this.versionMajor = value;
  }

  /**
   * Gets the value of the versionMinor property.
   */
  public int getVersionMinor() {
    return versionMinor;
  }

  /**
   * Sets the value of the versionMinor property.
   */
  public void setVersionMinor(int value) {
    this.versionMinor = value;
  }

  /**
   * Gets the value of the buildMajor property.
   *
   * @return possible object is {@link Integer }
   */
  public Integer getBuildMajor() {
    return buildMajor;
  }

  /**
   * Sets the value of the buildMajor property.
   *
   * @param value allowed object is {@link Integer }
   */
  public void setBuildMajor(Integer value) {
    this.buildMajor = value;
  }

  /**
   * Gets the value of the buildMinor property.
   *
   * @return possible object is {@link Integer }
   */
  public Integer getBuildMinor() {
    return buildMinor;
  }

  /**
   * Sets the value of the buildMinor property.
   *
   * @param value allowed object is {@link Integer }
   */
  public void setBuildMinor(Integer value) {
    this.buildMinor = value;
  }

}
