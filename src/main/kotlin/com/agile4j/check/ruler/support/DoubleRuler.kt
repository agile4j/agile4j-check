package com.agile4j.check.ruler.support

import com.agile4j.check.CheckResultCodeEnum.DOUBLE_EQ_FAIL
import com.agile4j.check.CheckResultCodeEnum.DOUBLE_GTE_FAIL
import com.agile4j.check.CheckResultCodeEnum.DOUBLE_GT_FAIL
import com.agile4j.check.CheckResultCodeEnum.DOUBLE_LTE_FAIL
import com.agile4j.check.CheckResultCodeEnum.DOUBLE_LT_FAIL
import com.agile4j.check.CheckResultCodeEnum.DOUBLE_NOT_NULL_FAIL
import com.agile4j.check.CheckResultCodeEnum.DOUBLE_NULL_FAIL
import com.agile4j.check.and
import com.agile4j.check.ruler.Ruler
import com.agile4j.utils.util.NumberUtil

object DoubleRuler {
    val notNull = notNull()
    val beNull = beNull()

    fun beNull(code: Long = DOUBLE_NULL_FAIL.code, desc: String = DOUBLE_NULL_FAIL.desc)
            = Ruler.ofBeNull<Double?>(code, desc)

    fun notNull(code: Long = DOUBLE_NOT_NULL_FAIL.code, desc: String = DOUBLE_NOT_NULL_FAIL.desc)
            = Ruler.ofNotNull<Double?>(code, desc)

    fun eq(norm: Double, code: Long = DOUBLE_EQ_FAIL.code, desc: String = DOUBLE_EQ_FAIL.desc)
            = notNull and Ruler.of(norm, code, desc, NumberUtil::isEq)

    fun gt(norm: Double, code: Long = DOUBLE_GT_FAIL.code, desc: String = DOUBLE_GT_FAIL.desc)
            = notNull and Ruler.of(norm, code, desc, NumberUtil::isGt)

    fun gte(norm: Double, code: Long = DOUBLE_GTE_FAIL.code, desc: String = DOUBLE_GTE_FAIL.desc)
            = notNull and Ruler.of(norm, code, desc, NumberUtil::isGte)

    fun lt(norm: Double, code: Long = DOUBLE_LT_FAIL.code, desc: String = DOUBLE_LT_FAIL.desc)
            = notNull and Ruler.of(norm, code, desc, NumberUtil::isLt)

    fun lte(norm: Double, code: Long = DOUBLE_LTE_FAIL.code, desc: String = DOUBLE_LTE_FAIL.desc)
            = notNull and Ruler.of(norm, code, desc, NumberUtil::isLte)
}