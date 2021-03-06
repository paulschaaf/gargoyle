/*
 * Copyright © 2018 P.G. Schaaf <paul.schaaf@gmail.com>
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

package com.github.paulschaaf.gargoyle.microtests

import android.support.test.runner.AndroidJUnit4
import com.github.paulschaaf.gargoyle.StoryXMLTest
import com.github.paulschaaf.gargoyle.assertThat
import com.github.paulschaaf.gargoyle.ifdb.IFDBXmlParser
import org.fest.assertions.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class IFDBXmlParserTest {
  @Test
  fun sanityCheckEnsureExampleStoryFieldsAreNotEmpty() {
    val storyXML = StoryXMLTest.Bronze

    assertThat(storyXML["author"]).isNotNull
    assertThat(storyXML["averageRating"]).isNotNull
    assertThat(storyXML["contact"]).isNotNull
    assertThat(storyXML["coverArtURL"]).isNotNull
    assertThat(storyXML["description"]).isNotNull
    assertThat(storyXML["genre"]).isNotNull
    assertThat(storyXML["ifId"]).isNotNull
    assertThat(storyXML["language"]).isNotNull
    assertThat(storyXML["link"]).isNotNull
    assertThat(storyXML["ratingCountAvg"]).isNotNull
    assertThat(storyXML["ratingCountTotal"]).isNotNull
    assertThat(storyXML["series"]).isNotNull
    assertThat(storyXML["starRating"]).isNotNull
    assertThat(storyXML["title"]).isNotNull
    assertThat(storyXML["tuid"]).isNotNull
    assertThat(storyXML["url"]).isNotNull
  }

  @Test
  fun testBronze() = testStory(StoryXMLTest.Bronze)

  @Test
  fun testLostPig() = testStory(StoryXMLTest.LostPig)

  @Test
  fun testSpellBreaker() = testStory(StoryXMLTest.SpellBreaker)

  @Test
  fun testViolet() = testStory(StoryXMLTest.Violet)

  @Test
  fun testZorkI() = testStory(StoryXMLTest.ZorkI)

  @Test
  fun testNullFields() = testStory(StoryXMLTest.Zork_nullFields)

  @Test
  fun testSpecialChars() = testStory(StoryXMLTest.ZorkI_specialChars)

  private fun testStory(testStoryXml: StoryXMLTest) {
    val story = IFDBXmlParser().parse(testStoryXml.xmlString.byteInputStream())
    assertThat(story).isDescribedBy(testStoryXml)
  }
}
