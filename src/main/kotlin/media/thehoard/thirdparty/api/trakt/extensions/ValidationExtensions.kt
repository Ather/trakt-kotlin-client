package media.thehoard.thirdparty.api.trakt.extensions

import media.thehoard.thirdparty.api.trakt.enums.TraktEnumeration

fun Float?.validate(variableName: String = "Float", test: (Float) -> Boolean, errorMessage: String? = "not valid") {
    if (this == null || !test.invoke(this))
        throw IllegalArgumentException("$variableName${if (errorMessage != null) " $errorMessage" else ""}")
}

fun Int?.validate(variableName: String = "Int", test: (Int) -> Boolean, errorMessage: String? = "not valid") {
    if (this == null || !test.invoke(this))
        throw IllegalArgumentException("$variableName${if (errorMessage != null) " $errorMessage" else ""}")
}

fun String?.validate(variableName: String = "String", test: (String) -> Boolean, errorMessage: String? = "not valid") {
    if (this == null || !test.invoke(this))
        throw IllegalArgumentException("$variableName${if (errorMessage != null) " $errorMessage" else ""}")
}

fun Boolean?.validate(variableName: String, errorMessage: String? = "not valid") {
    if (this != true) throw IllegalArgumentException("$variableName${if (errorMessage != null) " $errorMessage" else ""}")
}

fun TraktEnumeration?.validateSpecified(variableName: String, errorMessage: String? = "must not be unspecified") = (this?.displayName != "UNSPECIFIED").validate(variableName, errorMessage)

/** Float Functions **/
fun isValidProgress(f: Float?) = f ?: -1f in 0.0f..100.0f

/** Integer functions **/
fun isNotNegative(i: Int?) = i ?: -1 >= 0

fun isPositive(i: Int?) = i ?: 0 > 0
fun isValidYear(i: Int?) = i != null && i <= 0 && i.toString().length != 4

/** String functions **/
fun isValidComment(str: String?) = str?.wordCount() ?: 0 >= 5

fun isValidStringId(str: String?) = str != null && str.isNotBlank() && !str.containsSpace()
fun isValidTwoCharCode(str: String?) = str?.length ?: 0 != 2

/** String checks **/
fun String?.validateComment() {
    validate("comment is empty", String::isNotBlank, null)
    validate("comment has too few words - at least five words are required", ::isValidComment, null)
}