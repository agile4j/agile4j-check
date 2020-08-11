package com.agile4j.check.ruler.support

import com.agile4j.check.CheckResultCodeEnum.STR_ALL_LETTER_FAIL
import com.agile4j.check.CheckResultCodeEnum.STR_DIGIT_FAIL
import com.agile4j.check.CheckResultCodeEnum.STR_EMAIL_FAIL
import com.agile4j.check.CheckResultCodeEnum.STR_EMPTY_FAIL
import com.agile4j.check.CheckResultCodeEnum.STR_EQ_FAIL
import com.agile4j.check.CheckResultCodeEnum.STR_ID_CARD_FAIL
import com.agile4j.check.CheckResultCodeEnum.STR_LENGTH_EQ_FAIL
import com.agile4j.check.CheckResultCodeEnum.STR_LENGTH_GTE_FAIL
import com.agile4j.check.CheckResultCodeEnum.STR_LENGTH_GT_FAIL
import com.agile4j.check.CheckResultCodeEnum.STR_LENGTH_LTE_FAIL
import com.agile4j.check.CheckResultCodeEnum.STR_LENGTH_LT_FAIL
import com.agile4j.check.CheckResultCodeEnum.STR_NOT_EMPTY_FAIL
import com.agile4j.check.CheckResultCodeEnum.STR_NOT_NULL_FAIL
import com.agile4j.check.CheckResultCodeEnum.STR_NULL_FAIL
import com.agile4j.check.CheckResultCodeEnum.STR_PHONE_FAIL
import com.agile4j.check.CheckResultCodeEnum.STR_STANDARD_DATETIME_FAIL
import com.agile4j.check.CheckResultCodeEnum.STR_STANDARD_DATE_FAIL
import com.agile4j.check.CheckResultCodeEnum.STR_URL_FAIL
import com.agile4j.check.and
import com.agile4j.check.ruler.Ruler
import com.agile4j.utils.util.StringUtil.isAllLetter
import com.agile4j.utils.util.StringUtil.isDigit
import com.agile4j.utils.util.StringUtil.isEmail
import com.agile4j.utils.util.StringUtil.isEmpty
import com.agile4j.utils.util.StringUtil.isEq
import com.agile4j.utils.util.StringUtil.isIdCard
import com.agile4j.utils.util.StringUtil.isLengthEq
import com.agile4j.utils.util.StringUtil.isLengthGt
import com.agile4j.utils.util.StringUtil.isLengthGte
import com.agile4j.utils.util.StringUtil.isLengthLt
import com.agile4j.utils.util.StringUtil.isLengthLte
import com.agile4j.utils.util.StringUtil.isNotEmpty
import com.agile4j.utils.util.StringUtil.isPhone
import com.agile4j.utils.util.StringUtil.isStandardDate
import com.agile4j.utils.util.StringUtil.isStandardDatetime
import com.agile4j.utils.util.StringUtil.isUrl

/**
 * @author: liurenpeng
 * @date: Created in 18-7-12
 */
object StrRuler {
    val beNull = beNull()
    val notNull = notNull()
    val beEmpty = beEmpty()
    val notEmpty = notEmpty()

    val beIdCard = beIdCard()
    val beEmail = beEmail()
    val bePhone = bePhone()
    val beStandardDate = beStandardDate()
    val beStandardDatetime = beStandardDatetime()
    val beUrl = beUrl()
    val beAllLetter = beAllLetter()
    val beDigit = beDigit()

    fun beNull(code: Long = STR_NULL_FAIL.code, desc: String = STR_NULL_FAIL.desc)
            = Ruler.ofBeNull<String?>(code, desc)

    fun notNull(code: Long = STR_NOT_NULL_FAIL.code, desc: String = STR_NOT_NULL_FAIL.desc)
            = Ruler.ofNotNull<String?>(code, desc)

    fun beEmpty(code: Long = STR_EMPTY_FAIL.code, desc: String = STR_EMPTY_FAIL.desc)
            = notNull and Ruler.of(code, desc, ::isEmpty)

    fun notEmpty(code: Long = STR_NOT_EMPTY_FAIL.code, desc: String = STR_NOT_EMPTY_FAIL.desc)
            = notNull and Ruler.of(code, desc, ::isNotEmpty)

    fun lengthEq(norm: Int, code: Long = STR_LENGTH_EQ_FAIL.code, desc: String = STR_LENGTH_EQ_FAIL.desc)
            = notNull and Ruler.of(norm, code, desc, ::isLengthEq)

    fun lengthGt(norm: Int, code: Long = STR_LENGTH_GT_FAIL.code, desc: String = STR_LENGTH_GT_FAIL.desc)
            = notNull and Ruler.of(norm, code, desc, ::isLengthGt)

    fun lengthGte(norm: Int, code: Long = STR_LENGTH_GTE_FAIL.code, desc: String = STR_LENGTH_GTE_FAIL.desc)
            = notNull and Ruler.of(norm, code, desc, ::isLengthGte)

    fun lengthLt(norm: Int, code: Long = STR_LENGTH_LT_FAIL.code, desc: String = STR_LENGTH_LT_FAIL.desc)
            = notNull and Ruler.of(norm, code, desc, ::isLengthLt)

    fun lengthLte(norm: Int, code: Long = STR_LENGTH_LTE_FAIL.code, desc: String = STR_LENGTH_LTE_FAIL.desc)
            = notNull and Ruler.of(norm, code, desc, ::isLengthLte)

    fun eq(norm: String, code: Long = STR_EQ_FAIL.code, desc: String = STR_EQ_FAIL.desc)
            = notNull and Ruler.of(norm, code, desc, ::isEq)

    fun beIdCard(code: Long = STR_ID_CARD_FAIL.code, desc: String = STR_ID_CARD_FAIL.desc)
            = notNull and Ruler.of(code, desc, ::isIdCard)

    fun beEmail(code: Long = STR_EMAIL_FAIL.code, desc: String = STR_EMAIL_FAIL.desc)
            = notNull and Ruler.of(code, desc, ::isEmail)

    fun bePhone(code: Long = STR_PHONE_FAIL.code, desc: String = STR_PHONE_FAIL.desc)
            = notNull and Ruler.of(code, desc, ::isPhone)

    fun beStandardDate(code: Long = STR_STANDARD_DATE_FAIL.code, desc: String = STR_STANDARD_DATE_FAIL.desc)
            = notNull and Ruler.of(code, desc, ::isStandardDate)

    fun beStandardDatetime(code: Long = STR_STANDARD_DATETIME_FAIL.code, desc: String = STR_STANDARD_DATETIME_FAIL.desc)
            = notNull and Ruler.of(code, desc, ::isStandardDatetime)

    fun beUrl(code: Long = STR_URL_FAIL.code, desc: String = STR_URL_FAIL.desc)
            = notNull and Ruler.of(code, desc, ::isUrl)

    fun beAllLetter(code: Long = STR_ALL_LETTER_FAIL.code, desc: String = STR_ALL_LETTER_FAIL.desc)
            = notNull and Ruler.of(code, desc, ::isAllLetter)

    fun beDigit(code: Long = STR_DIGIT_FAIL.code, desc: String = STR_DIGIT_FAIL.desc)
            = notNull and Ruler.of(code, desc, ::isDigit)
}
