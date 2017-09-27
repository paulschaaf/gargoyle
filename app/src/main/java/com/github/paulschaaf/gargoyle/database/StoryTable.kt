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

object StoryTable: SqlTable {
  override val name = "Story"

  val id by PrimaryKeyColumn
  val ifId by StringColumn.nonNull.unique

  val author by StringColumn
  val coverArtURL by StringColumn
  val description by StringColumn
  val firstPublished by StringColumn
  val forgiveness by StringColumn
  val genre by StringColumn
  val language by StringColumn
  val link by StringColumn
  val lookedUp by StringColumn
  val path by StringColumn
  val series by StringColumn
  val tuid by StringColumn
  val title by StringColumn
  val averageRating by DoubleColumn
  val ratingCountAvg by IntColumn
  val ratingCountTotal by IntColumn
  val seriesNumber by IntColumn
  val starRating by DoubleColumn


  override val columns = mapOf(
      "author" to author,
      "averageRating" to averageRating,
      "coverArtURL" to coverArtURL,
      "description" to description,
      "firstPublished" to firstPublished,
      "forgiveness" to forgiveness,
      "genre" to genre,
      "ifId" to ifId,
      "language" to language,
      "link" to link,
      "path" to path,
      "ratingCountAvg" to ratingCountAvg,
      "ratingCountTotal" to ratingCountTotal,
      "series" to series,
      "seriesNumber" to seriesNumber,
      "starRating" to starRating,
      "tuid" to tuid,
      "title" to title
  )
}
