package com.agile4j.check.ruler.support

import com.agile4j.check.CheckResultCodeEnum.FLOAT_EQ_FAIL
import com.agile4j.check.CheckResultCodeEnum.FLOAT_GTE_FAIL
import com.agile4j.check.CheckResultCodeEnum.FLOAT_GT_FAIL
import com.agile4j.check.CheckResultCodeEnum.FLOAT_LTE_FAIL
import com.agile4j.check.CheckResultCodeEnum.FLOAT_LT_FAIL
import com.agile4j.check.CheckResultCodeEnum.FLOAT_NOT_NULL_FAIL
import com.agile4j.check.CheckResultCodeEnum.FLOAT_NULL_FAIL
import com.agile4j.check.and
import com.agile4j.check.ruler.Ruler
import com.agile4j.utils.util.NumberUtil

object FloatRuler {
    val notNull = notNull()
    val beNull = beNull()

    fun beNull(code: Long = FLOAT_NULL_FAIL.code, desc: String = FLOAT_NULL_FAIL.desc)
            = Ruler.ofBeNull<Float?>(code, desc)

    fun notNull(code: Long = FLOAT_NOT_NULL_FAIL.code, desc: String = FLOAT_NOT_NULL_FAIL.desc)
            = Ruler.ofNotNull<Float?>(code, desc)

    fun eq(norm: Float, code: Long = FLOAT_EQ_FAIL.code, desc: String = FLOAT_EQ_FAIL.desc)
            = notNull and Ruler.of(norm, code, desc, NumberUtil::isEq)

    fun gt(norm: Float, code: Long = FLOAT_GT_FAIL.code, desc: String = FLOAT_GT_FAIL.desc)
            = notNull and Ruler.of(norm, code, desc, NumberUtil::isGt)

    fun gte(norm: Float, code: Long = FLOAT_GTE_FAIL.code, desc: String = FLOAT_GTE_FAIL.desc)
            = notNull and Ruler.of(norm, code, desc, NumberUtil::isGte)

    fun lt(norm: Float, code: Long = FLOAT_LT_FAIL.code, desc: String = FLOAT_LT_FAIL.desc)
            = notNull and Ruler.of(norm, code, desc, NumberUtil::isLt)

    fun lte(norm: Float, code: Long = FLOAT_LTE_FAIL.code, desc: String = FLOAT_LTE_FAIL.desc)
            = notNull and Ruler.of(norm, code, desc, NumberUtil::isLte)
}