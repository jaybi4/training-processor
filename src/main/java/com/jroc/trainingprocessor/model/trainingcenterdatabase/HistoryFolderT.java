//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.02.13 at 10:45:13 AM GMT 
//


package com.jroc.trainingprocessor.model.trainingcenterdatabase;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HistoryFolder_t complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="HistoryFolder_t"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Folder" type="{http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2}HistoryFolder_t" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="ActivityRef" type="{http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2}ActivityReference_t" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="Week" type="{http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2}Week_t" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="Notes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Extensions" type="{http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2}Extensions_t" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="Name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HistoryFolder_t", propOrder = {
    "folder",
    "activityRef",
    "week",
    "notes",
    "extensions"
})
public class HistoryFolderT {

  @XmlElement(name = "Folder")
  protected List<HistoryFolderT> folder;
  @XmlElement(name = "ActivityRef")
  protected List<ActivityReferenceT> activityRef;
  @XmlElement(name = "Week")
  protected List<WeekT> week;
  @XmlElement(name = "Notes")
  protected String notes;
  @XmlElement(name = "Extensions")
  protected ExtensionsT extensions;
  @XmlAttribute(name = "Name", required = true)
  protected String name;

  /**
   * Gets the value of the folder property.
   *
   * <p>
   * This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the folder property.
   *
   * <p>
   * For example, to add a new item, do as follows:
   * <pre>
   *    getFolder().add(newItem);
   * </pre>
   *
   *
   * <p>
   * Objects of the following type(s) are allowed in the list {@link HistoryFolderT }
   */
  public List<HistoryFolderT> getFolder() {
    if (folder == null) {
      folder = new ArrayList<HistoryFolderT>();
    }
    return this.folder;
  }

  /**
   * Gets the value of the activityRef property.
   *
   * <p>
   * This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the activityRef property.
   *
   * <p>
   * For example, to add a new item, do as follows:
   * <pre>
   *    getActivityRef().add(newItem);
   * </pre>
   *
   *
   * <p>
   * Objects of the following type(s) are allowed in the list {@link ActivityReferenceT }
   */
  public List<ActivityReferenceT> getActivityRef() {
    if (activityRef == null) {
      activityRef = new ArrayList<ActivityReferenceT>();
    }
    return this.activityRef;
  }

  /**
   * Gets the value of the week property.
   *
   * <p>
   * This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the week property.
   *
   * <p>
   * For example, to add a new item, do as follows:
   * <pre>
   *    getWeek().add(newItem);
   * </pre>
   *
   *
   * <p>
   * Objects of the following type(s) are allowed in the list {@link WeekT }
   */
  public List<WeekT> getWeek() {
    if (week == null) {
      week = new ArrayList<WeekT>();
    }
    return this.week;
  }

  /**
   * Gets the value of the notes property.
   *
   * @return possible object is {@link String }
   */
  public String getNotes() {
    return notes;
  }

  /**
   * Sets the value of the notes property.
   *
   * @param value allowed object is {@link String }
   */
  public void setNotes(String value) {
    this.notes = value;
  }

  /**
   * Gets the value of the extensions property.
   *
   * @return possible object is {@link ExtensionsT }
   */
  public ExtensionsT getExtensions() {
    return extensions;
  }

  /**
   * Sets the value of the extensions property.
   *
   * @param value allowed object is {@link ExtensionsT }
   */
  public void setExtensions(ExtensionsT value) {
    this.extensions = value;
  }

  /**
   * Gets the value of the name property.
   *
   * @return possible object is {@link String }
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the value of the name property.
   *
   * @param value allowed object is {@link String }
   */
  public void setName(String value) {
    this.name = value;
  }

}
