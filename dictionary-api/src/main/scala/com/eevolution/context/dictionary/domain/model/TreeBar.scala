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
  * Tree Bar Entity
  * @param treeBarId Tree Bar ID
  * @param userId User ID
  * @param nodeId Node ID
  * @param isActive Is Active
  * @param created Created
  * @param createdBy Created By
  * @param updated Updated
  * @param updatedBy Updated By
  * @param uuid UUID
  */

case class TreeBar(treeBarId: Int,
              userId: Int,
              nodeId: Int,
              isActive: Boolean = true,
              created: DateTime = DateTime.now,
              createdBy: Int,
              updated: DateTime = DateTime.now,
              updatedBy: Int,
              uuid: Option[String]
             ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type

  override def Id: Int = treeBarId

  override val entityName: String = "AD_TreeBar"
  override val identifier: String = "AD_TreeBar_ID"
}

object TreeBar  {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[TreeBar]
  def create(treeBarId: Int,
             userId: Int,
             nodeId: Int,
             isActive: Boolean,
             created: DateTime,
             createdBy: Int,
             updated: DateTime,
             updatedBy: Int,
             uuid: String) = TreeBar(treeBarId, userId, nodeId, isActive, created, createdBy, updated,
    updatedBy, None)
}