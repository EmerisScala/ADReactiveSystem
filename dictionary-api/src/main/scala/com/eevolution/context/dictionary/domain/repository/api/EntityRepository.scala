package com.eevolution.context.dictionary.domain.repository.api

import java.util.UUID

import com.eevolution.context.dictionary.domain.model.Entity
import com.eevolution.utils.PaginatedSequence

import scala.concurrent.Future

/**
  * Copyright (C) 2003-2017, e-Evolution Consultants S.A. , http://www.e-evolution.com
  * This program is free software: you can redistribute it and/or modify
  * it under the terms of the GNU Affero General Public License as published by
  * the Free Software Foundation, either version 3 of the License, or
  * (at your option) any later version.
  * This program is distributed in the hope that it will be useful,
  * but WITHOUT ANY WARRANTY; without even the implied warranty of
  * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  * GNU Affero General Public License for more details.
  * You should have received a copy of the GNU Affero General Public License
  * along with this program.  If not, see <http://www.gnu.org/licenses/>.
  * Email: victor.perez@e-evolution.com, http://www.e-evolution.com , http://github.com/e-Evolution
  * Created by victor.perez@e-evolution.com , www.e-evolution.com
  */
trait EntityRepository {

  def getAll() : Future[List[Entity]]

  def getEntityById(id: Int): Future[Entity]

  def getEntityByUUID(uuid: UUID): Future[Entity]

  def getEntities(page: Int, pageSize: Int): Future[PaginatedSequence[Entity]]
}