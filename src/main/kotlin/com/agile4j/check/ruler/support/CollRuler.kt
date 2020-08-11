package com.agile4j.check.ruler.support

import com.agile4j.check.CheckResultCodeEnum.COLL_NOT_CONTAINS_DUP_FAIL
import com.agile4j.check.CheckResultCodeEnum.COLL_NOT_CONTAINS_NULL_FAIL
import com.agile4j.check.CheckResultCodeEnum.COLL_NOT_EMPTY_FAIL
import com.agile4j.check.CheckResultCodeEnum.COLL_NOT_NULL_FAIL
import com.agile4j.check.CheckResultCodeEnum.COLL_NULL_FAIL
import com.agile4j.check.CheckResultCodeEnum.COLL_SIZE_EQ_FAIL
import com.agile4j.check.CheckResultCodeEnum.COLL_SIZE_GTE_FAIL
import com.agile4j.check.CheckResultCodeEnum.COLL_SIZE_GT_FAIL
import com.agile4j.check.CheckResultCodeEnum.COLL_SIZE_LTE_FAIL
import com.agile4j.check.CheckResultCodeEnum.COLL_SIZE_LT_FAIL
import com.agile4j.check.and
import com.agile4j.check.ruler.Ruler
import com.agile4j.utils.util.CollectionUtil.isNotContainsDup
import com.agile4j.utils.util.CollectionUtil.isNotContainsNull
import com.agile4j.utils.util.CollectionUtil.isNotEmpty
import com.agile4j.utils.util.CollectionUtil.isSizeEq
import com.agile4j.utils.util.CollectionUtil.isSizeGt
import com.agile4j.utils.util.CollectionUtil.isSizeGte
import com.agile4j.utils.util.CollectionUtil.isSizeLt
import com.agile4j.utils.util.CollectionUtil.isSizeLte

object CollRuler {
    val beNull = beNull()
    val notNull = notNull()
    val notEmpty = notEmpty()
    val notContainsNull = notContainsNull()
    val notContainsDup = notContainsDup()

    fun beNull(code: Long = COLL_NULL_FAIL.code, desc: String = COLL_NULL_FAIL.desc)
            = Ruler.ofBeNull<Collection<*>?>(code, desc)

    fun notNull(code: Long = COLL_NOT_NULL_FAIL.code, desc: String = COLL_NOT_NULL_FAIL.desc)
            = Ruler.ofNotNull<Collection<*>?>(code, desc)

    fun notEmpty(code: Long = COLL_NOT_EMPTY_FAIL.code, desc: String = COLL_NOT_EMPTY_FAIL.desc)
            = notNull and Ruler.of(code, desc, ::isNotEmpty)

    fun sizeEq(norm: Int, code: Long = COLL_SIZE_EQ_FAIL.code, desc: String = COLL_SIZE_EQ_FAIL.desc)
            = notNull and Ruler.of(norm, code, desc, ::isSizeEq)

    fun sizeGt(norm: Int, code: Long = COLL_SIZE_GT_FAIL.code, desc: String = COLL_SIZE_GT_FAIL.desc)
            = notNull and Ruler.of(norm, code, desc, ::isSizeGt)

    fun sizeGte(norm: Int, code: Long = COLL_SIZE_GTE_FAIL.code, desc: String = COLL_SIZE_GTE_FAIL.desc)
            = notNull and Ruler.of(norm, code, desc, ::isSizeGte)

    fun sizeLt(norm: Int, code: Long = COLL_SIZE_LT_FAIL.code, desc: String = COLL_SIZE_LT_FAIL.desc)
            = notNull and Ruler.of(norm, code, desc, ::isSizeLt)

    fun sizeLte(norm: Int, code: Long = COLL_SIZE_LTE_FAIL.code, desc: String = COLL_SIZE_LTE_FAIL.desc)
            = notNull and Ruler.of(norm, code, desc, ::isSizeLte)

    fun notContainsNull(code: Long = COLL_NOT_CONTAINS_NULL_FAIL.code, desc: String = COLL_NOT_CONTAINS_NULL_FAIL.desc)
            = notNull and Ruler.of(code, desc, ::isNotContainsNull)

    fun notContainsDup(code: Long = COLL_NOT_CONTAINS_DUP_FAIL.code, desc: String = COLL_NOT_CONTAINS_DUP_FAIL.desc)
            = notNull and Ruler.of(code, desc, ::isNotContainsDup)

}