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

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ClearingChannel2Code.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ClearingChannel2Code">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="RTGS"/>
 *     &lt;enumeration value="RTNS"/>
 *     &lt;enumeration value="MPNS"/>
 *     &lt;enumeration value="BOOK"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ClearingChannel2Code", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.09")
@XmlEnum
public enum ClearingChannel2Code {

    RTGS,
    RTNS,
    MPNS,
    BOOK;

    public String value() {
        return name();
    }

    public static ClearingChannel2Code fromValue(String v) {
        return valueOf(v);
    }

}
