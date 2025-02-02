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
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for Trackpoint_t complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Trackpoint_t"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Time" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="Position" type="{http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2}Position_t" minOccurs="0"/&gt;
 *         &lt;element name="AltitudeMeters" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="DistanceMeters" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="HeartRateBpm" type="{http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2}HeartRateInBeatsPerMinute_t" minOccurs="0"/&gt;
 *         &lt;element name="Cadence" type="{http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2}CadenceValue_t" minOccurs="0"/&gt;
 *         &lt;element name="SensorState" type="{http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2}SensorState_t" minOccurs="0"/&gt;
 *         &lt;element name="Extensions" type="{http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2}Extensions_t" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Trackpoint_t", propOrder = {
    "time",
    "position",
    "altitudeMeters",
    "distanceMeters",
    "heartRateBpm",
    "cadence",
    "sensorState",
    "extensions"
})
public class TrackpointT {

  @XmlElement(name = "Time", required = true)
  @XmlSchemaType(name = "dateTime")
  protected XMLGregorianCalendar time;
  @XmlElement(name = "Position")
  protected PositionT position;
  @XmlElement(name = "AltitudeMeters")
  protected Double altitudeMeters;
  @XmlElement(name = "DistanceMeters")
  protected Double distanceMeters;
  @XmlElement(name = "HeartRateBpm")
  protected HeartRateInBeatsPerMinuteT heartRateBpm;
  @XmlElement(name = "Cadence")
  @XmlSchemaType(name = "unsignedByte")
  protected Short cadence;
  @XmlElement(name = "SensorState")
  @XmlSchemaType(name = "token")
  protected SensorStateT sensorState;
  @XmlElement(name = "Extensions")
  protected ExtensionsT extensions;

  /**
   * Gets the value of the time property.
   *
   * @return possible object is {@link XMLGregorianCalendar }
   */
  public XMLGregorianCalendar getTime() {
    return time;
  }

  /**
   * Sets the value of the time property.
   *
   * @param value allowed object is {@link XMLGregorianCalendar }
   */
  public void setTime(XMLGregorianCalendar value) {
    this.time = value;
  }

  /**
   * Gets the value of the position property.
   *
   * @return possible object is {@link PositionT }
   */
  public PositionT getPosition() {
    return position;
  }

  /**
   * Sets the value of the position property.
   *
   * @param value allowed object is {@link PositionT }
   */
  public void setPosition(PositionT value) {
    this.position = value;
  }

  /**
   * Gets the value of the altitudeMeters property.
   *
   * @return possible object is {@link Double }
   */
  public Double getAltitudeMeters() {
    return altitudeMeters;
  }

  /**
   * Sets the value of the altitudeMeters property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setAltitudeMeters(Double value) {
    this.altitudeMeters = value;
  }

  /**
   * Gets the value of the distanceMeters property.
   *
   * @return possible object is {@link Double }
   */
  public Double getDistanceMeters() {
    return distanceMeters;
  }

  /**
   * Sets the value of the distanceMeters property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setDistanceMeters(Double value) {
    this.distanceMeters = value;
  }

  /**
   * Gets the value of the heartRateBpm property.
   *
   * @return possible object is {@link HeartRateInBeatsPerMinuteT }
   */
  public HeartRateInBeatsPerMinuteT getHeartRateBpm() {
    return heartRateBpm;
  }

  /**
   * Sets the value of the heartRateBpm property.
   *
   * @param value allowed object is {@link HeartRateInBeatsPerMinuteT }
   */
  public void setHeartRateBpm(HeartRateInBeatsPerMinuteT value) {
    this.heartRateBpm = value;
  }

  /**
   * Gets the value of the cadence property.
   *
   * @return possible object is {@link Short }
   */
  public Short getCadence() {
    return cadence;
  }

  /**
   * Sets the value of the cadence property.
   *
   * @param value allowed object is {@link Short }
   */
  public void setCadence(Short value) {
    this.cadence = value;
  }

  /**
   * Gets the value of the sensorState property.
   *
   * @return possible object is {@link SensorStateT }
   */
  public SensorStateT getSensorState() {
    return sensorState;
  }

  /**
   * Sets the value of the sensorState property.
   *
   * @param value allowed object is {@link SensorStateT }
   */
  public void setSensorState(SensorStateT value) {
    this.sensorState = value;
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

}
