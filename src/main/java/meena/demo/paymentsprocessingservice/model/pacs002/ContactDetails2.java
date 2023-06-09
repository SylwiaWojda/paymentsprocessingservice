/**
 * Copyright 2019 ForgeRock AS.
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package meena.demo.paymentsprocessingservice.model.pacs002;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for ContactDetails2 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ContactDetails2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="NmPrfx" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.09}NamePrefix1Code" minOccurs="0"/>
 *         &lt;element name="Nm" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.09}Max140Text" minOccurs="0"/>
 *         &lt;element name="PhneNb" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.09}PhoneNumber" minOccurs="0"/>
 *         &lt;element name="MobNb" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.09}PhoneNumber" minOccurs="0"/>
 *         &lt;element name="FaxNb" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.09}PhoneNumber" minOccurs="0"/>
 *         &lt;element name="EmailAdr" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.09}Max2048Text" minOccurs="0"/>
 *         &lt;element name="Othr" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.09}Max35Text" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ContactDetails2", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.09", propOrder = {
    "nmPrfx",
    "nm",
    "phneNb",
    "mobNb",
    "faxNb",
    "emailAdr",
    "othr"
})
public class ContactDetails2 {

    @XmlElement(name = "NmPrfx", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.09")
    @XmlSchemaType(name = "string")
    protected NamePrefix1Code nmPrfx;
    @XmlElement(name = "Nm", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.09")
    protected String nm;
    @XmlElement(name = "PhneNb", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.09")
    protected String phneNb;
    @XmlElement(name = "MobNb", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.09")
    protected String mobNb;
    @XmlElement(name = "FaxNb", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.09")
    protected String faxNb;
    @XmlElement(name = "EmailAdr", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.09")
    protected String emailAdr;
    @XmlElement(name = "Othr", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.09")
    protected String othr;

    /**
     * Gets the value of the nmPrfx property.
     * 
     * @return
     *     possible object is
     *     {@link NamePrefix1Code }
     *     
     */
    public NamePrefix1Code getNmPrfx() {
        return nmPrfx;
    }

    /**
     * Sets the value of the nmPrfx property.
     * 
     * @param value
     *     allowed object is
     *     {@link NamePrefix1Code }
     *     
     */
    public void setNmPrfx(NamePrefix1Code value) {
        this.nmPrfx = value;
    }

    /**
     * Gets the value of the nm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNm() {
        return nm;
    }

    /**
     * Sets the value of the nm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNm(String value) {
        this.nm = value;
    }

    /**
     * Gets the value of the phneNb property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhneNb() {
        return phneNb;
    }

    /**
     * Sets the value of the phneNb property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhneNb(String value) {
        this.phneNb = value;
    }

    /**
     * Gets the value of the mobNb property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMobNb() {
        return mobNb;
    }

    /**
     * Sets the value of the mobNb property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMobNb(String value) {
        this.mobNb = value;
    }

    /**
     * Gets the value of the faxNb property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFaxNb() {
        return faxNb;
    }

    /**
     * Sets the value of the faxNb property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFaxNb(String value) {
        this.faxNb = value;
    }

    /**
     * Gets the value of the emailAdr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmailAdr() {
        return emailAdr;
    }

    /**
     * Sets the value of the emailAdr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmailAdr(String value) {
        this.emailAdr = value;
    }

    /**
     * Gets the value of the othr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOthr() {
        return othr;
    }

    /**
     * Sets the value of the othr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOthr(String value) {
        this.othr = value;
    }

}
