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

import android.content.ContentValues
import com.github.paulschaaf.gargoyle.database.IColumn
import com.github.paulschaaf.gargoyle.database.StoryTable
import set
import java.io.File
import java.io.RandomAccessFile
import java.util.*
import kotlin.reflect.KProperty
import kotlin.reflect.full.memberProperties

class Story constructor(val contentValues: ContentValues): IFDBStory {
  constructor(): this(ContentValues()) {
    lookedUp = Date().toString()
  }

  override fun toString() = title + " #" + ifId

  val exists: Boolean
    get() = file?.exists() == true

  var file: File?
    get() = if (path == null) null else File(path)
    set(value) {
      path = value?.path
    }

  val versionNumber: Int
    get() = RandomAccessFile(path, "r").use { it.readInt() }

  val zCodeVersion
    get() = when (versionNumber) {
      0    -> "0 (unknown)"
      70   -> "unknown (blorbed)"
      else -> versionNumber.toString()
    }

  fun toContentValues(): ContentValues {
    val cv = ContentValues()
    IFDBStory::class.memberProperties.forEach { prop->
      cv.set(prop.name, prop.get(this))
    }
    return cv
  }

  var id by StoryTable.id
  override var author by StoryTable.author
  override var averageRating by StoryTable.averageRating
  override var contact by StoryTable.contact
  override var coverArtURL by StoryTable.coverArtURL
  override var description by StoryTable.description
  override var firstPublished by StoryTable.firstPublished
  override var forgiveness by StoryTable.forgiveness
  override var genre by StoryTable.genre
  override var ifId by StoryTable.ifId
  override var language by StoryTable.language
  override var link by StoryTable.link
  var lookedUp by StoryTable.lookedUp
  override var path by StoryTable.path
  override var ratingCountAvg by StoryTable.ratingCountAvg
  override var ratingCountTotal by StoryTable.ratingCountTotal
  override var series by StoryTable.series
  override var seriesNumber by StoryTable.seriesNumber
  override var starRating by StoryTable.starRating
  override var title by StoryTable.title
  override var tuid by StoryTable.tuid
}

// Allows an IColumn wrapping my contentValues to be a delegate for my IFDBStory properties
operator fun <T> IColumn<T>.getValue(story: Story, property: KProperty<*>): T
    = get(story.contentValues)

operator fun <T> IColumn<T>.setValue(story: Story, property: KProperty<*>, value: T)
    = set(story.contentValues, value)

