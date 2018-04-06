package media.thehoard.thirdparty.api.trakt

import media.thehoard.thirdparty.api.trakt.authentication.TraktAuthorization
import java.time.Instant
import java.time.ZoneId
import java.time.ZonedDateTime

fun main(args: Array<String>) {
    val client = TraktClient("adf2c0b5b1bc70425e37ec8ba0730a26bbdde59061c393270c724b3fdc6f1d75").apply {
        authorization = TraktAuthorization.createWith(
                accessToken = "37367b0ead2ededef06d6d459cd5d4354bb187f8e8fe07076d6b77cb18790b34",
                expiresInSeconds = 7776000,
                refreshToken = "66aed085a60de7c19d6f85d4f533c8f0c07208891adedaf30bdfd68820ffb265",
                createdAt = ZonedDateTime.ofInstant(Instant.ofEpochSecond(1522900232), ZoneId.systemDefault())
        )
    }

    val startDate = ZonedDateTime.now().minusDays(10)

    val result = client.calendars.getUserSeasonPremiereAsync(
            startDate,
            10
    ).get()

    println(result[0].toString())

    println(result.forEach(::println))
}