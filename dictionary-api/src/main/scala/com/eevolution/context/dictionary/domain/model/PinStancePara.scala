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

case class PinStancePara(pinStanceParaId: Int,
                         seqNo: Int,
                         parameterName: Option[String],
                         string: Option[String],
                         stringTo: Option[String],
                         number: Option[Int],
                         numberTo: Option[Int],
                         date: DateTime = new DateTime,
                         dateTo: DateTime = new DateTime,
                         info: Option[String],
                         infoTo: Option[String],
                         created: DateTime = DateTime.now,
                         createdBy: Int,
                         updated: DateTime = DateTime.now,
                         updatedBy: Int,
                         isActive: Boolean,
                         uuId: Option[String]
                        ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type

  override def Id: Int = pinStanceParaId

  override val entityName: String = "AD_PinStancePara"
  override val identifier: String = "AD_PinStancePara_ID"
}

object PinStancePara {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[PinStancePara]
  def create(pinStanceParaId: Int,
             seqNo: Int,
             parameterName: String,
             string: String,
             stringTo: String,
             number: Int,
             numberTo: Int,
             date: DateTime,
             dateTo: DateTime,
             info: String,
             infoTo: String,
             created: DateTime,
             createdBy: Int,
             updated: DateTime,
             updatedBy: Int,
             isActive: Boolean,
             uuId: String) = PinStancePara(pinStanceParaId, seqNo, None, None, None, None, None, date, dateTo,
    None, None, created, createdBy, updated, updatedBy, isActive, None)
}