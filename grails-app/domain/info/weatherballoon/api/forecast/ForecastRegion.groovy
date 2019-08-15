package info.weatherballoon.api.forecast

class ForecastRegion {
    String code
    String parentCode
    String regionType
    String country
    String state
    String name
    static hasMany = [forecasts:Forecast]
}
