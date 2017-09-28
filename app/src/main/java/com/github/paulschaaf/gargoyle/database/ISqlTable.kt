/*
 * Copyright © 2017 P.G. Schaaf <paul.schaaf@gmail.com>
 * This file is part of Gargoyle.
 * Gargoyle is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.github.paulschaaf.gargoyle.database

interface ISqlTable {
  val columns: MutableMap<String, IColumn<*>>
  val tableName: String

  val createSQL: String
    get() = columns.values
      .map { column-> column.createSQL }
      .joinToString(
          prefix = "CREATE TABLE $tableName (",
          separator = ", ",
          postfix = ");"
      )

  fun addColumn(column: IColumn<*>) = columns.put(column.name, column)
}

