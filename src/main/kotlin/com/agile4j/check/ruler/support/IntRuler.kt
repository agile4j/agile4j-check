package com.agile4j.check.ruler.support

import com.agile4j.check.CheckResultCodeEnum.INT_EQ_FAIL
import com.agile4j.check.CheckResultCodeEnum.INT_GTE_FAIL
import com.agile4j.check.CheckResultCodeEnum.INT_GT_FAIL
import com.agile4j.check.CheckResultCodeEnum.INT_LTE_FAIL
import com.agile4j.check.CheckResultCodeEnum.INT_LT_FAIL
import com.agile4j.check.CheckResultCodeEnum.INT_NOT_NULL_FAIL
import com.agile4j.check.CheckResultCodeEnum.INT_NULL_FAIL
import com.agile4j.check.and
import com.agile4j.check.ruler.Ruler
import com.agile4j.utils.util.NumberUtil.isEq
import com.agile4j.utils.util.NumberUtil.isGt
import com.agile4j.utils.util.NumberUtil.isGte
import com.agile4j.utils.util.NumberUtil.isLt
import com.agile4j.utils.util.NumberUtil.isLte

/**
 * @author: liurenpeng
 * @date: Created in 18-7-13
 */
object IntRuler {
    val notNull = notNull()
    val beNull = beNull()

    fun beNull(code: Long = INT_NULL_FAIL.code, desc: String = INT_NULL_FAIL.desc)
            = Ruler.ofBeNull<Int?>(code, desc)

    fun notNull(code: Long = INT_NOT_NULL_FAIL.code, desc: String = INT_NOT_NULL_FAIL.desc)
            = Ruler.ofNotNull<Int?>(code, desc)

    fun eq(norm: Int, code: Long = INT_EQ_FAIL.code, desc: String = INT_EQ_FAIL.desc)
            = notNull and Ruler.of(norm, code, desc, ::isEq)

    fun gt(norm: Int, code: Long = INT_GT_FAIL.code, desc: String = INT_GT_FAIL.desc)
            = notNull and Ruler.of(norm, code, desc, ::isGt)

    fun gte(norm: Int, code: Long = INT_GTE_FAIL.code, desc: String = INT_GTE_FAIL.desc)
            = notNull and Ruler.of(norm, code, desc, ::isGte)

    fun lt(norm: Int, code: Long = INT_LT_FAIL.code, desc: String = INT_LT_FAIL.desc)
            = notNull and Ruler.of(norm, code, desc, ::isLt)

    fun lte(norm: Int, code: Long = INT_LTE_FAIL.code, desc: String = INT_LTE_FAIL.desc)
            = notNull and Ruler.of(norm, code, desc, ::isLte)
}