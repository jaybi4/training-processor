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
 * <p>Java class for HeartRateBelow_t complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="HeartRateBelow_t"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2}Duration_t"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="HeartRate" type="{http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2}HeartRateValue_t"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HeartRateBelow_t", propOrder = {
    "heartRate"
})
public class HeartRateBelowT
    extends DurationT {

  @XmlElement(name = "HeartRate", required = true)
  protected HeartRateValueT heartRate;

  /**
   * Gets the value of the heartRate property.
   *
   * @return possible object is {@link HeartRateValueT }
   */
  public HeartRateValueT getHeartRate() {
    return heartRate;
  }

  /**
   * Sets the value of the heartRate property.
   *
   * @param value allowed object is {@link HeartRateValueT }
   */
  public void setHeartRate(HeartRateValueT value) {
    this.heartRate = value;
  }

}
