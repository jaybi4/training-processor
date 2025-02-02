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
 * <p>Java class for CustomHeartRateZone_t complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="CustomHeartRateZone_t"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2}Zone_t"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Low" type="{http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2}HeartRateValue_t"/&gt;
 *         &lt;element name="High" type="{http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2}HeartRateValue_t"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustomHeartRateZone_t", propOrder = {
    "low",
    "high"
})
public class CustomHeartRateZoneT
    extends ZoneT {

  @XmlElement(name = "Low", required = true)
  protected HeartRateValueT low;
  @XmlElement(name = "High", required = true)
  protected HeartRateValueT high;

  /**
   * Gets the value of the low property.
   *
   * @return possible object is {@link HeartRateValueT }
   */
  public HeartRateValueT getLow() {
    return low;
  }

  /**
   * Sets the value of the low property.
   *
   * @param value allowed object is {@link HeartRateValueT }
   */
  public void setLow(HeartRateValueT value) {
    this.low = value;
  }

  /**
   * Gets the value of the high property.
   *
   * @return possible object is {@link HeartRateValueT }
   */
  public HeartRateValueT getHigh() {
    return high;
  }

  /**
   * Sets the value of the high property.
   *
   * @param value allowed object is {@link HeartRateValueT }
   */
  public void setHigh(HeartRateValueT value) {
    this.high = value;
  }

}
