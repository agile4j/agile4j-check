package com.agile4j.check.ruler

import com.agile4j.check.CheckException
import com.agile4j.check.alias
import com.agile4j.check.must
import com.agile4j.check.ruler.support.MapRuler.notContainsNullKey
import com.agile4j.check.ruler.support.MapRuler.notEmpty
import com.agile4j.check.ruler.support.MapRuler.notNull
import com.agile4j.check.ruler.support.MapRuler.beNull
import com.agile4j.check.ruler.support.MapRuler.sizeEq
import com.agile4j.check.ruler.support.MapRuler.sizeGt
import com.agile4j.check.ruler.support.MapRuler.sizeGte
import com.agile4j.check.ruler.support.MapRuler.sizeLt
import com.agile4j.check.ruler.support.MapRuler.sizeLte
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException

class MapRulerTest {

    @get:Rule
    val thrown: ExpectedException = ExpectedException.none()

    private val map: Map<String, String> = mapOf("1" to "one", "2" to "two")

    @Test
    fun nullValTest() {
        var temp: Map<*, *>? = null
        temp must beNull

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-15008, desc=temp必须为Null")
        temp = map
        temp alias "temp" must beNull
    }

    @Test
    fun notNullTest() {
        var temp: Map<*, *>? = map
        temp must notNull

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-15007, desc=temp不能为Null")
        temp = null
        temp alias "temp" must notNull
    }

    @Test
    fun notEmptyTest() {
        var temp: Map<*, *>? = map
        temp must notEmpty

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-15000, desc=temp不能为空")
        temp = emptyMap<String, String>()
        temp alias "temp" must notEmpty
    }

    @Test
    fun keyNotContainsNullTest() {
        var temp: Map<*, *>? = map
        temp must notContainsNullKey

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-15006, desc=temp中不能有空值")
        temp = mapOf(null to "null", "1" to "one")
        temp alias "temp" must notContainsNullKey
    }

    @Test
    fun sizeEqTest() {
        map must sizeEq(2)

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-15001, desc=map的长度必须等于1")
        map alias "map" must sizeEq(1)
    }

    @Test
    fun sizeGtTest() {
        map must sizeGt(1)

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-15002, desc=map的长度必须大于2")
        map alias "map" must sizeGt(2)
    }

    @Test
    fun sizeGteTest() {
        map must sizeGte(2)

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-15003, desc=map的长度必须大于或等于3")
        map alias "map" must sizeGte(3)
    }

    @Test
    fun sizeLtTest() {
        map must sizeLt(3)

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-15004, desc=map的长度必须小于2")
        map alias "map" must sizeLt(2)
    }

    @Test
    fun sizeLteTest() {
        map must sizeLte(2)

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-15005, desc=map的长度必须小于或等于1")
        map alias "map" must sizeLte(1)
    }
}