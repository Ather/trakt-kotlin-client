package media.thehoard.thirdparty.api.trakt.extensions

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

fun <T : Enum<T>> Enum<T>?.validateSpecified(variableName: String, errorMessage: String? = "must not be unspecified") = (this.toString() != "UNSPECIFIED").validate(variableName, errorMessage)

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