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

package com.github.paulschaaf.gargoyle.model

interface IFDBStory {
  val author: String?
  val averageRating: Double?
  val contact: String?
  val coverArtURL: String?
  val description: String?
  val firstPublished: String?
  val forgiveness: String?
  val genre: String?
  val ifId: String
  val language: String?
  val link: String?
  val path: String?
  val ratingCountAvg: Int?
  val ratingCountTotal: Int?
  val series: String?
  val seriesNumber: Int?
  val starRating: Double?
  val title: String
  val tuid: String
}
