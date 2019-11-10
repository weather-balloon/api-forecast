package info.weatherballoon.api.forecast

class ForecastPeriod {
    static belongsTo = [forecast:Forecast]
    Date startTimeUtc
    Date endTimeUtc
    int iconCode
    String precis
    int maxTemp
    int minTemp
    int percentChancePrecipitation
}

class Forecast {
    static belongsTo = [region:ForecastRegion]
    Date issueTimeUtc
    Date nextIssueTimeUtc
    List forecastPeriods
    static hasMany = [forecastPeriods: ForecastPeriod]

    static constraints = {
    }
}
