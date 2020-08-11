package com.agile4j.check.ruler.support

import com.agile4j.check.CheckResultCodeEnum.ANY_NOT_NULL_FAIL
import com.agile4j.check.CheckResultCodeEnum.ANY_NULL_FAIL
import com.agile4j.check.ruler.Ruler

object AnyRuler {
    val beNull = beNull()
    val notNull = notNull()

    fun beNull(code: Long = ANY_NULL_FAIL.code, desc: String = ANY_NULL_FAIL.desc)
            = Ruler.ofBeNull<Any?>(code, desc)

    fun notNull(code: Long = ANY_NOT_NULL_FAIL.code, desc: String = ANY_NOT_NULL_FAIL.desc)
            = Ruler.ofNotNull<Any?>(code, desc)
}