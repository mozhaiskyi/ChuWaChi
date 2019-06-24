package com.mmozhaiskyi.chuwachi

import com.mmozhaiskyi.chuwachi.game.Member
import com.mmozhaiskyi.chuwachi.game.ShuffleType
import org.junit.Test

class ShuffleTypeTest {

    @Test
    fun oneVsOneWorkCorrectlyWithPerfectSet() {
        val type = ShuffleType.OneVsOne

        val members = setOf(Member("1"), Member("2"))

        val result = type.shuffle(members)

        result.opponents.flatMap { listOf(it.first.members,it.second.members) }.forEach {
            assert(it.size == 1) { "Split per team work incorrectly" }
        }

        assert(result.losers.isEmpty()) { "Select looser work incorrectly" }
    }

    @Test
    fun oneVsOneWorkCorrectlyWithNonPerfectSet() {
        val type = ShuffleType.OneVsOne

        val members = setOf(Member("1"), Member("2"), Member("3"))

        val result = type.shuffle(members)

        result.opponents.flatMap { listOf(it.first.members, it.second.members) }.forEach {
            assert(it.size == 1) { "Split per team work incorrectly" }
        }

        assert(result.losers.size == 1) { "Select looser work incorrectly" }
    }

    @Test
    fun twoVsTwoWorkCorrectlyWithPerfectSet() {
        val type = ShuffleType.TwoVsTwo

        val members = setOf(Member("1"), Member("2"), Member("3"), Member("4"))

        val result = type.shuffle(members)

        result.opponents.flatMap { listOf(it.first.members, it.second.members) }.forEach {
            assert(it.size == 2) { "Split per team work incorrectly" }
        }

        assert(result.losers.isEmpty()) { "Select looser work incorrectly" }
    }

    @Test
    fun twoVsTwoWorkCorrectlyWithNonPerfectSet() {
        val type = ShuffleType.TwoVsTwo

        val members1 = setOf(Member("1"), Member("2"), Member("3"), Member("4"), Member("5"))

        val result1 = type.shuffle(members1)

        result1.opponents.flatMap { listOf(it.first.members, it.second.members) }.forEach {
            assert(it.size == 2) { "Split per team work incorrectly" }
        }

        assert(result1.losers.size == 1) { "Select looser work incorrectly" }



        val members2 = setOf(Member("1"), Member("2"), Member("3"), Member("4"), Member("5"), Member("6"))

        val result2 = type.shuffle(members2)

        result2.opponents.flatMap { listOf(it.first.members, it.second.members) }.forEach {
            assert(it.size == 2) { "Split per team work incorrectly" }
        }

        assert(result2.losers.size == 2) { "Select looser work incorrectly" }


        val members3 = setOf(Member("1"), Member("2"), Member("3"), Member("4"), Member("5"), Member("6"), Member("7"))

        val result3 = type.shuffle(members3)

        println(result3)

        result3.opponents.flatMap { listOf(it.first.members, it.second.members) }.forEach {
            assert(it.size == 2) { "Split per team work incorrectly" }
        }
        assert(result3.losers.size == 3) { "Select looser work incorrectly" }
    }
}
