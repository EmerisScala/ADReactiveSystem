package com.eevolution.context.dictionary.domain.model

import ai.x.play.json.Jsonx
import com.eevolution.context.dictionary.api.{ActiveEnabled, DomainModel, Identifiable, Traceable}
import org.joda.time.DateTime

/**
  * Copyright (C) 2003-2017, e-Evolution Consultants S.A. , http://www.e-evolution.com
  * This program is free software: you can redistribute it and/or modify
  * it under the terms of the GNU General Public License as published by
  * the Free Software Foundation, either version 3 of the License, or
  * (at your option) any later version.
  * This program is distributed in the hope that it will be useful,
  * but WITHOUT ANY WARRANTY; without even the implied warranty of
  * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  * GNU General Public License for more details.
  * You should have received a copy of the GNU General Public License
  * along with this program.  If not, see <http://www.gnu.org/licenses/>.
  * Email: emeris.hernandez@e-evolution.com, http://www.e-evolution.com , http://github.com/e-Evolution
  * Created by emeris.hernandez@e-evolution.com , www.e-evolution.com
  */

/**
  * Alert Processor Log Entity
  * @param alertProcessorLogId Alert Processor Log ID
  * @param alertProcessorId Alert Processor ID
  * @param isActive Is Active
  * @param created Created
  * @param createdBy Created By
  * @param updated Updated
  * @param updatedBy Updated By
  * @param isError Is Error
  * @param summary Summary
  * @param reference Reference
  * @param description Description
  * @param textMsg Text Msg
  * @param binaryData Binary Data
  * @param uuid UUID
  */

case class AlertProcessorLog(alertProcessorLogId: Int,
                             alertProcessorId: Int,
                             tenantId: Int,
                             organizationId: Int,
                             isActive: Boolean = true,
                             created: DateTime = DateTime.now(),
                             createdBy: Int,
                             updated: DateTime = DateTime.now(),
                             updatedBy: Int,
                             isError: Boolean = false,
                             summary: Option[String],
                             reference: Option[String],
                             description: Option[String],
                             textMsg: Option[String],
                             binaryData: Option[String],
                             uuid: Option[String]
                            ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type

  override def Id: Int = alertProcessorLogId

  override val entityName: String = "AD_AlertProcessorLog"
  override val identifier: String = "AD_AlertProcessorLog_ID"
}

object AlertProcessorLog  {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[AlertProcessorLog]
  def create(alertProcessorLogId: Int,
             alertProcessorId: Int,
             tenantId: Int,
             organizationId: Int,
             isActive: Boolean,
             created: DateTime,
             createdBy: Int,
             updated: DateTime,
             updatedBy: Int,
             isError: Boolean,
             summary: String,
             reference: String,
             description: String,
             textMsg:String,
             binaryData: String,
             uuid: String) = AlertProcessorLog(alertProcessorLogId, alertProcessorId, tenantId, organizationId,
    isActive, created, createdBy, updated, updatedBy, isError, None, None, None, None, None, None)
}


