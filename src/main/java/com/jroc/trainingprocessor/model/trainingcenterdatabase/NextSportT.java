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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NextSport_t complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="NextSport_t"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Transition" type="{http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2}ActivityLap_t" minOccurs="0"/&gt;
 *         &lt;element name="Activity" type="{http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2}Activity_t"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NextSport_t", propOrder = {
    "transition",
    "activity"
})
public class NextSportT {

  @XmlElement(name = "Transition")
  protected ActivityLapT transition;
  @XmlElement(name = "Activity", required = true)
  protected ActivityT activity;

  /**
   * Gets the value of the transition property.
   *
   * @return possible object is {@link ActivityLapT }
   */
  public ActivityLapT getTransition() {
    return transition;
  }

  /**
   * Sets the value of the transition property.
   *
   * @param value allowed object is {@link ActivityLapT }
   */
  public void setTransition(ActivityLapT value) {
    this.transition = value;
  }

  /**
   * Gets the value of the activity property.
   *
   * @return possible object is {@link ActivityT }
   */
  public ActivityT getActivity() {
    return activity;
  }

  /**
   * Sets the value of the activity property.
   *
   * @param value allowed object is {@link ActivityT }
   */
  public void setActivity(ActivityT value) {
    this.activity = value;
  }

}
